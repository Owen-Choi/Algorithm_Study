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
                n -= 2;
                continue;
            }
            break;
        }
    }

    public void Non_recur3(int n){
        int[] nstk = new int[100];
        int[] sstk = new int[100];
        int ptr = -1;
        int sw = 0;
        while(true){
            if(n > 0) {
                ptr++;
                nstk[ptr] = n;
                sstk[ptr] = sw;

                if(sw == 0) {
                    n--;
                }
                else if(sw == 1) {
                    n -= 2;
                    sw = 0;
                }
                continue;
            }
            do{
                n = nstk[ptr];
                sw = sstk[ptr--] + 1;

                if(sw == 2){
                    System.out.println(n);
                    if(ptr < 0)
                        return;
                }
            }while(sw == 2);

        }
    }
    // # 추가
    public void recur3(int n){
        if(n > 0){
            recur3(n-1);
            recur3(n-2);
            System.out.println(n);
        }
    }


    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        Non_Recursive nr = new Non_Recursive();
        System.out.println("Please Enter value : ");
        n = sc.nextInt();
        nr.recur3(n);
        System.out.println();
        nr.Non_recur3(n);
    }
}
