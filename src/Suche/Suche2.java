/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Suche;

/**
 *
 * @author simonr
 */
import java.io.File;

public class Suche2 {

    public static String filename;

    public static void main(String[] args) {

        File f = new File("./modpack/modpack");
        File[] fileArray = f.listFiles();

        if (fileArray != null) { // Erforderliche Berechtigungen etc. sind vorhanden
            for (int i = 0; i < fileArray.length; i++) {
                System.out.println(fileArray[i]);
                filename = fileArray[i].toString();
            }
        }
    }
}
