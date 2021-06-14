import java.util.Scanner;

public class Binary_Search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length; int[] arr;  int i;  int j;
        int tempNum;    int target;
        System.out.println("Please Enter the length of the array");
        length = sc.nextInt();
        arr = new int[length];
        for(i=0; i<arr.length; i++){
            System.out.println("Enter " + i + "th number to array");
            arr[i] = sc.nextInt();
        }

        System.out.println("Please enter value you want to find : ");
        target = sc.nextInt();

        for(i=0; i<arr.length -1; i++){
            for(j=i; j<arr.length-1; j++){
                if(arr[i] < arr[j]){
                    tempNum = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tempNum;
                }
            }
        }

        Binary_Search_Class bsc = new Binary_Search_Class(arr, target);
        i = bsc.BinarySearch();

        if(i == -1)
            System.out.println("Cannot Found Any Value");
        else
            System.out.println(i + " is Found");

    }


}
