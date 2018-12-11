import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
       */
        String timeString="";
        String convTime="";
        String[] timeArr=null;
        Integer hour=0;
        int last_index=0;
        if(s.contains("PM")){
            last_index=s.lastIndexOf("PM");
            timeString=s.substring(0,last_index);
            timeArr=timeString.split(":",3);
            hour=Integer.parseInt(timeArr[0]);
            if(hour!=12){
                hour+=12;
            timeArr[0]=hour.toString();
            }
            
            
            
        }
        else{
            last_index=s.lastIndexOf("AM");
            timeString=s.substring(0,last_index);
            timeArr=timeString.split(":",3);
            hour=Integer.parseInt(timeArr[0]);
            if(hour==12){
                timeArr[0]="00";
            }
            
        }
        convTime=timeArr[0]+":"+timeArr[1]+":"+timeArr[2];
        return convTime;
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}