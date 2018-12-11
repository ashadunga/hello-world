import java.util.*;
import java.lang.*;

public class StringPerm{

    public static void main(String[] args){

    Scanner in=new Scanner(System.in);
    int no_of_tests=in.nextInt();
    String[] words=new String[no_of_tests];
    for(int i=0;i<no_of_tests;i++){
        String text=in.next();
        words[i]=text;
    }//end of for loop

    countDistinctPerm(words);

    }// end of main

static void countDistinctPerm(String[] words){

        
        //begin of for loop

        for(int index=0;index<words.length;index++){
            Map<Character,Integer> letterCount=new HashMap<Character,Integer>();
            String s=words[index];
            int length=s.length();
            //System.out.println("Length of the word is"+length);
            // begin of for loop
                for(int i=0;i<length;i++){
                    // begin of if block
                        if(letterCount.containsKey(s.charAt(i))){
                            //System.out.println("Entered map block with incrementing the count");
                                letterCount.put(s.charAt(i),letterCount.get(s.charAt(i))+1);
                        }// end of if
                        else{
                            //System.out.println("Entered map block with count 1");
                                letterCount.put(s.charAt(i),1);
                            } // end of else
                 }// end of for loop
            
            int distinctWords=1;
            int factDeno=1;
            
            // extract keys from map whose values are greater than 1
            Set<Map.Entry<Character,Integer>> letterCountSet=letterCount.entrySet();

            for(Map.Entry<Character,Integer> me:letterCountSet){
                 //System.out.println("me.getValue() is"+me.getValue());
                    
                 if(me.getValue()>1){
                    //System.out.println("Entered if block");
                    factDeno=factDeno* factorial(me.getValue());
                }//end of if block
            }// end of forEach loop
                
                //System.out.println("Factorial of the length is"+factorial(length));
                //System.out.println("Fatorial of the denominator "+factDeno);
            
                distinctWords=factorial(length)/(factDeno);
                System.out.println(distinctWords);

        }//end of outer for loop
    }//end of method

        static int factorial(int value){
            int fact=1;
                for(int i=2;i<=value;i++){
                fact=fact*i;
                //System.out.println("fact ="+fact);
                }// end of for loop
        return fact;
        }// end of factorial method

}//end of class