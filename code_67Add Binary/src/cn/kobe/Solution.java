package cn.kobe;

public class Solution {
    public static String addBinary(String a, String b) {
        long num=change(a)+change(b);
        if(num==0) return "0";
        StringBuilder sb=new StringBuilder();
        while(num>0){
            sb.append(num%2);
            num/=2;
        }
        return sb.reverse().toString();
    }
    private static long change(String str){
        int sum=0;
        char[] s=str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            sum=sum*2+s[i]-'0';
        }
        return sum;
    }

    public static void main(String[] args) {
        String s1="10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String s2="110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        System.out.println(Solution.addBinary(s1,s2));
    }
}
