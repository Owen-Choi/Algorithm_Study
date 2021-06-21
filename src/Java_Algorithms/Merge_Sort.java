package Java_Algorithms;

class Merge_Sort {
    static int[] Merge(int[] arr, int StartPoint, int FinishPoint) {
        if (StartPoint < FinishPoint) {
            int i;
            int j, p, k;
            j = p = 0;
            k = StartPoint;
            // 분해할 때마다 초기화 해주는 이유는 다시 합칠 때 초기화 된 상태로 필요하기 때문.
            int pivot = (StartPoint + FinishPoint) / 2;

            Merge(arr, StartPoint, pivot);
            Merge(arr, pivot + 1, FinishPoint);

            // # 분해가 끝나면 시작되는 코드
            int[] temp = new int[FinishPoint - StartPoint + 1];
            for (i = StartPoint; i <= pivot; i++) {
                temp[p++] = arr[i];
            }
            while(i <= FinishPoint && j < p){
                arr[k++] = temp[j] <= arr[i] ? temp[j++] : arr[i++];
            }
            // # temp가 아닌 arr[i]가 남는 경우를 고려하지 않는 이유는 어차피 temp가 재귀가 진행될수록 남은 arr을 품기 때문인가?
            while(j < p)
                arr[k++] = temp[j++];
        }
        return arr;
    }

    static void print(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%2d", arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,7,3,1,4,6,9,8,2};
        print(Merge(arr, 0 , arr.length-1));
    }
}
