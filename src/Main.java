import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] toSort = new int[]{1, 9, 4, 6, 2, 5, 7, 3, 0, 1 , -1000, 90, 12, 3, 12, 45, 6};
        int[] sorted = mergeSort(toSort);
        for (int i = 0; i < sorted.length; i++) {
            System.out.print(sorted[i] + " ");
        }
    }

    public static int[] mergeSort(int[] a) {
        if (a.length < 2) return a;

        int[] leftArr = slice(a, 0, a.length / 2);
        int[] rightArr = slice(a, a.length / 2, a.length);

        leftArr = mergeSort(leftArr);
        rightArr = mergeSort(rightArr);

        return merge(leftArr, rightArr);
    }

    public static int[] merge(int[] leftArr, int[] rightArr) {
        ArrayList<Integer> mergedList = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while ((leftIndex < leftArr.length) && (rightIndex < rightArr.length)) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                mergedList.add(leftArr[leftIndex]);
                leftIndex++;
            } else {
                mergedList.add(rightArr[rightIndex]);
                rightIndex++;
            }
        }
        int[] remainingLeft = slice(leftArr, leftIndex, leftArr.length);
        int[] remainingRight = slice(rightArr, rightIndex, rightArr.length);
        for (int i = 0; i < remainingLeft.length; i++) {
            mergedList.add(remainingLeft[i]);
        }
        for (int i = 0; i < remainingRight.length; i++) {
            mergedList.add(remainingRight[i]);
        }
        return mergedList.stream().mapToInt(i -> i).toArray();
    }

    // 1 9 4 6 2 5 7 3 0
    // 0 1 2 3 4 5 6 7 8
    public static int[] slice(int[] a, int start, int end) {
        // start (inclusive) to end (exclusive)
        int[] slice = new int[end - start];
        for (int i = 0; i < slice.length; i++) {
            slice[i] = a[start + i];
        }
        return slice;
    }

}