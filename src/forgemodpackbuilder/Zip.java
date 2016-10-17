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
import net.lingala.zip4j.core.*;
import net.lingala.zip4j.model.*;
import net.lingala.zip4j.util.*;

public class Zip {
    
    String modpack = "";
    static String datum = "";

    void archiveDir(String path) {
        try {

            // Initiate ZipFile object with the path/name of the zip file.
            ZipFile zipFile = new ZipFile(modpack + "-" + datum +  ".zip");

            // Folder to add
            String folderToAdd = "./modpack/modpack/";

            // Initiate Zip Parameters which define various properties such
            // as compression method, etc.
            ZipParameters parameters = new ZipParameters();

            // set compression method to store compression
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

            // Set the compression level
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            
            // Set the root folder
            parameters.setIncludeRootFolder(false);

            // Add folder to the zip file
            zipFile.addFolder(folderToAdd, parameters);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
