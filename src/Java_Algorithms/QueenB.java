package Java_Algorithms;

public class QueenB {
    int[] arr = new int[8];
    public void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", arr[i]);
        }
        System.out.println();
    }

        public void set(int i){
            for(int j = 0; j < 8; j++){
                arr[i] = j;
                if(i == 7)
                    print();
                else
                    set(i + 1);
            }
        }

    public static void main(String[] args) {
    QueenB qb = new QueenB();
        qb.set(0);
    }
}
