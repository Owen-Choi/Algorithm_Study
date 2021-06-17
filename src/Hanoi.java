import java.util.Scanner;

public class Hanoi {

    public void move(int towerNum, int x, int y){
        if(towerNum > 1){
            move(towerNum - 1, x, 6 - x - y);
        }

        System.out.println("원반[" + towerNum + "] 을 " + y + "번째 기둥으로 옮김");

        if(towerNum > 1) {
            move(towerNum - 1, 6 - x - y, y);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Please Enter the number of plate");
        num = sc.nextInt();
        Hanoi hanoi = new Hanoi();
        hanoi.move(num, 1, 3);
    }
}
