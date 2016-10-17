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
import java.beans.PropertyChangeEvent; 
import java.beans.PropertyChangeListener; 
import java.io.File; 

import javax.swing.JFileChooser;

public class OeffnenDialogClass { 

    public static void main(String[] args) { 
        OeffnenDialogClass odc = new OeffnenDialogClass(); 
        odc.oeffnen(); 
    } 

    private void oeffnen() { 
        final JFileChooser chooser = new JFileChooser("Verzeichnis wählen"); 
        chooser.setDialogType(JFileChooser.OPEN_DIALOG); 
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); 
        final File file = new File("/home"); 

        chooser.setCurrentDirectory(file); 

        chooser.addPropertyChangeListener(new PropertyChangeListener() { 
            public void propertyChange(PropertyChangeEvent e) { 
                if (e.getPropertyName().equals(JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) 
                        || e.getPropertyName().equals(JFileChooser.DIRECTORY_CHANGED_PROPERTY)) { 
                    final File f = (File) e.getNewValue(); 
                } 
            } 
        }); 

        chooser.setVisible(true); 
        final int result = chooser.showOpenDialog(null); 

        if (result == JFileChooser.APPROVE_OPTION) { 
            File inputVerzFile = chooser.getSelectedFile(); 
            String inputVerzStr = inputVerzFile.getPath();
            GUI.datei = inputVerzStr;
            System.out.println(inputVerzStr); 
        } 
        System.out.println("Abbruch"); 
        chooser.setVisible(false); 
    } 
} 
