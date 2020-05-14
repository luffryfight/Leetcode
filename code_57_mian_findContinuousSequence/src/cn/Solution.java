package cn;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static int[][] findContinuousSequence(int target) {
        //两个指针：若和小，则r++，反之l++
        int lim=target/2+1;
        List<int[]> save=new ArrayList<>();
        int l=1, r=1;
        int sum=2;
        int count=0;
        while(r<=lim&&l<=r){
            if(sum==target){
                int[] temp=new int[r-l+1];
                for (int i = l; i <= r; i++) {
                    temp[i-l]=i;
                }
                save.add(temp);
                l++;
            }else if(sum>target){//sum大于，缩小范围
                l++;
            }else{
                r++;
            }
            sum=(l+r)*(r-l+1)/2;
        }
        return save.toArray(new int[save.size()][]);
    }

    public static void main(String[] args) {
        System.out.println(Solution.findContinuousSequence(9));
    }
}
