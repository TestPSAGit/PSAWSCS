/*
 * Creation : 24 avr. 2019
 */
package Methodes;

import java.time.LocalDate;
import java.util.Date;

public class DateManagement {
    static Date dDate;

    public static Date FormatDateSplited(String Date) {

        String[] DateSplited = Date.split(" ");

        if (DateSplited[1].equals("janvier") || DateSplited[1].equals("gennaio") || DateSplited[1].equals("january")
                || DateSplited[1].equals("januar") || DateSplited[1].equals("januari")) {
            DateSplited[1] = "01";
        } else if (DateSplited[1].equals("février") || DateSplited[1].equals("febbraio") || DateSplited[1].equals("february")
                || DateSplited[1].equals("februar") || DateSplited[1].equals("februari")) {
            DateSplited[1] = "02";
        } else if (DateSplited[1].equals("mars") || DateSplited[1].equals("marzo") || DateSplited[1].equals("march") || DateSplited[1].equals("märz")
                || DateSplited[1].equals("maart")) {
            DateSplited[1] = "03";
        } else if (DateSplited[1].equals("avril") || DateSplited[1].equals("aprile") || DateSplited[1].equals("april")
                || DateSplited[1].equals("april") || DateSplited[1].equals("april")) {
            DateSplited[1] = "04";
        } else if (DateSplited[1].equals("mai") || DateSplited[1].equals("maggio") || DateSplited[1].equals("may") || DateSplited[1].equals("mai")
                || DateSplited[1].equals("mei")) {
            DateSplited[1] = "05";
        } else if (DateSplited[1].equals("juin") || DateSplited[1].equals("giugno") || DateSplited[1].equals("june") || DateSplited[1].equals("juni")
                || DateSplited[1].equals("juni")) {
            DateSplited[1] = "06";
        } else if (DateSplited[1].equals("juillet") || DateSplited[1].equals("luglio") || DateSplited[1].equals("july")
                || DateSplited[1].equals("juli") || DateSplited[1].equals("juli")) {
            DateSplited[1] = "07";
        } else if (DateSplited[1].equals("août") || DateSplited[1].equals("agosto") || DateSplited[1].equals("august")
                || DateSplited[1].equals("august") || DateSplited[1].equals("augustus")) {
            DateSplited[1] = "08";
        } else if (DateSplited[1].equals("septembre") || DateSplited[1].equals("settembre") || DateSplited[1].equals("september")
                || DateSplited[1].equals("september") || DateSplited[1].equals("september")) {
            DateSplited[1] = "09";
        } else if (DateSplited[1].equals("octobre") || DateSplited[1].equals("ottobre") || DateSplited[1].equals("october")
                || DateSplited[1].equals("oktober") || DateSplited[1].equals("oktober")) {
            DateSplited[1] = "10";
        } else if (DateSplited[1].equals("novembre") || DateSplited[1].equals("novembre") || DateSplited[1].equals("november")
                || DateSplited[1].equals("november") || DateSplited[1].equals("november")) {
            DateSplited[1] = "11";
        } else if (DateSplited[1].equals("décembre") || DateSplited[1].equals("dicembre") || DateSplited[1].equals("december")
                || DateSplited[1].equals("dezember") || DateSplited[1].equals("december")) {
            DateSplited[1] = "12";
        }

        if (DateSplited[0].equals("1")) {
            DateSplited[0] = "01";
        } else if (DateSplited[0].equals("2")) {
            DateSplited[0] = "02";
        } else if (DateSplited[0].equals("3")) {
            DateSplited[0] = "03";
        } else if (DateSplited[0].equals("4")) {
            DateSplited[0] = "04";
        } else if (DateSplited[0].equals("5")) {
            DateSplited[0] = "05";
        } else if (DateSplited[0].equals("6")) {
            DateSplited[0] = "06";
        } else if (DateSplited[0].equals("7")) {
            DateSplited[0] = "07";
        } else if (DateSplited[0].equals("8")) {
            DateSplited[0] = "08";
        } else if (DateSplited[0].equals("9")) {
            DateSplited[0] = "09";
        }

        String DileveryDate = DateSplited[2] + "-" + DateSplited[1] + "-" + DateSplited[0];
        LocalDate date = LocalDate.parse(DileveryDate);

        return java.sql.Date.valueOf(date);

    }

    public static Date GetCurrentDate() {

        LocalDate localDate = LocalDate.now();
        return java.sql.Date.valueOf(localDate);

    }

}
