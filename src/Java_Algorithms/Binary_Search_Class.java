package Java_Algorithms;

public class Binary_Search_Class {
    int[] array;    int target;
    int indexMax;   int indexMin;   int index;
    public Binary_Search_Class(int[] arr, int target){
        array = arr.clone();
        this.target = target;
    }

    public int BinarySearch(){
        indexMax = array.length - 1;
        indexMin = 0;

        do{
          index = (indexMax + indexMin)/2;
          if(array[index] == target)
              return index;
          else if(array[index] < target){
              indexMin = index + 1;
          }
          else
              indexMax = index - 1;
        } while(indexMin <= indexMax);
        return -1;
    }


}
