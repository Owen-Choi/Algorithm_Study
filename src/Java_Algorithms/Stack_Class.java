package Java_Algorithms;

public class Stack_Class {
    private int ptr;
    private int values[];
    private int max;

    public class EmptyIntStackException extends RuntimeException{
        public EmptyIntStackException() { }
    }

    public class OverflowIntStackException extends RuntimeException{
        public OverflowIntStackException() { }
    }

    public Stack_Class(int capacity) {
        ptr = 0;
        max = capacity;
        try{
            values = new int[max];
        } catch(OutOfMemoryError e){        //생성할 수 없는 경우를 catch 해준다.
            max = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException{
        if(ptr >= max)
            throw new OverflowIntStackException();
        return values[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return values[--ptr];
    }

    public int peek() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return values[ptr-1];
    }

    public int indexOf(int x){
        for(int i=ptr-1; i>=0; i--){
            if(values[i] == x)
                return i;
        }
        return -1;
    }

    public void clear(){
        ptr = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return ptr;
    }

    public boolean isEmpty(){
        return ptr <= 0;
    }

    public boolean isFull(){
        return ptr >= max;
    }

    public void dump(){
        for(int i = 0; i < ptr; i++){
            System.out.print(values[i] + " ");
            System.out.println();
        }
    }
}
