package com.sjj.mashibing.algorithm.leecode;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150">122.买卖股票的最佳时机 II</a><br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/9/15
 */
public class Lee122 {
    /**
     * <ol>
     *     <li>首先可以把每一天的股价理解成折线图，横坐标是第1天，第2天以此类推，纵坐标是股价</li>
     *     <li>这个折线图可能有的时候会上升有的时候平稳，有的时候下降，我们只需要找到其中的上升部分，累加起来就是最大利润。</li>
     *     <li>定义2个指针，一个记录低点，一个不停向前循环，只要大于等于上一个值就是代表在上升或平稳，当小于时就下降了。</li>
     *     <li>出现下降时，先用高点减去低点，累加到总的值里面。同时更新低点的值。</li>
     * </ol>
     *
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        if (prices == null || prices.length < 1) {
            return total;
        }
        int low = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                //如果当前值比上一个值小了，那上一个数就是折线图中，上升部分的最大值。
                total += prices[i - 1] - low;
                low = prices[i];
            } else if (i == prices.length - 1 && prices[i] >= prices[i - 1]) {
                //如果到达数组最后了还一直在升，就用最后一个减去低值。
                total += prices[i] - low;
            }
        }
        return total;
    }

    /**
     * <ol>
     *     <li>官方的题解和我的思路相同，但是方法比我还简单，我想的是用最高点减最低点，他是把每一天上升部分的累加起来</li>
     *     <li>而判断上升的方法也很巧妙，只要当前值减上一个值时正的就行：Math.max(0, prices[i] - prices[i - 1])</li>
     * </ol>
     *
     * @param prices
     * @return
     */
    public int transcribeOfficial(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 2, 2, 1, 9};
        int result = new Lee122().maxProfit(input);
        System.out.println(result);
    }
}
