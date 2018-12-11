import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int[] highest=new int[scores.length];
        int[] lowest=new int[scores.length];
        int[] result=new int[2];
        highest[0]=scores[0];
        lowest[0]=scores[0];
        int highBreak=0;
        int lowBreak=0;
        for(int index=1;index<scores.length;index++){
            if(scores[index]>highest[index-1]){
                highest[index]=scores[index];
                highBreak+=1;
                result[0]=highBreak;
            }else{
                highest[index]=highest[index-1];
            }
            if(scores[index]<lowest[index-1]){
                lowest[index]=scores[index];
                lowBreak+=1;
                result[1]=lowBreak;
            }else{
                lowest[index]=lowest[index-1];
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[n];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int[] result = breakingRecords(scores);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
