package com.sjj.mashibing.algorithm.random;

/**
 * 检查Math.random()方法生成随机数的概率是否符合要求<br>
 *
 * @author namelessmyth
 * @version 1.0
 * @date 2023/1/15
 */
public class RandomCheck {
    public static void main(String[] args) {
        //测试总次数
        int testTimes = 10000000;
        //实际符合要求值的次数
        int count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() < 0.5) {
                count++;
            }
        }
        System.out.println("实际出现概率："+ (double) count / (double) testTimes);

        // [0,1) -> [0,8) 统计0到大于1的整数
        count = 0;
        for (int i = 0; i < testTimes; i++) {
            if (Math.random() * 8 < 5) {
                count++;
            }
        }
        System.out.println("[0,8)范围内，实际出现5以内值的概率："+ (double) count / (double) testTimes);
        System.out.println((double) 5 / (double) 8);

        //将随机函数生成结果转成整型，统计每个整数的实际生成次数是否接近。
        int K = 9;
        //这个数组是用来统计0到8之间，每个整数的出现次数。counts[0]代表0出现的次数，counts[1]代表1出现的次数。
        int[] counts = new int[9];
        for (int i = 0; i < testTimes; i++) {
            //将生成的转成整型.0.12是0，8.79是8。
            int ans = (int) (Math.random() * K);
            // 根据生成的整型数值，将统计数组中对应位置++
            counts[ans]++;
        }
        for (int i = 0; i < K; i++) {
            System.out.println(i + "在0到8中的出现次数：" + counts[i]);
        }

    }
}
