public class Ring_Buffer_Queue_Class {
    int rear;
    int max;
    int[] queue;
    int front;
    int num;
    public class EmptyRingBufferException extends RuntimeException{
        public EmptyRingBufferException() { }
    }
    public class OverflowRingBufferException extends RuntimeException{
        public OverflowRingBufferException() { }
    }

    public Ring_Buffer_Queue_Class(int capacity){
        max = capacity;
        rear = front = num = 0;
        try{
            queue = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int Enqueue(int key) throws OverflowRingBufferException{
        if(num >= max)
            throw new OverflowRingBufferException();
        queue[rear++] = key;
        num++;
        if(rear == max)
            rear = 0;
        return key;
    }

    public int Dequeue() throws EmptyRingBufferException{
        if(num <= 0)
            throw new EmptyRingBufferException();
        int Deleted = queue[front++];
        num--;
        if(front == rear)
            front = 0;
        return Deleted;
    }

    public int Peek() throws EmptyRingBufferException{
        if(num <= 0)
            throw new EmptyRingBufferException();
        return queue[front];
    }

    // 잘못된 코드 : Ringbuffer라서 단순히 생각하면 안된다.
   /* public int indexOf(int value){
        for(int i = rear; i >= front; i--){
            if(queue[i] == value)
                return i;
        }
        return -1;
    }*/

    public int indexOf(int value){
        for(int i = 0; i < num; i++){
            if(queue[(i + front) % max] == value)
                return ((i + front) % max);
        }
        return -1;
    }
    public void clear(){
        front = rear = num = 0;
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }

    public boolean isEmpty(){
        return num <= 0;
    }

    public boolean isFull(){
        return num >= max;
    }

    public void dump(){
        for(int i = 0; i < num; i++){
            System.out.println(i+1 + "th value is " + queue[(i + front) % max]);
        }
    }
}
