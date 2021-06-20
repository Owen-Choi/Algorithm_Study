package Java_Algorithms;

class Shell_Sort {

    static void Shell(int[] arr){
        int i; int j;   int h;
        int temp;

        for(h = arr.length/2; h > 0; h/=2){
            for(i = h; i < arr.length; i++){
                temp = arr[i];
                for(j = i - h; j >= 0 && arr[j] > temp; j-=h){
                    arr[j+h] = arr[j];
                }
                arr[j+h] = temp;
            }
        }
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%2d", arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,9,4,2,7,5};
        Shell(arr);
        print(arr);
    }
}
