package Java_Algorithms;

class Selection_Sort {
    static void Selection(int[] arr){
        int i;  int j;
        int smallest;   int temp;
        for(i = 0; i<arr.length - 1; i++){
            smallest = i;
            for(j = i+1; j<arr.length; j++){
                if(arr[j] < arr[smallest])
                    smallest = j;
            }
                temp = arr[smallest];
                arr[smallest] = arr[i];
                arr[i] = temp;
        }
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%2d", arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,4,2,7,5};
        Selection(arr);
        print(arr);
    }
}
