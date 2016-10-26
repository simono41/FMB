/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgemodpackbuilder;

/**
 *
 * @author simonr
 */

public class ProcExec {

    public static void main(String[] args) throws Exception {

        if (GUI.funktion == 1) {
            Runtime.getRuntime().exec("java -jar ./modpack/Minecraft.jar");
        }
        if (GUI.funktion == 2) {
            Runtime.getRuntime().exec("java -jar ./modpack/forge.jar");
        }
    }
}
