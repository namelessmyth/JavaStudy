package com.sjj.mashibing.algorithm.search;

/**
 * 局部最小值<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/2/1
 */
public class LocalMinimum {
    public static int find(int[] input) {
        int index = -1;
        if (input == null || input.length == 0) {
            return index;
        }
        int length = input.length;
        if (length == 1) {
            return 0;
        } else if (input[0] < input[1]) {
            //最左就是最小值的情况
            return 0;
        } else if (input[length - 2] > input[length - 1]) {
            //最右就是最小值的情况
            return length - 1;
        }
        //排除了上面的情况后，下面数组长度一定至少3个，用二分法查找剩余范围内的局部最小值。
        int L = 1;
        int R = length - 2;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (input[mid - 1] > input[mid] && input[mid] < input[mid + 1]) {
                index = mid;
                break;
            } else {
                //如果左边的值比中间值小，则去掉右半边。
                if (input[mid - 1] < input[mid]) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                }
            }
        }
        return index;
    }

    public static int[] randomArray(int lengthMax, int valueMax) {
        int length = (int) Math.random() * lengthMax;
        int[] arr = new int[length];
        if (length > 0) {
            arr[0] = (int) Math.random() * valueMax;
            for (int i = 1; i < length; i++) {
                do {
                    arr[i] = (int) Math.random() * valueMax;
                } while (arr[i] != arr[i - 1]);
            }
        }
        return arr;
    }

    /**
     * 检查结果的2边数值是否真的比自己大，大的话就是局部最小值。否则就不是。
     */
    public static boolean check(int[] arr, int minIndex) {
        if (arr.length == 0) {
            return minIndex == -1;
        }
        int left = minIndex - 1;
        int right = minIndex + 1;
        boolean leftBigger = left >= 0 ? arr[left] > arr[minIndex] : true;
        boolean rightBigger = right < arr.length ? arr[right] > arr[minIndex] : true;
        return leftBigger && rightBigger;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{3, 2, 3, 2, 3}));
        System.out.println("对数器测试开始");
        int maxLen = 100;
        int maxValue = 400;
        int testTime = 1000000;
        for (int i = 0; i < testTime; i++) {
            int[] arr = randomArray(maxLen, maxValue);
            int ans = find(arr);
            if (!check(arr, ans)) {
                printArray(arr);
                System.out.println(ans);
                break;
            }
        }
        System.out.println("对数器测试结束");
    }
}
