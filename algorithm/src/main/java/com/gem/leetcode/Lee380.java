package com.gem.leetcode;

import cn.hutool.core.util.ObjectUtil;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/insert-delete-getrandom-o1/description/?envType=study-plan-v2&envId=top-interview-150">
 * 380.O(1)时间插入、删除和获取随机元素
 * </a><br>
 *
 * @author namelessmyth
 * @version 1.0
 */
public class Lee380 {
    public static class RandomizedSet {
        List<Integer> list;
        /**
         * key存数组的值，value存数组下标
         */
        Map<Integer, Integer> map;
        Random random;

        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            int index = list.size();
            list.add(val);
            map.put(val, index);
            return true;
        }

        public boolean remove(int val) {
            Integer mapIndex = map.get(val);
            if (mapIndex == null) {
                return false;
            }
            //找到列表最后一位元素
            Integer last = list.get(list.size() - 1);
            //用最后一位元素，替换要移除的元素（避免直接移除之后，后面的元素下标更新）
            list.set(mapIndex, last);
            //更新元素在map中的新位置
            map.put(last, mapIndex);
            //移除数组最后一位
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }

        public int getRandom() {
            int index = random.nextInt(list.size());
            return list.get(index);
        }

        public List<Integer> getList(){
            return this.list;
        }
    }


    public static void main(String[] args) {
        RandomizedSet set = new RandomizedSet();
        set.insert(10);
        set.insert(5);
        set.insert(6);
        set.insert(9);
        set.insert(8);
        set.insert(7);
        set.insert(9);
        System.out.println(ObjectUtil.toString(set.getList()));
        set.remove(5);
        System.out.println(ObjectUtil.toString(set.getList()));
        System.out.println(set.getRandom());
    }
}
