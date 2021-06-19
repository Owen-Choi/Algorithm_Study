package Java_Algorithms;

import java.util.Scanner;

public class Factorial {

    int num;


    public int Fac(int num){
        if(num > 0)
            return num * Fac(num - 1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int val;
        System.out.println("Please Enter value : ");
        val = sc.nextInt();
        Factorial Fc = new Factorial();

        System.out.println(Fc.Fac(val));
    }
}
