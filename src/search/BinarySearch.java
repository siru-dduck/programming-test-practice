package search;

import java.util.Arrays;
import java.util.Random;

public class BinarySearch {

    static int search(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    static void showArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + ", ");
        }
        System.out.println();
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
        Arrays.sort(arr);
        int key = arr[5];

        // given
        int index = search(arr, key);

        // then
        System.out.println("=== 검색결과 ===");
        showArray(arr);
        if(index == -1) {
            System.out.printf("찾으려는 키값%d에 대한 결과가 없습니다.", key);
        } else{
            System.out.printf("찾으려는 키값%d 는 %d번째 인덱스에 있습니다. arr[%d]=%d\n", key, index, index, key);
        }
    }

}
