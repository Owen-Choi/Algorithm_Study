package Java_Algorithms;

class Heap_Sort {

    static void Tree_Maker(int[] arr, int StartPoint, int FinishPoint){
        int parent; int LeftChild; int RightChild;  int BiggerChild;
        int root = arr[StartPoint];
        for(parent = StartPoint; parent < (FinishPoint + 1)/2; parent = BiggerChild){
            LeftChild = parent * 2 + 1;
            RightChild = LeftChild + 1;

            BiggerChild = (RightChild <= FinishPoint && arr[RightChild] > arr[LeftChild]) ? RightChild : LeftChild;

            if(root >= arr[BiggerChild]) break;
            arr[parent] = arr[BiggerChild];
        }
    arr[parent] = root;
    }

    static void Heap(int[] arr, int size){
        int j;  int temp;
        // # binary tree의 상태가 아닐 수도 있으니 최초에 한번 binary tree로 만들어준다.
        for(j = (size - 1)/2; j >=0; j--){              //j는 부모의 인덱스만 가진다.
            Tree_Maker(arr, (j-1)/2, size-1);
        }
        for(j = size - 1; j>0; j--){
            temp = arr[0];
            arr[0] = arr[j];
            arr[j] = temp;
            // # 루트와 말단의 요소를 교환한 뒤 다시 트리로 만들어준다.

            Tree_Maker(arr, 0, j-1);
        }
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++)
            System.out.printf("%2d", arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = {1,9,4,2,7,5};
        Heap(arr, arr.length);
        print(arr);
    }
}
