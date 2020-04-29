public class Solution2 {
    public static String intToRoman(int num){
        int[] nums= {1000,900,500,400,100,90,50,40,10,9,5,4,1} ;
        String[] s = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"} ;

        StringBuilder str=new StringBuilder();
        int index=0;
        while(index<13){
            if(num>=nums[index]){
                str.append(s[index]);
                num-=nums[index];
            }else{
                ++index;
            }
        }
        return str.toString();
    }
}
