/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zipper;

import forgemodpackbuilder.GUI;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author simonr
 */
public class Modpacktxt {

    static String name;

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter(name);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(GUI.version);
        bw.newLine();
        for (int i = 0; i < GUI.mods1.size(); i++) {
            bw.write(GUI.mods1.get(i).substring( GUI.mods1.get(i).lastIndexOf( "/" ) + 1 ));
            bw.newLine();
        }
        bw.close();
    }

}