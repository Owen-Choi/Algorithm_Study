package Java_Algorithms;

import java.util.Scanner;

public class Linear_Search {

    public static void main(String[] args) {
        int[] arr; int length;
        int i;
        int target;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the length of the array");
        length = sc.nextInt();
        arr = new int[length];
        for(i=0; i<arr.length; i++){
            System.out.println("Enter " + i + "th number to array");
            arr[i] = sc.nextInt();
        }

        System.out.println("Please Enter the Target number : ");
        target = sc.nextInt();
        for(i=0; i<arr.length; i++){
            if(arr[i] == target){
                System.out.println("Target Found");
                return;
            }
        }
        System.out.println("Target not found");
        return;
    }
}
