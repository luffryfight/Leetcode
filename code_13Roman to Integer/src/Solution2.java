public class Solution2 {
    public static int romanToInt(String s){
        int sum=0;
        int prestr=substr(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int temp=substr(s.charAt(i));
            if(prestr<temp){
                sum-=prestr;
            }else{
                sum+=prestr;
            }
            prestr=temp;
        }
        sum+=prestr;
        return  sum;
    }
    public static int substr(char str){
        switch (str){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
