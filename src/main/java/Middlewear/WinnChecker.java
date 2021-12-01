package Middlewear;

import BackendObjects.Drawing;
import BackendObjects.Tipp;

public class WinnChecker {
    static final int KLASSE_09 = 12;
    static final int KLASSE_08 = 3;
    static final int KLASSE_07 = 13;
    static final int KLASSE_06 = 4;
    static final int KLASSE_05 = 14;
    static final int KLASSE_04 = 5;
    static final int KLASSE_03 = 15;
    static final int KLASSE_02 = 6;
    static final int KLASSE_01 = 16;



    public static String getWinnerClass(Tipp tipp, Drawing drawing) {
        if(drawing.getNumbers().length == 0){
            return "TBD";
        }
        String[] tippedNumbers = tipp.getAllTippedNumbers();
        String[] drawingNumbers = drawing.getNumbers();
        String currendNumber;
        int count = 0;
        for(int position = 0; position < tippedNumbers.length; position++){
            currendNumber = tippedNumbers[position];
            if(isNumberDrawn(currendNumber, drawingNumbers)){
                count++;
            }
        }
        if(tipp.getBonusNumber().equals(drawing.getBonusNumber())){
            count = count + 10;
        }

        switch (count){
            case KLASSE_01:
                return "GK 1";
            case KLASSE_02:
                return "GK 2";
            case KLASSE_03:
                return "GK 3";
            case KLASSE_04:
                return "GK 4";
            case KLASSE_05:
                return "GK 5";
            case KLASSE_06:
                return "GK 6";
            case KLASSE_07:
                return "GK 7";
            case KLASSE_08:
                return "GK 8";
            case KLASSE_09:
                return "GK 9";
        }
        return "Kein Gewinn";
    }

    private static boolean isNumberDrawn(String currendNumber, String[] drawingNumbers) {
        for(String number : drawingNumbers){
            if(currendNumber.equals(number)){
                return true;
            }
        }
        return false;
    }
}
