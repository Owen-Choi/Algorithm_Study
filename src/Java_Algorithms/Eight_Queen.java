package Java_Algorithms;

class Eight_Queen {
    static boolean[] flag_a = new boolean[8];
    static boolean[] flag_b = new boolean[15];
    static boolean[] flag_c = new boolean[15];
    static int[] pos = new int[8];

    static void print(){
        StringBuilder oneLine0 = new StringBuilder("□□□□□□□□");
        StringBuilder oneLine1 = new StringBuilder("□□□□□□□□");
        StringBuilder oneLine2 = new StringBuilder("□□□□□□□□");
        StringBuilder oneLine3 = new StringBuilder("□□□□□□□□");
        StringBuilder oneLine4 = new StringBuilder("□□□□□□□□");
        StringBuilder oneLine5 = new StringBuilder("□□□□□□□□");
        StringBuilder oneLine6 = new StringBuilder("□□□□□□□□");
        StringBuilder oneLine7 = new StringBuilder("□□□□□□□□");

        for(int i=0; i<8; i++){

            System.out.printf("%2d", pos[i]);
            int value1 = pos[i]; // 4
            if(value1 == 0){
                oneLine0.setCharAt(i, '■');
            }else if(value1 == 1){
                oneLine1.setCharAt(i, '■');
            }else if(value1 == 2){
                oneLine2.setCharAt(i, '■');
            }else if(value1 == 3){
                oneLine3.setCharAt(i, '■');
            }else if(value1 == 4){
                oneLine4.setCharAt(i, '■');
            }else if(value1 == 5){
                oneLine5.setCharAt(i, '■');
            }else if(value1 == 6){
                oneLine6.setCharAt(i, '■');
            }else if(value1 == 7){
                oneLine7.setCharAt(i, '■');
            }
        }
        System.out.println();
        String whole = oneLine0 +"\n" + oneLine1 +"\n" +
                oneLine2 +"\n" + oneLine3 +"\n" +
                oneLine4 +"\n" + oneLine5 +"\n" +
                oneLine6 +"\n" + oneLine7 +"\n";
        System.out.println(whole);
        System.out.println();
    }

    static void set(int i){
        for(int j=0; j<8; j++){
            if(flag_a[j] == false && flag_b[i + j] == false && flag_c[i-j+7] == false) {
                pos[i] = j;
                if (i == 7)
                    print();
                else {
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = true;
                    set(i + 1);
                    flag_a[j] = flag_b[i + j] = flag_c[i - j + 7] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        set(0);
    }
}
