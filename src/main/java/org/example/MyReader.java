package org.example;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MyReader {
    private static String code;
    private static String date;
    private static String url;

    public  static void readURL() {
        Scanner console = new Scanner(System.in);
        String line = console.nextLine();
        String[] args = line.split(" ");
        if (args[0].equals("currency_rates")) {
            for (int i = 1; i < args.length; i++) {
                if (args[i].startsWith("--code")) {
                    code = args[i].substring(7);
                } else if (args[i].startsWith("--date")) {
                    String dateBuff = args[i].substring(7);
                    date = dateBuff.substring(8) + "/" + dateBuff.substring(5,7)+ "/" + dateBuff.substring(0,4);
                } else {
                    System.out.println("Argument error");
                    return;
                }
            }
        } else {
            System.out.println("Wrong command");
            return;
        }
        url = String.format("http://www.cbr.ru/scripts/XML_daily.asp?date_req=%s", date);
        }

    public  static String getUrl() {
        return url;
    }

    public  static String getDate() {
        return date;
    }

    public  static String getCode() {
        return code;
    }
}
