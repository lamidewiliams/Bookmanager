package org.example.util;

import java.time.Year;
import java.util.Random;

public class UserUtil {

    public static final String ProfileCreatedCode="0001";
    public static final String ProfileCreatedMessage="User Created!!";

    public static final String AccountNotExistCode="0003";
    public static final String AccountNotExistmessage="Account does not Exist!!";

    public static final String BookAddedCode="0004";
    public static final String BookAddedMessage="Book Added!!";

    public static final String WrongPasswordcode="0005";
    public static final String Wrongpasswordmessage="Account exist!!";

    public static final String AccountExistCode="0002";
    public static final String AccountExistmessage="Account exist!!";

    public  static String FormulateuniquId() {
        /*2023 + any random 7 digit*/
        Year currentYear = Year.now();
        int min =1000000;
        int max = 9999999;
        /*now we generate randoms */
        int randomNumber = (int)Math.floor(Math.random() * (max-min -1) + min);
        String year = String.valueOf(currentYear);
        char randomLetter = (char) ((Math.random() < 0.5 ? 'A' : 'a') + new java.util.Random().nextInt(26));
        String randNumber =String.valueOf(randomNumber);
        StringBuilder UniqueId = new StringBuilder(year);
        return UniqueId.append(year).append(randNumber).append(randomLetter).toString();


    }
}