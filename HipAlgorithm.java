import java.util.Arrays;

public class HipAlgorithm {
    public static void main(String[] args) {

    }
    public static void HipAlgorithm(int[] nums, int k) {
        if (k == 1) {
            System.out.println(Arrays.toString(nums));
        } else {
            for (int i = 0; i < k; i++) {
                HipAlgorithm(nums, k - 1);
                if (k % 2 == 0) {
                    swap(nums, i, k - 1);
                } else {
                    swap(nums, 0, k - 1);
                }
            }
        }

    }

    public static void swap(int[] arr, int i, int i1) {
        int tmp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = tmp;
    }
}
