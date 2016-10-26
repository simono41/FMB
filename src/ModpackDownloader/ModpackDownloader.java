/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModpackDownloader;

import Zipper.UnZip;
import forgemodpackbuilder.GUI;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;

/**
 *
 * @author simonr
 */
public class ModpackDownloader {

    static int mods = 0;
    public static String zeile = "";
    public static String version;

    public static void main(String[] args) throws MalformedURLException, IOException {

        //Modpack-Config Download
        ModpackDownloader2.URL = GUI.URL + zeile + ".zip";
        ModpackDownloader2.output = "./modpack/modpack.zip";
        ModpackDownloader2.main(null);
        
        UnZip.modpack = "./modpack/modpack.zip";
        UnZip.modpack1 = GUI.datei + "/";

        //Modpack URL Suchen
        ModpackDownloader2.URL = GUI.URL + zeile;
        ModpackDownloader2.output = "./modpack/modpack.txt";
        ModpackDownloader2.main(null);

        //Progressbar Modpack durchsuchen
        FileReader fr = new FileReader("./modpack/modpack.txt");
        BufferedReader br = new BufferedReader(fr);

        while ((zeile = br.readLine()) != null) {
            mods++;
        }
        System.out.println("Mods = " + mods);

        //Modpack Installieren
        FileReader fr1 = new FileReader("./modpack/modpack.txt");
        BufferedReader br1 = new BufferedReader(fr1);

        version = br1.readLine();

        while ((zeile = br1.readLine()) != null) {
            ModpackDownloader2.URL = GUI.URL + "mods/" + version + "/" + zeile;
            ModpackDownloader2.output = GUI.datei + "/mods/" + zeile;
            ModpackDownloader2.main(null);

            System.out.println("URL = " + GUI.URL + version + "/" + zeile);
            System.out.println("Output = " + GUI.datei + "/mods/" + zeile);

            //Progressbar
            GUI.zahl = mods;
            GUI.datei1 = zeile;
            GUI c = new GUI();
            c.progressnext();
        }
    }
}
