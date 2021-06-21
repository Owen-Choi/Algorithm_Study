package Java_Algorithms;

class Quick_Sort {

    static void Quick(int[] arr, int StartPoint, int FinishPoint){

        int pl = StartPoint; int pr = FinishPoint;
        int pivot = (StartPoint + FinishPoint)/2;
        int temp;
        int pivotValue = arr[pivot];

        System.out.printf("arr[%d] ~ arr[%d]", StartPoint, FinishPoint);
        for(int i=StartPoint; i < FinishPoint; i++){
            System.out.printf("%d,  ", arr[i]);
        }
        System.out.println();

        do{
            while(arr[pl] < pivotValue)
                pl++;
            while(arr[pr] > pivotValue)
                pr--;
            // Swap
            if(pl <= pr) {
                temp = arr[pl];
                arr[pl] = arr[pr];
                arr[pr] = temp;
                pl++;   pr--;
            }
        }while(pl <= pr);

        if(StartPoint < pr) Quick(arr, StartPoint, pr);
        if(FinishPoint > pl) Quick(arr, pl, FinishPoint);
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%2d", arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,9,4,1,2,7,5};
        Quick(arr, 0, arr.length-1);
        print(arr);
    }
}
