public class Solution {
    public int mirrorReflection(int p, int q) {
        /*
        * 数学原理：当上移是p/最小公倍数--偶，最终会在下边，反之，在上边。(没反射一次，向上移动p)
        * 如果在上边，当反弹次数为偶数，在2，反之，在1
        * k是反弹次数，kq是q的整数倍，此时就是最小公倍数位置
        * */
        int m=p,n=q;
        int temp=0;
        while(n>0){
            temp=m%n;
            m=n;
            n=temp;
        }
        if(((q/m)&1)==0) {//q/m==偶数是上移距离是P的倍数->S/p,一定是南墙
            return 0;
        }
        else if(((p/m)&1)==0){//p/m=k=S/q，就是反弹次数,偶数倍,在2点
            return 2;
        }
        return 1;
    }
}
