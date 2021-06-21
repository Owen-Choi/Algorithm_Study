package Java_Algorithms;

import java.util.Stack;

class Quick_Sort_Non_Recursion {
    static void Quick(int[] arr, int StartPoint, int FinishPoint){
        Stack<Integer> leftStack = new Stack<Integer>();
        Stack<Integer> rightStack = new Stack<Integer>();
        int pl; int pr;
        int pivot;  int temp;   int pivotValue;
        leftStack.push(StartPoint);
        rightStack.push(FinishPoint);

        while(!leftStack.isEmpty()){
            pl = StartPoint = leftStack.pop();
            pr = FinishPoint = rightStack.pop();
            pivot = (StartPoint + FinishPoint)/2;
            pivotValue = arr[pivot];
            //pl과 pr, StartPoint와 FinishPoint의 값은 계속해서 변하기 때문에
            //이렇게 값을 계속 저장해주는 편이 안전하다.

            do{
                while(arr[pl] < pivotValue) pl++;
                while(arr[pr] > pivotValue) pr--;
                // swap
                if(pl <= pr){
                    temp = arr[pl];
                    arr[pl] = arr[pr];
                    arr[pr] = temp;
                    pl++;   pr--;
                }
            }while(pl <= pr);

            if(StartPoint < pr){
                leftStack.push(StartPoint);
                rightStack.push(pr);
            }
            if(FinishPoint > pl){
                leftStack.push(pl);
                rightStack.push(FinishPoint);
            }
        }
    }

    static void print(int[] arr) {
        for(int i=0; i<arr.length; i++)
            System.out.printf("%2d", arr[i]);
    }

    public static void main(String[] args) {
        int[] arr = {8,9,4,1,2,7,5};
        Quick(arr, 0, arr.length - 1);
        print(arr);
    }
}
