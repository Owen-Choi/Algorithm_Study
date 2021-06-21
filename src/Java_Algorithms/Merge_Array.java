package Java_Algorithms;

class Merge_Array {
    static int[] Merge(int[] Aarr, int[] Barr){
        int[] arr = new int[Aarr.length + Barr.length];
        int pa,pb,pc;           //3가지 배열의 포인터들
        pa = pb = pc = 0;
        while(pa <= Aarr.length-1 || pb <= Barr.length - 1){

            while(pa < Aarr.length && pb < Barr.length){
                arr[pc++] = (Aarr[pa] <= Barr[pb]) ? Aarr[pa++] : Barr[pb++];
            }
            while(pa < Aarr.length){
                arr[pc++] = Aarr[pa++];
            }
            while(pb < Barr.length){
                arr[pc++] = Barr[pb++];
            }
        }
        return arr;
    }

    static void print(int[] arr){
        for(int i=0; i<arr.length; i++){
            System.out.printf("%3d", arr[i]);
        }
    }

    public static void main(String[] args) {
        int[] Aarr = {1,3,5,7,9};
        int[] Barr = {2,4,6,8,10};
        print(Merge(Aarr, Barr));
    }
}
