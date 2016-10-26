/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DateiKopieren;

/**
 *
 * @author simonr
 */
import forgemodpackbuilder.GUI;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.nio.channels.FileChannel; 

public class DateiKopierenClass { 
     
    public static void main(String[] args) throws IOException { 
        File inF = new File(GUI.datei); 
        File outF = new File("./modpack/modpack/mods/" + GUI.datei.substring( GUI.datei.lastIndexOf( "/" ) + 1 )); 
        copyFile(inF, outF); 
    } 
     
    public static void copyFile(File in, File out) throws IOException { 
        FileChannel inChannel = null; 
        FileChannel outChannel = null; 
        try { 
            inChannel = new FileInputStream(in).getChannel(); 
            outChannel = new FileOutputStream(out).getChannel(); 
            inChannel.transferTo(0, inChannel.size(), outChannel); 
        } catch (IOException e) { 
            throw e; 
        } finally { 
            try { 
                if (inChannel != null) 
                    inChannel.close(); 
                if (outChannel != null) 
                    outChannel.close(); 
            } catch (IOException e) {} 
        } 
    } 
} 
