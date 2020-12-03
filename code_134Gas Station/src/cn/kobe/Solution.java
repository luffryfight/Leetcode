package cn.kobe;

/**
 * 作用：
 * 2020/11/18
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (gas[i]<cost[i]) continue;
            else if (isCan(i,gas,cost))
                return i;
        }
        return -1;
    }
    public boolean isCan(int i,int[] gas,int[] cost){

        int index=i,len=gas.length;
        int sum=gas[i];
        while(index<2*len){
            if (sum<cost[index%len])//能到达下一个
                return false;
            if ((index+1)%len==i)//判断是否回到原点
                return true;
            index++;
            sum+=gas[index%len]-cost[(index-1)%len];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] num={1,2,3,4,5};
        int[] cost={3,5,4,4,3};
        Solution2 solution=new Solution2();
        System.out.println(solution.canCompleteCircuit(num,cost));
    }
}
