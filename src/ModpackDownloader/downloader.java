/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModpackDownloader;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
/**
 *
 * @author simonr
 */
public class downloader {
    public static void main(String[] args) throws Throwable {
        final URL url = new URL("http://s3.amazonaws.com/Minecraft.Download/launcher/Minecraft.jar");
        final URLConnection conn = url.openConnection();
        try (InputStream is = new BufferedInputStream(conn.getInputStream())) {
            final OutputStream os;
            os = new BufferedOutputStream(new FileOutputStream("./modpack/Minecraft.jar"));
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

