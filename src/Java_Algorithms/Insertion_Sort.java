package Java_Algorithms;

class Insertion_Sort {

    static void Insertion(int[] arr) {
        int i;
        int j;
        int insertPosition;
        int temp;

        for (i = 1; i < arr.length; i++) {
            temp = arr[i];
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = temp;
        }
    }
    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%2d", arr[i]);
        }
    }


    public static void main(String[] args) {
        int[] arr = {1,9,4,2,7,5};
        Insertion(arr);
        print(arr);
    }
}
