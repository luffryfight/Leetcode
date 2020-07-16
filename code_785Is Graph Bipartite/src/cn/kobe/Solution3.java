package cn.kobe;

import java.io.StringReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    /*广度优先*/
    int[] node;
    public boolean isBipartite(int[][] graph){
        //获取节点个数
        int num=graph.length;
        //初始化
        node=new int[num];
        Arrays.fill(node,0);
        //遍历
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i < num; i++) {
            if(node[i]==0){
                node[i]=1;
                queue.offer(i);
                while(!queue.isEmpty()){
                    int ch=queue.poll();
                    //取反
                    int color= node[ch]==1?2:1;
                    for(int temp:graph[ch]){
                        if(node[temp]==0){
                            node[temp]=color;
                            queue.offer(temp);
                        }else if(node[temp]!=color){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
