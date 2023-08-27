import java.util.Arrays;

public class QuickSort {
    
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int pointer = low;
        for(int i = low; i < high; i++) {
            if(arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[pointer];
                arr[pointer] = temp;
                pointer++;
            }
            System.out.println(Arrays.toString(arr));
        }
        int temp = arr[pointer];
        arr[pointer] = arr[high];
        arr[high] = temp;
        return pointer;
    }

    public static void sort(int[] arr, int low, int high){
        if (low < high) {
            int pos = partition(arr, low, high);
            sort(arr, low, pos - 1);
            sort(arr, pos + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,10,2,4,6,3,2,1,8,7,6};
        sort(arr, 0, arr.length-1);
    }
}
