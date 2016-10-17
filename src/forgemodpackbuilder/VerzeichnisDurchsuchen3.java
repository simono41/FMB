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
import java.io.File;

public class VerzeichnisDurchsuchen3 {

    public static void main(String[] args) {

        File f = new File("./modpack/" + GUI.version);
        File[] fileArray = f.listFiles();

        if (fileArray != null) { // Erforderliche Berechtigungen etc. sind vorhanden
            for (int i = 0; i < 1; i++) {
                System.out.println(fileArray[0]);
                GUI.datei = fileArray[0].toString();
            }
        }
    }
}
