import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int impCount=0;
        int noImpCount=0;
        int row=0;
        for(;row<contests.length;row++){
            if(contests[row][1]==1){
                impCount+=1;
            }else{
                noImpCount+=1;
            }
        }
        
        int[] impArr=new int[impCount];
        int[] noImpArr=new int[noImpCount];
        int i=0; int j=0;
        for(row=0;row<contests.length;row++){
            if(contests[row][1]==1){
                impArr[i]=contests[row][0];
                i+=1;
            }else{
                noImpArr[j]=contests[row][0];
                j+=1;
            }
        }
        Arrays.sort(impArr);
        
        int luck_bal=0;
        int index=0;
        for(index=0;index<noImpCount;index++){
            luck_bal+=noImpArr[index];
        }
        
        int winCount=impCount-k;
        index=0;
        while(index<winCount){
                luck_bal-=impArr[index];
                index++;
            }
         
        for(;index<impCount;index++){
            
            luck_bal+=impArr[index];
        } 

return luck_bal;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
