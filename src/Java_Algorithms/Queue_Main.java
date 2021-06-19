package Java_Algorithms;

import java.util.Scanner;

public class Queue_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;   int number;
        Queue_Class s = new Queue_Class(64);    //동적으로 할수는 없을까

        while(true){
            System.out.println("current data number : "+ s.size() + " / " + s.capacity());
            System.out.print("<1>Enqueue     <2>Dequeue     <3>peek     <4>dump     <5>terminate : ");

            menu =sc.nextInt();
            if(menu == 5) break;

            switch(menu){
                case 1:
                    System.out.print("Please Enter Data you want to Enqueue : ");
                    number = sc.nextInt();
                    try{
                        s.Enqueue(number);
                    }catch(Queue_Class.OverflowIntQueueException e){
                        System.out.println("Queue OverFlow Exception");
                    }
                    break;
                case 2:
                    try{
                        number = s.Dequeue();
                        System.out.println(number + " is Dequeue");
                    }catch(Queue_Class.EmptyIntQueueException e){
                        System.out.println("Queue is Empty");
                    }
                    break;
                case 3:
                    try{
                        number = s.peek();
                        System.out.println("Peeked data is " + number);
                    }catch(Queue_Class.EmptyIntQueueException e){
                        System.out.println("Queue is Empty");
                    }
                    break;
                case 4:
                    s.dump();
                    break;
            }
        }
    }
}
