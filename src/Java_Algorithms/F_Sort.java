package Java_Algorithms;

class F_Sort {

    static void fSort(int[] arr){
        int i;  int max = arr[0];
        // # 도수 분포표의 크기를 정하기 위해 최대값을 구함
        for(i = 0; i < arr.length; i++){
            if(arr[i] > max)
                max = arr[i];
        }
        //도수 분포표 생성
        int[] f = new int[max+1];

        // # 도수 분포표 작성
        for(i=0; i<arr.length; i++){
            f[arr[i]]++;
        }

        // # 누적 도수 분포표 작성
        for(i=1; i<=max; i++){
            f[i] += f[i-1];
        }

        int [] b = new int[arr.length];
        for(i=arr.length - 1; i>=0; i--){
            b[--f[arr[i]]] = arr[i];
        }
        for(i=0; i<arr.length; i++)
            arr[i] = b[i];
    }

    static void print(int[] arr){
        for(int i = 0; i<arr.length; i++){
            System.out.printf("%2d", arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] arr = {8,4,9,7,4,3,1,2,5,3};
        fSort(arr);
        print(arr);

    }
}
