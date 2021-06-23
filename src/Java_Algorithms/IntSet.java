package Java_Algorithms;

public class IntSet {
    private int max;
    private int num;
    private int[] arr;

    public IntSet(int capacity){
        max = capacity;
        num = 0;
        try{
            arr = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    public int capacity(){
        return max;
    }

    public int size(){
        return num;
    }

    public int indexOf(int n){
        for(int i=0; i<num; i++) {
            if(arr[i] == n)
                return i;
        }
        return -1;
    }

    public boolean contains(int n){
        return indexOf(n) == -1 ? false : true;
    }

    public boolean add(int n){
        if(num < max && !contains(n)){
            arr[++num] = n;
            return true;
        }
        return false;
    }

    public boolean remove(int n){
        if(num > 0 && contains(n)){
            int temp = indexOf(n);
            arr[temp] = arr[--num];
            return true;
        }
        else
            return false;
    }

    public void copyTo(IntSet s){
        int n = s.max < num ? s.max : num;
        for(int i=0; i<n; i++){
            s.arr[i] = arr[i];
        }
        s.num = n;
    }

    public void copyFrom(IntSet s){
        int n = (max < s.num) ? max : s.num;
        for(int i=0; i<n; i++){
            arr[i] = s.arr[i];
        }
        this.num = n;
    }

    public boolean equalTo(IntSet s) {
        if (s.num != num)
            return false;

        for (int i = 0; i < num; i++) {
            if (!contains(s.arr[i]))
                return false;
        }
        return true;
    }

    public void UnionOf(IntSet s1,IntSet s2){
        copyFrom(s1);
        for(int i=0; i<s2.num; i++)
            add(s2.arr[i]);
    }

    @Override
    public String toString(){
        StringBuffer temp = new StringBuffer("{");
        for(int i=0; i<num; i++){
            temp.append(arr[i] + " ");
        }
        temp.append("}");
        return temp.toString();
    }
}
