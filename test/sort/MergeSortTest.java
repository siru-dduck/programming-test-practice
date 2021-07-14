package sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortTest {

    @Test
    public void mergeSort() {
        // when
        int[] arr = {63, 1, 2, 7, 9, 0, 20, 12, 70, -100, 0};

        System.out.println("=== 정렬전 ===");
        MergeSort.showArray(arr);

        // given
        MergeSort.mergeSort(arr);

        // then
        System.out.println("=== 정렬후 ===");
        MergeSort.showArray(arr);
        Assertions.assertArrayEquals(new int[]{-100, 0, 0, 1, 2, 7, 9, 12, 20, 63, 70}, arr);
    }

}