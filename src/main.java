/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import forgemodpackbuilder.GUI;
import java.io.File;

/**
 *
 * @author simonr
 */
public class main {
    public static void main(String[] args) {
        System.out.println("Hallo Welt");
            new GUI().setVisible(true);
            File dir = new File("./modpack");
            dir.mkdir();
            System.out.println(System.getProperty("user.home"));
    }
}
