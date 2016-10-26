/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Zipper;

/**
 *
 * @author simonr
 */
import Zipper.Zip;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AktuellesDatumJava8 {

    static void formatDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df;
        df = DateTimeFormatter.ISO_LOCAL_DATE;    // 2016-18-31 
        System.out.println(now.format(df));
        Zip.datum = now.format(df);
    }

    public static void main(String[] args) {
        formatDateTime();
    }
}
