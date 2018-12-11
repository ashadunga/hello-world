import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gridChallenge function below.
    static String gridChallenge(String[] grid) {
        String result="YES";
        char[] tempArr=new char[grid.length];
        int i=0;
        for(;i<grid.length;i++){
            tempArr=grid[i].toCharArray();
            Arrays.sort(tempArr);
            grid[i]=new String(tempArr);
            
         }
         int row=grid.length;
         int col=tempArr.length;
         char[][] tempCompArr=new char[row][col];
         for(i=0;i<grid.length;i++){
             tempCompArr[i]=grid[i].toCharArray();
         }
         
         for(col=0;col<tempArr.length;col++){
            for(row=0;row<grid.length-1;row++){
                 if(tempCompArr[row][col]>tempCompArr[row+1][col]){
                     result="NO";
                     break;
                 }
             }
         }


        return result;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String[] grid = new String[n];

            for (int i = 0; i < n; i++) {
                String gridItem = scanner.nextLine();
                grid[i] = gridItem;
            }

            String result = gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
