package cn.kobe;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res=new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        int[] segments=new int[4];
        dfs(s,0,0,segments);
        return res;
    }
    private void dfs(String s,int index,int nums,int[] segments){
        if(nums==4){
            if(index==s.length()){
                StringBuilder sb=new StringBuilder();
                for (int i = 0; i < 3; i++) {
                    sb.append(segments[i]).append(".");
                }
                sb.append(segments[3]);
                res.add(sb.toString());return;
            }
            return;
        }
        if (index==s.length())
            return;
        //处理特殊情况 比如 010
        if(s.charAt(index)=='0'){
            segments[nums]=0;
            dfs(s,index+1,nums+1,segments);
        }
        int sum=0;
        for (int i = index; i < s.length(); i++) {
            sum=sum*10+(s.charAt(i)-'0');
            if(sum<=255&&sum>0){//注意这里sum>0
                segments[nums]=sum;
                dfs(s,index+1,nums+1,segments);
            }else break;//这里必须break
        }
    }
}
