package Java_Algorithms;

import java.util.Scanner;

public class BinTreeTester {
    static Scanner sc = new Scanner(System.in);
    static class Data{

        private static final int NO = 1;
        private static final int NAME = 2;

        private Integer no;
        private String name;

        Integer KeyCode(){
            return no;
        }

        public String toString(){
            return name;
        }

        void scanData(String guide, int sw){
            System.out.println(guide + "할 데이터를 입력하세요");

            if((sw & NO) == NO){
                System.out.print("번호 : ");
                no = sc.nextInt();
            }
            if((sw & NAME) == NAME){
                System.out.print("이름 : ");
                name = sc.next();
            }
        }
    }

    enum Menu {
        ADD(      "삽입"),
        REMOVE(   "삭제"),
        SEARCH(   "검색"),
        PRINT(    "출력"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx){
            for(Menu m : Menu.values()){
                if(m.ordinal() == idx)
                    return m;
            }
            return null;
        }
        Menu(String string){
            message = string;
        }

        String getMessage(){
            return message;
        }
    }

    static Menu SelectMenu() {
        int key;
        do{
            for(Menu m : Menu.values()){
                System.out.printf(("(%d)%s "),m.ordinal(), m.getMessage());
            }
            System.out.printf(":");
            key = sc.nextInt();
        }while(key < Menu.ADD.ordinal() && key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }

    public static void main(String[] args) {
        Menu menu;
        Data data;
        Data ptr;
        Data temp = new Data();
        BinaryTree<Integer, Data>tree = new BinaryTree<Integer, Data>();

        do{
            switch(menu = SelectMenu()){
                case ADD:
                    data = new Data();
                    data.scanData("삽입", Data.NO | Data.NAME);
                    tree.add(data.KeyCode(), data);
                    break;
                case REMOVE:
                    temp.scanData("삭제", Data.NO);
                    tree.remove(temp.KeyCode());
                    break;
                case SEARCH:
                    temp.scanData("검색", Data.NO);
                    ptr = tree.search(temp.KeyCode());
                    if(ptr != null)
                        System.out.println("그 번호의 이름은 " + ptr + "입니다");
                    else
                        System.out.println("해당 데이터가 없습니다.");
                    break;
                case PRINT:
                    tree.print();
                    break;
            }
        }while(menu != Menu.TERMINATE);
    }
}
