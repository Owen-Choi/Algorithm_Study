import java.util.Scanner;

public class Stack_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;   int number;
        Stack_Class s = new Stack_Class(64);    //동적으로 할수는 없을까

        while(true){
            System.out.println("current data number : "+ s.size() + " / " + s.capacity());
            System.out.print("<1>push     <2>pop     <3>peek     <4>dump     <5>terminate : ");

            menu =sc.nextInt();
            if(menu == 5) break;

            switch(menu){
                case 1:
                    System.out.print("Please Enter Data you want to push : ");
                    number = sc.nextInt();
                    try{
                        s.push(number);
                    }catch(Stack_Class.OverflowIntStackException e){
                        System.out.println("Stack OverFlow Exception");
                    }
                    break;
                case 2:
                    try{
                        number = s.pop();
                        System.out.println(number + " is poped");
                    }catch(Stack_Class.EmptyIntStackException e){
                        System.out.println("Stack is Empty");
                    }
                    break;
                case 3:
                    try{
                        number = s.peek();
                        System.out.println("Peeked data is " + number);
                    }catch(Stack_Class.EmptyIntStackException e){
                        System.out.println("Stack is Empty");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
