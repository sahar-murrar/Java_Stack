 import java.util.ArrayList;
public class BasicJava{
     public static void main(String [] args){
         PrintNumbers();
         System.out.println("***************************************");
         PrintOddNumbers();
         System.out.println("****************************************");
         PrintSum();
         System.out.println("*****************************************");
         int arr[]={1,3,5,7,9,13};
         IteratingThroughArray(arr);
         System.out.println("*******************************************");
         int arr2[]={-1,0,-2,5,2,3};
         FindMax(arr2);
         System.out.println("*********************************************");
         int arr3[]= {2, 10, 3};
         GetAverage(arr3);
         System.out.println("*********************************************");
         ArrayWithOddNumbers();
         System.out.println("***********************************************");
         int arr4[]= {1,3,5,7};
         System.out.println(GreaterThanY(arr4, 3));
         System.out.println("***********************************************");
         int arr5[]= {1, 5, 10, -2};
         SquareValues(arr5);
         System.out.println("**********************************************");
         int arr6[]= {1, 5, 10, -2};
         EliminateNegativeNumbers(arr6);
         System.out.println("**********************************************");
         int arr7[]={1, 5, 10, -2};
         ArrayList<Object> myArray=MaxMinAverage(arr7);
        for(int i=0; i<myArray.size(); i++){
            System.out.println(myArray.get(i));
        }
        System.out.println("***********************************************");
        int arr8[]= {1, 5, 10, 7, -2};
        int [] shift_arr=shiftArrayValues(arr8);
        for(int i=0; i< shift_arr.length; i++){
            System.out.println(shift_arr[i]);
        }
        System.out.println("***********************************************");



 
    }
    public static void PrintNumbers(){
        for(int i=1; i<256; i++){
            System.out.println(i);
        }
    }
    public static void PrintOddNumbers(){
        for(int i=1; i<256; i++){
            if(i%2 !=0){
                System.out.println(i);
            } 
        }
    }
    public static void PrintSum(){
        int sum=0;
         for(int i=0; i<256; i++){
             sum += i;
            System.out.println("New Number is: "+i+" sum: "+sum);
        }
    }
    public static void IteratingThroughArray(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);

        }
    }
    public static void FindMax(int arr[]){
        int max=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] > max){
                max=arr[i];
            }
        }
        System.out.println(max);

    }
    public static void GetAverage(int arr[]){
        int sum=0;
        double avg=0;
        for(int i=0; i<arr.length; i++){
            sum += arr[i];
        }
        avg = sum/arr.length;
        System.out.println(avg);
    }
    public static void ArrayWithOddNumbers(){
        ArrayList<Integer> y = new ArrayList<Integer>();
        // int y[]= new int[128];
        for(int i=1; i<= 255; i++){
            if(i%2 != 0){
                y.add(i);
            }
            
        }
        for(int i=0; i<y.size(); i++){
            System.out.println(y.get(i));
        }
    }
    public static int GreaterThanY(int arr[], int y){
        int count=0;
        for(int i=0; i< arr.length; i++){
            if(arr[i] > y){
                count++;
            }
        }
        return count;
    } 
    public static void SquareValues(int arr[]){
        for(int i=0; i<arr.length; i++){
            arr[i] *= arr[i];
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static void EliminateNegativeNumbers(int arr[]){
        for(int i=0; i<arr.length; i++){
            if(arr[i] < 0 ){
                arr[i] = 0;
            }
        }
        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static ArrayList<Object> MaxMinAverage(int [] arr){
        ArrayList<Object> new_arr = new ArrayList<Object>();
        double max=arr[0];
        double min=arr[0];
        double sum=0;
        double avg=0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];
            if(arr[i] > max){
                max=arr[i];
            }
            if(arr[i]< min){
                min=arr[i];
            }
        }
        avg = sum/arr.length;
        new_arr.add(max);
        new_arr.add(min);
        new_arr.add(avg);
        //   for(int i=0; i<new_arr.size(); i++){
        //     System.out.println(new_arr.get(i));
        // }
        return new_arr;

    }
    public static int[] shiftArrayValues(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(i != arr.length-1){
                arr[i]= arr[i+1];
            }
            else{
                arr[i]=0;
            }
            
        }
        return arr;
    }
}