package com.gem.leetcode;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/">
 * 15. 三数之和
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //思路：排序 + 双指针
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) {
            // 因为前面已经排过序，如果当前数大于0，后面的数肯定更大于0，相加不可能等于0，所以结束循环
            if (nums[i] > 0) break;
            // 去重。
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //L从i右边开始。
            int L = i + 1;
            //R从数组右边开始
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else if (sum > 0) {
                    R--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum3ms(int[] nums) {
        return nSum(nums, 3, 0);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        return nSum(nums, 4, target);
    }

    public List<List<Integer>> nSum(int[] nums, int k, int target) {
        return new AbstractList<List<Integer>>() {
            final List<List<Integer>> res = new ArrayList<>();
            final List<Integer> path = new ArrayList<>();
            long min;

            @Override
            public List<Integer> get(int index) {
                init();
                return res.get(index);
            }

            @Override
            public int size() {
                init();
                return res.size();
            }

            public void init() {
                if (res.isEmpty()) {
                    int n = nums.length;
                    long[] Arr = new long[n];
                    Arrays.sort(nums);
                    min = nums[0];
                    for (int i = 0; i < n; i++) {
                        Arr[i] = nums[i] - min;
                    }
                    long NewTarget = (long) target - (long) k * min;
                    C(false, Arr, n, k, NewTarget);
                }
            }

            //C(n, k) = C(n - 1, k) + C(n - 1, k - 1)
            public void C(boolean T, long[] a, int n, int k, long target) {
                if (n == 0 || k == 0) {
                    if (target == 0 && k == 0) {
                        res.add(new ArrayList<>(path));
                    }
                    return;
                }
                if (k == 2) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    //两数之和模板
                    twoSum(a, 0, n - 1, target);
                    return;
                }
                if (n == k) {
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    //数组中元素和是否等于target
                    sumArr(a, n, target);
                    return;
                }
                if (check(a, n, k, target)) {
                    return;
                }
                C(false, a, n - 1, k, target);
                if (!T && n != a.length && a[n] == a[n - 1]) {
                    return;
                }
                if (target - a[n - 1] >= 0) {
                    path.add((int) (a[n - 1] + min));
                    C(true, a, n - 1, k - 1, target - a[n - 1]);
                    path.remove(path.size() - 1);
                }
            }

            void twoSum(long[] a, int l, int r, long target) {
                if (l >= r || a[r - 1] + a[r] < target || a[l] + a[l + 1] > target) {
                    return;
                }
                while (r > l) {
                    long sum = a[l] + a[r];
                    if (sum < target) {
                        l++;
                    } else if (sum > target) {
                        r--;
                    } else {
                        path.add((int) (a[l] + min));
                        path.add((int) (a[r] + min));
                        res.add(new ArrayList<>(path));
                        path.remove(path.size() - 1);
                        path.remove(path.size() - 1);
                        while (r > l && a[l] == a[l + 1]) {
                            l++;
                        }
                        while (r > l && a[r] == a[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }
                }
            }

            void sumArr(long[] a, int n, long target) {
                for (int i = n - 1; i > -1; i--) {
                    target -= a[i];
                    path.add((int) (a[i] + min));
                }
                if (target == 0) {
                    res.add(new ArrayList<>(path));
                }
                for (int i = n - 1; i > -1; i--) {
                    target += a[i];
                    path.remove(path.size() - 1);
                }
            }

            boolean check(long[] a, int n, int k, long target) {
                if (n - k < 0) {
                    return true;
                }
                long max = 0;
                long min = 0;
                for (int i = 0; i < k; i++) {
                    min += a[i];
                    max += a[n - i - 1];
                }
                if (target < min || target > max) {
                    return true;
                }
                return false;
            }
        };
    }

    public static void main(String[] args) {
        System.out.println(new Lee15().threeSum(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
