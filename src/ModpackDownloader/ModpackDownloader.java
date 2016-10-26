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

    public static void main(String[] args) throws MalformedURLException, IOException {

        //Modpack Download
        ModpackDownloader1.URL = GUI.URL + zeile + ".zip";
        ModpackDownloader1.output = "./modpack/modpack.zip";
        ModpackDownloader1.main(null);
        
        UnZip.modpack = "./modpack/modpack.zip";
        UnZip.modpack1 = GUI.datei + "/";
        UnZip.main();
        
    }
}
