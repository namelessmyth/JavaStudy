package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/gas-station/description/?envType=study-plan-v2&envId=top-interview-150">
 * 134. 加油站
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee134 {
    /**
     * <ol>
     *     <li>创建一个数组answer，第0位为1，然后从入参数组nums左边开始累加乘积。</li>
     *     <li>answer[0]=1, answer[1]=nums[0]*answer[0], answer[2]=nums[1]*answer[1], 直至尾部</li>
     *     <li>然后定义一个临时变量r=1，从尾部开始循环answer[n-1]=answer[i]*R，并将nums中从尾部开始的值累加在R中的</li>
     *     <li>这样时间复杂度就是O(2n)，空间复杂度为O(1),输出数组不被视为额外空间</li>
     * </ol>
     *
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        // gas[i]-cost[i]的总和
        int sum = 0;
        //记录累计时的最小值
        int min = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < min) {
                min = sum;
                //如果每一站加的油都够，那就是第0个，随便从哪个开始都可以。如果不够，那必须会有下一站充进去的油可以抵掉消耗的油。
                //这里不用担心数组下标越界，因为i不可能是最后一个。如果到了最后一个total还是负的。那就是无解。
                result = i + 1;
            }
        }
        if (sum < 0) {
            //如果总差值小于零，说明总油量不够行驶一周，无解。
            result = -1;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] gas = new int[]{3,1,1};
        int[] cost = new int[]{1,2,2};
        int result = new Lee134().canCompleteCircuit(gas, cost);
        System.out.println(Arrays.toString(gas));
        System.out.println(result);
    }
}
