import java.util.Arrays;
public class SplittingNumbersIntoTerms {
    public static void main(String[] args) {

    }
    public static int[] getNextPartition(int[] partition) { // вернёт ссылку на целочисенный массив, следующее разбиение
        if (partition.length == 1) { // разбиений больше нет
            return null;
        }
        int minIndex = 0;
        for (int i = 0; i < partition.length - 1; i++) { // ищем самый минимальный элемент от начала до предпоследнего
            if (partition[i] < partition[minIndex]) {
                minIndex = i;
            }
        }
        partition[minIndex] += 1; // увеличиваем минимальный элемент 1
        partition[partition.length - 1] -= 1; // уменьшаем последний элемент на 1
        minIndex += 1;
        int partSum = 0;
        for (int i = minIndex; i < partition.length; i++) {
            partSum += partition[i];
        }
        int[] nextPartition = Arrays.copyOf(partition, minIndex + partSum);
        for (int i = minIndex; i < nextPartition.length; i++) {
            nextPartition[i] = 1;
        }
        return nextPartition;

    }

    public static void printAllNumberPartitions(int number) {
        int[] partition = new int[number];
        Arrays.fill(partition, 1);
        for (; partition != null;) {
            System.out.println(Arrays.toString(partition));
            partition = getNextPartition(partition);
        }
    }
}
