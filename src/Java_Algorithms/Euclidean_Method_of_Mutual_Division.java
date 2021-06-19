package Java_Algorithms;

import java.util.Scanner;

public class Euclidean_Method_of_Mutual_Division {

    int x;  int y;

    public int GCD(int x, int y){
        if(y == 0)
            return x;           //말이 x지 사실 x의 위치에 있는 값은 y이다. y에는 y%x, 즉 0이 들어간다.
        else
            return GCD(y, x%y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int xVal;   int yVal;   int result;

        System.out.println("Please Enter x value : ");
        xVal = sc.nextInt();
        System.out.println("Please Enter y value : ");
        yVal = sc.nextInt();
        Euclidean_Method_of_Mutual_Division Euclid = new Euclidean_Method_of_Mutual_Division();
        result = Euclid.GCD(xVal, yVal);

        System.out.println("The Greatest Common Divisor(GCD) is " + result);
    }
}
