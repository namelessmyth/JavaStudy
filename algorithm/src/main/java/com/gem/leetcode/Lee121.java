package com.gem.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150<br>
 * 121. 买卖股票的最佳时机
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee121 {
    /**
     * <ol>
     *     <li>从数组第一个数开始循环</li>
     *     <li>用当前位置的数开始第二层循环和他后面的每个数进行对比，记录最大差异</li>
     *     <li>如果有差异比之前记录的大的那就更新。如果没有就保持不变</li>
     * </ol>
     *
     * @param prices
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }
            }
        }
        return max;
    }

    public int maxProfitOffial(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    public int transcribeOffial(int prices[]) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{5, 6, 9, 1, 4};
        int result = new Lee121().maxProfit(nums1);
        System.out.println(Arrays.toString(nums1));
        System.out.println(result);
    }
}
