import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;

public class ArrayUtils {

    public static void fillRandom(Array arr, int max) {
        Random rand = new Random();
        for (int i = 0; i < arr.size(); i++) {
            arr.set(i, rand.nextInt(max));
        }
    }

    public static void fillFromConsole(Array arr) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < arr.size(); i++) {
            System.out.printf("arr[%d]: ", i);
            while (!scanner.hasNextInt()) {
                scanner.next();
                System.out.printf("Некорректный ввод. Пожалуйста, введите целое число для arr[%d]: ", i);
            }
            arr.set(i, scanner.nextInt());
        }
    }

    public static void fillFromFile(Array arr, String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            int index = 0;
            while (scanner.hasNextInt() && index < arr.size()) {
                arr.set(index++, scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }
    }

    public static void mergeSort(Array arr) {
        int n = arr.size();
        if (n <= 1) return;

        int mid = n / 2;
        Array leftArr = new Array(mid);
        Array rightArr = new Array(n - mid);

        for (int i = 0; i < mid; i++) {
            leftArr.set(i, arr.get(i));
        }
        for (int i = 0; i < n - mid; i++) {
            rightArr.set(i, arr.get(i + mid));
        }

        mergeSort(leftArr);
        mergeSort(rightArr);
        merge(arr, leftArr, rightArr);
    }

    private static void merge(Array arr, Array leftArr, Array rightArr) {
        int leftSize = leftArr.size();
        int rightSize = rightArr.size();
        int i = 0, j = 0, idx = 0;

        while (i < leftSize && j < rightSize) {
            if (leftArr.get(i) <= rightArr.get(j)) {
                arr.set(idx++, leftArr.get(i++));
            } else {
                arr.set(idx++, rightArr.get(j++));
            }
        }

        while (i < leftSize) {
            arr.set(idx++, leftArr.get(i++));
        }

        while (j < rightSize) {
            arr.set(idx++, rightArr.get(j++));
        }
    }

}
