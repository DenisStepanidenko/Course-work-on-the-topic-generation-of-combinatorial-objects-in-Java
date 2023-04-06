import java.util.Arrays;

public class TheCarlFriedrichHindenburgAlgorithm {
    public static void main(String[] args) {

    }
    public static void printNumberPartition(int n, int m) {
        int[] part = new int[m];
        Arrays.fill(part, 1);
        part[0] = n - m + 1;
        for (; ; ) {
            System.out.println(Arrays.toString(part));
            if (part[0] < part[1] - 1) {
                part[0] -= 1;
                part[1] += 1;
            } else {
                int j = -1; // изначально предполагаем, что такого элемента нет
                int s = part[0] - 1;
                for (int i = 1; i < part.length; i++) {
                    if (part[i] < part[0] - 1) {
                        j = i;
                        break;
                    }
                    s += part[i];
                }
                if (j == -1) {
                    break;
                }
                part[j] += 1;
                for (int i = 1; i < j; i++) {
                    part[i] = part[j];
                    s -= part[j];
                }
                part[0] = s;
            }
        }
    }
}
