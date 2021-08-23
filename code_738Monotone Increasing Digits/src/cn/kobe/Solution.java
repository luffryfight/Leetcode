package cn.kobe;

/**
 * @author 86137
 * @date 2021/7/8 17:19
 * TODO:  laji....
 */
public class Solution {
    String res=null;
    int flag=0;
    public void getTanxin(char[] str,int index,StringBuilder sb,int pre){
        if (flag==3) return;
        if(index==str.length) {
            res=sb.toString();flag=3;
            return;
        }
        int curNum=str[index]-'0';
        if (flag==1) curNum=9;
        for(int i=curNum;i>=0;i--){
            if(pre<=curNum||flag==1){
                sb.append(i);
                getTanxin(str,index+1,sb,curNum);
                flag=flag==3?3:1;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution2=new Solution();

        char[] str = "120".toCharArray();
        int max=str[0]-'0';
        for(int i=max;i>=0;i--){
            if (solution2.res==null&&i!=max) solution2.flag=1;
            solution2.getTanxin(str,1,new StringBuilder().append(i),i);
        }
        System.out.println(Integer.parseInt(solution2.res));
    }
}
