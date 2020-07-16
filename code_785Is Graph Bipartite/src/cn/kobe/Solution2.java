package cn.kobe;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution2 {
    /*染色法！两个颜色将所有点分为集合*/
    //1--蓝色---2---红色
    int []node;
    boolean res=true;
    public boolean isBipartite(int[][] graph){
        //获取总点数
        int num=graph.length;
        node=new int[num];
        //初始化
        Arrays.fill(node,0);
        for (int i = 0; i < num && res; i++) {
            if(node[i]==0)
                dfs(i,1,graph);
        }
        //如果中间没有出错
        return res;
    }
    private void dfs(int nod,int color,int[][] graph){
        node[nod]=color;
        //获取对应颜色
        int c = (color==1?2:1);
        for(int ch:graph[nod]){//遍历连接的点
            if(node[ch]==0){//没有标记过
                dfs(ch,c,graph);
                if(res==false)
                    return;
            }else if(c!=node[ch]){//对应集合不匹配
                res=false;return;
            }
        }
    }
}
