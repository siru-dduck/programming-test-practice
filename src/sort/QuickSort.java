package sort;

import java.util.Random;

public class QuickSort {

    static void swap(int[] arr, int i1, int i2) {
        if ((i1 < 0 || arr.length <= i1) || (i2 < 0 || arr.length <= i2)) {
            throw new ArrayIndexOutOfBoundsException("배열의 범위를 벗어났습니다.");
        }
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }

    static void showArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int startIndex, int endIndex) {
        int part = partition(arr, startIndex, endIndex);
        if (startIndex < part-1) {
            quickSort(arr, startIndex, part-1);
        }
        if (part < endIndex) {
            quickSort(arr, part, endIndex);
        }
    }

    static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left + right) / 2];
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left <= right) {
                swap(arr, left++, right--);
            }
        }
        return left;
    }

    static void assignRandomValueTo(int[] arr) {
        Random rand = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
    }

    public static void main(String[] args) {
        // when
        int[] arr = new int[30];
        assignRandomValueTo(arr);
        System.out.println("=== 정렬전 ===");
        showArray(arr);

        // given
        quickSort(arr);

        // then
        System.out.println("=== 정렬후 ===");
        showArray(arr);
    }
}
