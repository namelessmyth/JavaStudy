package com.gem.leetcode;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150">274.H指数</a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee274 {
    /**
     * <ol>
     *     <li>返回值h的意思是：数组内至少有h个元素大于h，而且得是数组中可能的最大值。</li>
     *     <li>例如：[1,3,1]，返回1，代表至少有1个数大于等于1，[1,1]</li>
     *     <li>例如：[1,3,2]，返回2，代表至少有2个数大于等于2，[3,2]，此时1也成立，但不是可能的最大值</li>
     *     <li>例如：[3,0,6,1,5]，返回3，代表至少有3个数大于等于3，[3,6,5]。2也成立，但他不是最大值</li>
     *     <li>0<=h<=n,h和数组元素个数强相关，找到一个符合要求的就+1，例如：[100,199,200,1000]，返回值为4</li>
     * </ol>
     *
     * @return
     */
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        //因为要找最大值，所以排序后，从大到小循环
        int i = citations.length - 1;
        //通过分析题意：h大于等于0，小于等于length。
        int h = 0;
        //在遍历过程中如果找到当前值citations[i]>h则说明至少有一篇论文符合要求，可以+1
        while (i >= 0 && citations[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public int selfWrite(int[] citations) {
        int h = 0;
        Arrays.sort(citations);
        int i = citations.length - 1;
        while (citations[i] > h && i >= 0) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 0, 1, 2};
        int result = new Lee274().selfWrite(input);
        System.out.println(Arrays.toString(input));
        System.out.println(result);
    }
}
