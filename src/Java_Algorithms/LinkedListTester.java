package Java_Algorithms;

import java.util.Scanner;

public class LinkedListTester {

    static Scanner sc = new Scanner(System.in);

    static class Data{
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        public String toString(){
            return "(" + no + ")" + name;
        }

        void scanData(String guide, int sw){
            System.out.println(guide + "할 데이터를 입력하세요");

            if((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = sc.nextInt();
            }
            if((sw&NAME) == NAME){
                System.out.print("이름 : ");
                name = sc.next();
            }
        }

        public static final Comparator<Data>NO_ORDER = new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data>{
            public int compare(Data d1, Data d2){
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }

        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();

        private static class NameOrderComparator implements Compartor<Data> {
            public int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }

    enum Menu {

    }
}
