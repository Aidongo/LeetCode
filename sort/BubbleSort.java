
public class BubbleSort {

    public static int[] sort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for(int j = 0; j < arr.length - i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    
                    flag = false;
                }
            }

            if(flag)
                break;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {6,7,8,10,2,3};
        sort(arr);
    }

}