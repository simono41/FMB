/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgemodpackbuilder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author simonr
 */
public class ModpackSuche {

    public static void main(String[] args) throws IOException {

        final URL url = new URL("https://www.dropbox.com/s/fjy9lnv5ga00hq4/Modpacks.txt?dl=1");
        final URLConnection conn = url.openConnection();
        try (InputStream is = new BufferedInputStream(conn.getInputStream())) {
            final OutputStream os;
            os = new BufferedOutputStream(new FileOutputStream("./modpack/Modpacks/Modpacks.txt"));
            byte[] chunk = new byte[1024];
            int chunkSize;
            while ((chunkSize = is.read(chunk)) != -1) {
                os.write(chunk, 0, chunkSize);
            }
            os.flush(); // Necessary for Java < 6
            os.close();

            // Datei durchsuchen
            FileReader fr = new FileReader("./modpack/Modpacks/Modpacks.txt");
            BufferedReader br = new BufferedReader(fr);
            String zeile;

            while ((zeile = br.readLine()) != null) {
                GUI.mods0.add(zeile);
            }
            System.out.println("Zeilen = " + GUI.mods0.size());

            for (int i = 0; i < GUI.mods0.size(); i++) {
                System.out.println(GUI.mods0.get(i));
            }
            br.close();

        }

    }
}
