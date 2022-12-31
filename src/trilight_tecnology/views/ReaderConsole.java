package trilight_tecnology.views;

import java.util.Scanner;

public class ReaderConsole {
    private static ReaderConsole single = null;
    private Scanner input = null;
    private ReaderConsole(){
        input = new Scanner(System.in);
    }
    public static ReaderConsole getInstance(){
        if(single == null){
            return new ReaderConsole();
        }
        return single;
    }

    public Integer readInteger(){
        String line = input.nextLine();
        Integer result = null;
        try {
            result = Integer.parseInt(line);
        } catch (Exception e) {
            return null;
        }
        return result;
    }
}
