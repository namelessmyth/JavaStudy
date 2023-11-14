package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150">
 * 135. 分发糖果
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee135 {
    /**
     * <ol>
     *     <li>先给所有学生 1 颗糖</li>
     *     <li>从左到右循环。如果左边<右边，则右边+1</li>
     *     <li>从右到左循环。如果左边>右边且实际糖果数不比右边大，则左边+1</li>
     *     <li>从右到左循环过程累加总数量</li>
     * </ol>
     *
     * @return
     */
    public int candy(int[] ratings) {
        //存放糖果数量
        int[] candy = new int[ratings.length];
        Arrays.fill(candy, 1);

        for (int i = 1; i < ratings.length; i++) {
            //左规则循环
            if (ratings[i - 1] < ratings[i]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        int count = candy[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            //右规则循环，如果左边的评分比右边的大且当前数组中值不比右边的大，则修改值
            if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
                candy[i] = candy[i + 1] + 1;
            }
            count += candy[i];
        }
        return count;
    }

    public int candyOfficial(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {
            //左规则循环
            if (ratings[i - 1] < ratings[i]) {
                left[i] = left[i - 1] + 1;
            }
        }
        int count = left[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i--) {
            //右规则循环
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            count += Math.max(left[i], right[i]);
        }

        return count;
    }


    public static void main(String[] args) {
        int[] input = {1, 2, 3, 4, 3, 2, 1};
        System.out.println(new Lee135().candy(input));
    }
}
