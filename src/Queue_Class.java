public class Queue_Class {
    int num;
    int max;
    int[] values;

    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){ };
    }
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException() { };
    }

    public Queue_Class(int capacity){
        max = capacity;
        num = 0;
        try{
            values = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int Enqueue(int key){
        if(num >= max)
            throw new OverflowIntQueueException();
        return values[num++] = key;
    }

    public int Dequeue(){
        if(num <= 0)
            throw new EmptyIntQueueException();
        return values[--num];
    }

    public int peek(){
        if(num <= 0)
            throw new EmptyIntQueueException();
        return values[num-1];
    }

    public int IndexOf(int key){
        for(int i=0; i < num; i++){
            if(values[i] == key)
                return i;
        }
        return -1;
    }

    public void clear(){
        num = 0;
    }

    public int capacity(){return max;}
    public int size(){return num;}
    public boolean isEmpty(){
        return num <= 0;
    }
    public boolean isFull(){
        return num >= max;
    }
    public void dump(){
        for(int i=0; i < num; i++){
            System.out.print(i + "th value is " + values[i]);
            System.out.println("");
        }
    }


}
