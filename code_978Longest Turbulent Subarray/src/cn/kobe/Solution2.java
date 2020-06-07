package cn.kobe;

public class Solution2 {
    /*
    * 用两个状态数组优化代码：
    * f(k)表示以k结尾的且上行的结果
    * g(k)表示以k结尾的且下行的结果
    * 递归关系式：
    * 上行时：f(k)=g(k-1)+1; g(k)=1
    * 下行时：g(k)=f(k-1)+1; f(k)=1
    * 平行时：两者都为1
    *
    * base case:因为是判断A[k-1]和A[k-2],k从2开始
    * f(0)=g(0)=0
    * f(1)=g(1)=1//A的第一个
    * */
    public int maxTurbulenceSize(int[] A){
        if(A.length<=1) return A.length;
        //定义数组
        int[] f=new int[A.length+1];
        int[] g=new int[A.length+1];
        //base case:
        f[1]=1;f[0]=0;
        g[1]=1;g[0]=0;
        int res=1;
        for (int k = 2; k <= A.length; k++) {
            if(A[k-2]<A[k-1]){//上行
                f[k]=g[k-1]+1;
                g[k]=1;
            }else if(A[k-2]>A[k-1]){//上行
                g[k]=f[k-1]+1;
                f[k]=1;
            }else {
                f[k]=1;
                g[k]=1;
            }
            res=Math.max(res,Math.max(f[k],g[k]));
        }
        return res;
    }
}
