package Java_Algorithms;

class Bubble_Sort {
    static void bubble(int[] arr){
        int i; int j;
        int exchange;   int temp;

        for(i = 0; i<arr.length - 1; i++){
            exchange = 0;
            for(j = arr.length - 1; j > i; j--){
                if(arr[j-1] > arr[j]){
                    temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                    exchange++;
                }
            }
            if(exchange==0) break;
        }
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%2d", arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 6, 4, 3, 9, 2};
        bubble(arr);
        print(arr);
    }
}
