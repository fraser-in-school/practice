import java.util.Arrays;

public class Quick {
    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = (int) (Math.random()* 100);
        }
        int[] arr2 = new int[] {42, 23, 5, 86, 54, 25, 79, 67, 66, 56};
        System.out.println(Arrays.toString(arr));
        sort(arr, 0, 999);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int left, int right) {
        if (left >= right) return ;
        int pivot = singlePivot(arr, left, right);
        sort(arr, left, pivot - 1);
        sort(arr, pivot + 1, right);
    }

    static int singlePivot(int[] arr, int left, int right) {
        int pivot = left;
        int key = arr[left];
        for(int i = left + 1; i <= right; i ++) {
            if (arr[i] < key) {
                arr[pivot] = arr[i];
                pivot ++;
                arr[pivot] = key;
                arr[i] = arr[pivot];
            }
        }
        return pivot;
    }
}

class Single {
    private volatile Single instance;
    private Single() {

    }

    public Single getInstance() {
        if (instance == null) {
            synchronized (Single.class) {
                if (instance == null) {
                    instance = new Single();
                }
            }
        }
        return instance;
    }

}
