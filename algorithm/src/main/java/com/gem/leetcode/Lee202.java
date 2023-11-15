package com.gem.leetcode;

/**
 * <a href="https://leetcode.cn/problems/happy-number/">
 * 202. 快乐数
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee202 {
    /**
     * 将入参每个位置上的数平方之后累加。
     */
    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            //获取n个位上的数。
            int d = n % 10;
            //将n缩小一倍，也就逐渐获取更高位上值
            n = n / 10;
            //将个位上平方累加
            totalSum += d * d;
        }
        return totalSum;
    }

    /**
     * <ol>
     *     <a href="https://leetcode.cn/problems/happy-number/solutions/224894/kuai-le-shu-by-leetcode-solution/?envType=study-plan-v2&envId=top-interview-150">快慢指针法</a>
     *     这道题只会有以下2种情况，
     *     <li>是快乐数，要么是快指针先到1，要么是慢指针到1之后，他两最终相遇（相等）。</li>
     *     <li>计算结果存在死循环，也就是链表存在环，那快慢指针一定会相遇</li>
     *     <li>计算结果变得无穷大，快慢指针永不相遇，这种情况不会出现。
     *          <ol>
     *              <li>这种情况实际不存在，int最大值是一个10位数，值也就是260</li>
     *              <li>就算10个位数都是9，他们的平方相加最大也就810</li>
     *              <li>所以最终一定会困在3位以内不断循环，要么到1要么相遇</li>
     *          </ol>
     *     </li>
     * </ol>
     */
    public boolean isHappy(int n) {
        //慢指针
        int slowRunner = n;
        //快指针
        int fastRunner = getNext(n);
        //如果快指针到1了或者快慢指针相遇了就停止循环。（不用担心两者相遇不了，因为只要能到1，最终一定会相等）
        while (fastRunner != 1 && slowRunner != fastRunner) {
            //慢指针1次跳1
            slowRunner = getNext(slowRunner);
            //快指针1次跳2
            fastRunner = getNext(getNext(fastRunner));
        }
        //如果快指针为1，就返回true，如果快指针相遇都没到1，那这个数不是快乐数。
        return fastRunner == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Lee202().isHappy(Integer.MAX_VALUE));
    }
}
