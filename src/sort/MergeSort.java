package sort;

import java.util.Random;

public class MergeSort {
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

    static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            mergeSort(arr, tmp, start, mid, end);
        }
    }

    static void mergeSort(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while(part1 <= mid && part2 <= end ) {
            if(tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1++];
            } else {
                arr[index] = tmp[part2++];
            }
            index++;
        }
        for(int i =0; i <= mid-part1; i++) {
            arr[index + i] = tmp[part1 +i];
        }
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
        mergeSort(arr);

        // then
        System.out.println("=== 정렬후 ===");
        showArray(arr);
    }
}
