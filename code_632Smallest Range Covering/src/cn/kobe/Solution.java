package cn.kobe;

import java.util.Arrays;
import java.util.List;

class Solution {
    //借鉴的
    public int[] smallestRange(List<List<Integer>> nums) {
        int len = 0;
        for(List<Integer> list : nums)
            len += list.size();
        int[][] array = new int[len][2];
        int i = 0, j = 0;
        for(List<Integer> list : nums) {
            for(Integer v : list) {
                array[i][0] = v;
                array[i][1] = j;
                i++;
            }
            j++;
        }

        Arrays.sort(array, (o1, o2) -> (o1[0] - o2[0]));

        int[] res = new int[2];
        int[] count = new int[nums.size()];
        int k = 0;
        i = 0; j = 0;
        for(; i < len; i++) {
            if(count[array[i][1]]++ == 0) {
                k++;
            }

            if(k == nums.size()) {
                while(count[array[j][1]] > 1)
                    count[array[j++][1]]--;

                int d1, d2;
                if((res[0] == 0 && res[1] == 0)
                        || (d1 = res[1] - res[0]) > (d2 = array[i][0] - array[j][0])
                        || (d1 == d2 && array[j][0] < res[0]))
                    res = new int[] {array[j][0], array[i][0]};
            }
        }
        return res;
    }
}
