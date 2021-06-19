package Java_Algorithms;

import java.util.Scanner;

public class Ring_Buffer_Queue_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int menu;   int value;
        Ring_Buffer_Queue_Class rb = new Ring_Buffer_Queue_Class(8);
        while(true) {
            System.out.println("current data number : " + rb.size() + " / " + rb.capacity());
            System.out.println("<1> : Enqueue     <2> : Dequeue     <3> : Peek     <4> : Dump     <5> : Terminate");

            menu = sc.nextInt();
            if(menu == 5)
                break;

            switch (menu){
                case 1:
                    System.out.println("please enter data : ");
                    value = sc.nextInt();
                    try{
                        rb.Enqueue(value);
                        System.out.println(value + "is Enqueued well");
                    }catch(Ring_Buffer_Queue_Class.OverflowRingBufferException e){
                        System.out.println("over flow Exception");
                    }
                    break;
                case 2:
                    try {
                        value = rb.Dequeue();
                        System.out.println(value + "is Dequeued well");
                    }catch(Ring_Buffer_Queue_Class.EmptyRingBufferException e){
                        System.out.println("Empty queue Exception");
                    }
                    break;
                case 3:
                    try{
                        value = rb.Peek();
                        System.out.println(value + "is Peek data");
                    }catch(Ring_Buffer_Queue_Class.EmptyRingBufferException e){
                        System.out.println("Empty queue Exception");
                    }
                    break;
                case 4:
                    rb.dump();
                    break;
            }
        }
    }
}
