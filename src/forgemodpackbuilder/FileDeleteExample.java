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
 
public class FileDeleteExample {
 
    public static void main(String[] args) {
        File file = new File(GUI.datei);
       
        //Zuvor alle mit dem File assoziierten Streams schließen...
       
        if(file.exists()){
            file.delete();
        }
       
        System.out.println("File deleted");
    }
}
