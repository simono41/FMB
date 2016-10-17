/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgemodpackbuilder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author simonr
 */


public class downloader1 {

    public static void main(String[] args) throws Throwable {

        String forge10 = "https://files.minecraftforge.net/maven/net/minecraftforge/forge/1.10.2-12.18.2.2107/forge-1.10.2-12.18.2.2107-installer.jar";
        String forge9 = "https://files.minecraftforge.net/maven/net/minecraftforge/forge/1.9.4-12.17.0.2051/forge-1.9.4-12.17.0.2051-installer.jar";
        String forge8 = "https://files.minecraftforge.net/maven/net/minecraftforge/forge/1.8.9-11.15.1.1902-1.8.9/forge-1.8.9-11.15.1.1902-1.8.9-installer.jar";
        String forge7 = "https://files.minecraftforge.net/maven/net/minecraftforge/forge/1.7.10-10.13.4.1614-1.7.10/forge-1.7.10-10.13.4.1614-1.7.10-installer.jar";

        String total = "";

        if (GUI.version.equals("1.10.2")) {
            total = forge10;
        }
        if (GUI.version.equals("1.9.4")) {
            total = forge9;
        }
        if (GUI.version.equals("1.8.9")) {
            total = forge8;
        }
        if (GUI.version.equals("1.7.10")) {
            total = forge7;
        }

        final URL url = new URL(total);
        final URLConnection conn = url.openConnection();
        try (InputStream is = new BufferedInputStream(conn.getInputStream())) {
            final OutputStream os;
            os = new BufferedOutputStream(new FileOutputStream("./modpack/" + GUI.version + "/" + total.substring(total.lastIndexOf("/") + 1)));
            byte[] chunk = new byte[1024];
            int chunkSize;
            while ((chunkSize = is.read(chunk)) != -1) {
                os.write(chunk, 0, chunkSize);
            }
            os.flush(); // Necessary for Java < 6
            os.close();
        }
    }
}
