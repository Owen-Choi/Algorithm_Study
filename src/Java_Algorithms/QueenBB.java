package Java_Algorithms;

public class QueenBB {
    int[] arr = new int[8];
    boolean[] flag = new boolean[8];
    public void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", arr[i]);
        }
        System.out.println();
    }

    public void set(int i){
        for(int j = 0; j < 8; j++){
            if(!flag[j]) {
                arr[i] = j;                 // i열에 놓인 퀸의 위치가 j행
                if (i == 7)
                    print();
                else {
                    flag[j] = true;
                    set(i + 1);             //j행에 퀸을 배치했으니 다음 열로 넘어가는 작업
                    flag[j] = false;        //이 코드는 대기했다가 열이
                }
            }
        }
    }

    public static void main(String[] args) {
        QueenB qb = new QueenB();
        qb.set(0);
    }
}
