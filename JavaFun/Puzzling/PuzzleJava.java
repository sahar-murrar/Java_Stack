import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
public class PuzzleJava{
     public static void main(String [] args){
         ArrayList<Integer> result= taskOne();
         for(int i=0; i<result.size(); i++){
             System.out.println(result.get(i));
         }
         taskTwo();
         taskThree();
         generateRandomArray();
         System.out.println("****************************************");
         generateRandomSortedArray();
         System.out.println("*****************************************");
         String str= randomString();
         System.out.println(str);
         System.out.println("******************************************");
         generateStringsArray();

     }

     public static ArrayList<Integer> taskOne(){
         int[] arr= {3,5,1,2,7,9,8,13,25,32};
         ArrayList<Integer> new_arr=new ArrayList<Integer>();
         int sum=0;
         for (int i=0; i<arr.length; i++){
             sum += arr[i];
             if(arr[i] > 10){
                 new_arr.add(arr[i]);

             }
         }
         System.out.println("The sum is: "+sum);
         return new_arr;
     }
     public static ArrayList<String> taskTwo(){
          ArrayList<String> arr= new ArrayList<String>();
          ArrayList<String> new_arr= new ArrayList<String>();
          arr.add("Nancy");
          arr.add("Jinichi");
          arr.add("Fujibayashi");
          arr.add("Momochi");
          arr.add("Ishikawa");
          Collections.shuffle(arr);
          System.out.println(arr);
          for (int i=0; i< arr.size(); i++){
              if(arr.get(i).length() >5){
                  new_arr.add(arr.get(i));
              }
          }
          System.out.println(new_arr);
          return new_arr;

     }
     public static ArrayList<String> taskThree(){
         ArrayList<String> arr= new ArrayList<String>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"));
         Collections.shuffle(arr);
         System.out.println(arr);
         System.out.println(arr.get(arr.size()-1));
         System.out.println(arr.get(0));
          ArrayList<String> vowels_arr= new ArrayList<String>(Arrays.asList("A", "E", "I", "O", "U","Y"));
          if(vowels_arr.contains(arr.get(0))) {
              System.out.println("The first letter is vowel letter!");
          }
         return arr;

     }
     public static ArrayList<Integer> generateRandomArray(){
         ArrayList<Integer> arr= new ArrayList<Integer>();
         for(int i=0; i<10; i++){
             Random r = new Random();
             arr.add(r.nextInt(100-55)+55);

         }
         System.out.println("random array: "+arr);
         return arr;
         
     }
        public static ArrayList<Integer> generateRandomSortedArray(){
         ArrayList<Integer> arr= generateRandomArray();
         Collections.sort(arr);
         System.out.println("sorted array: "+arr);
         System.out.println("minimum value in the array: "+arr.get(0));
         System.out.println("maximum value in the array: "+arr.get(arr.size()-1));
         return arr;
         
     }
     public static String randomString(){
         String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "abcdefghijklmnopqrstuvxyz";
  
        StringBuilder sb = new StringBuilder(5);
  
        for (int i = 0; i < 5; i++) {
  
            int index= (int)(AlphaNumericString.length()* Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
  
        return sb.toString();
     }
     public static ArrayList<String> generateStringsArray(){
         ArrayList<String> arr= new ArrayList<String>();
         for(int i=0; i<10; i++){
             Random r = new Random();
             arr.add(randomString());

         }
         System.out.println("random Strings array: "+arr);
         return arr;

     }
     
}