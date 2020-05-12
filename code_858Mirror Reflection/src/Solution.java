public class Solution {
    public int mirrorReflection(int p, int q) {
        /*
        * 数学原理：当上移是p/最小公倍数--偶，最终会在下边，反之，在上边。(没反射一次，向上移动p)
        * 如果在上边，当反弹次数为奇数，在2，反之，在1
        * */
        int m=p,n=q;
        int temp=0;
        while(n>0){
            temp=m%n;
            m=n;
            n=temp;
        }
        if(((p/m)&1)==0){//判断反弹边界（北墙）
            return 2;
        }else if(((q/m)&1)==0) {//向上移动距离是q的偶数倍,就返回0点了
            return 0;
        }
        return 1;
    }
}
