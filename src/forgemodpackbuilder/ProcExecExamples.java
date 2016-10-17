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
import java.io.*;

public class ProcExecExamples {

    public static int funktion = 1;

    public static void main(String[] args) throws Exception {

        if (isWindowsSystem()) {
            System.out.println("Windows");
            Runtime.getRuntime().exec("cmd /c help");
        }
        if (isLinuxSystem()) {
            System.out.println("Linux");
            if (funktion == 1) {
                Runtime.getRuntime().exec("java -jar " + System.getProperty("user.home") + "/.minecraft/Minecraft.jar");
            }
            if (funktion == 2) {
                Runtime.getRuntime().exec("java -jar " + System.getProperty("user.home") + "/.minecraft/forge.jar");
            }

        }
    }

    static boolean isWindowsSystem() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.indexOf("windows") >= 0;
    }

    static boolean isLinuxSystem() {
        String osName = System.getProperty("os.name").toLowerCase();
        return osName.indexOf("linux") >= 0;
    }
}
