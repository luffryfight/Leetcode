package cn.nothing;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    * 类似于南阳OJ的螺旋数组，本题注重细节
    * */
    int up,down,right,left;
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        if(matrix.length==0) return list;
        int m=matrix.length,n=matrix[0].length;
        //定于坐标
        int i=0,j=0;
        //定义四个变化的边界
        up=0;down=m-1;left=0;right=n-1;
        while(left<=right&&up<=down){
            while(j<=right&&isright()) list.add(matrix[i][j++]);
            j--;up++;
            while(i<=down&&isright()) list.add(matrix[i++][j]);
            i--;right--;
            while(j>=left&&isright()) list.add(matrix[i][j--]);
            j++;down--;
            while(i>=up&&isright()) list.add(matrix[i--][j]);
            i++;left++;
        }
        return list;
    }
    public boolean isright(){//加上边界条件
        return up<=down&&left<=right;
    }
}
