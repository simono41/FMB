/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgemodpackbuilder;

import java.io.File;

/**
 *
 * @author simonr
 */
public class Suche {

    static String name = "";

    public static void main(String[] args) {

        String pathToScan = "./modpack/" +  GUI.version + "/mods";
        String fileThatYouWantToFilter;
        File folderToScan = new File(pathToScan); // import -> import java.io.File;
        File[] listOfFiles = folderToScan.listFiles();
        int i = 0;
        for (File listOfFile : listOfFiles) {
            if (listOfFile.isFile()) {
                fileThatYouWantToFilter = listOfFile.getName();
                if (fileThatYouWantToFilter.startsWith(name)
                        && fileThatYouWantToFilter.endsWith(".jar")) {
                    System.out.println("found" + " " + fileThatYouWantToFilter);
                    GUI.mods0.add("./modpack/" +  GUI.version + "/mods/" + fileThatYouWantToFilter);
                }
            }
        }
    }
}
