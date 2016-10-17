/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forgemodpackbuilder;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

/**
 *
 * @author simonr
 */

public class UnZip {
    static String modpack = "";
    static String modpack1 = "";
    public static void main() {
    String source = modpack;
    String destination = modpack1;
    String password = "mypassword";

    try {
        ZipFile zipFile = new ZipFile(source);
        if (zipFile.isEncrypted()) {
            zipFile.setPassword(password);
        }
        zipFile.extractAll(destination);
    } catch (ZipException e) {
        e.printStackTrace();
    }
}
}