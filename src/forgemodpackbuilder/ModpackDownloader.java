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
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

/**
 *
 * @author simonr
 */
public class ModpackDownloader {

    static String install;
    static String modpack = "Xerxes";
    static ArrayList<String> text = new ArrayList<String>();

    public static void main(String[] args) throws MalformedURLException, IOException {

        final URL url = new URL("https://www.dropbox.com/s/n91j0wjb88s8341/URL.txt?dl=1");
        final URLConnection conn = url.openConnection();
        try (InputStream is = new BufferedInputStream(conn.getInputStream())) {
            final OutputStream os;
            os = new BufferedOutputStream(new FileOutputStream("./modpack/Modpacks/URL.txt"));
            byte[] chunk = new byte[1024];
            int chunkSize;
            while ((chunkSize = is.read(chunk)) != -1) {
                os.write(chunk, 0, chunkSize);
            }
            os.flush(); // Necessary for Java < 6
            os.close();

            //Modpack URL Suchen
            FileReader fr = new FileReader("./modpack/Modpacks/URL.txt");
            BufferedReader br = new BufferedReader(fr);

            String zeile = "";

            int b = 0;
            while (!(zeile.equals(modpack))) {
                zeile = br.readLine();
                System.out.println(zeile);
                text.add(zeile);
                b++;
            }
            System.out.println(text.get(b - 2));

            br.close();

            //Modpack Installieren
            ModpackDownloader2.URL = text.get(b - 2);
            ModpackDownloader2.output = "./modpack/Modpacks/Modpack.txt";
            ModpackDownloader2.main(null);
            text.clear();

            FileReader fr1 = new FileReader("./modpack/Modpacks/Modpack.txt");
            BufferedReader br1 = new BufferedReader(fr1);

            String zeile1 = "";

            while ((zeile1 = br1.readLine()) != null) {
                System.out.println(zeile1);

                FileReader fr2 = new FileReader("./modpack/Modpacks/URL.txt");
                BufferedReader br2 = new BufferedReader(fr2);

                b = 0;
                zeile = "";
                while (!(zeile.equals(modpack))) {
                    zeile = br2.readLine();
                    System.out.println(zeile);
                    text.add(zeile);
                    b++;
                }

                br2.close();

                ModpackDownloader2.URL = text.get(b - 2);
                ModpackDownloader2.output = install + "/mods/" + zeile1;
                ModpackDownloader2.main(null);
                text.clear();

            }

            br1.close();

        }
    }
}
