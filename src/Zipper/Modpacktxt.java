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

    public static void main(String[] args) throws IOException {

        FileWriter fw = new FileWriter("./modpack/modpack/version.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write(GUI.version);
        bw.close();
    }

}
