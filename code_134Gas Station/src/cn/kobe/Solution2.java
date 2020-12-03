package cn.kobe;

/**
 * 作用：尝试改进：有一点点贪心，，还不够贪心
 * 2020/11/18
 */
public class Solution2 {
    public int canCompleteCircuit(int[] gas, int[] cost){
        int res=-1;
        int len=gas.length;
        int[] fix=new int[len+1];
        fix[len]=0;
        for (int i = len-1; i >= 0; i--) {
            fix[i]=fix[i+1]+gas[i]-cost[i];
        }
        int sum=0;
        for (int i = 0; i < gas.length; i++) {
            sum+=gas[i]-cost[i];
            if (gas[i]<cost[i]){
                if (sum<0)
                    res=-1;
            }
            else if (sum+fix[i+1]>=0&&res==-1)
                    res=i;
        }
        return res;
    }
}
