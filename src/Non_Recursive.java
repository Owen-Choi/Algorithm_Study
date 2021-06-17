import java.util.Scanner;

public class Non_Recursive {

    Stack_Class stack = new Stack_Class(64);
    // # 재귀 형식의 함수를
    public void recur(int n){
        if(n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }
    // # 비 재귀 형식의 함수로
    public void non_recur(int n){
        while(true){
            if(n > 0){
                stack.push(n);
                n--;
                continue;
            }
            if(!stack.isEmpty()){
                n = stack.pop();
                System.out.println(n);
                n-= 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        Non_Recursive nr = new Non_Recursive();
        System.out.println("Please Enter value : ");
        n = sc.nextInt();
        nr.non_recur(n);
    }
}
