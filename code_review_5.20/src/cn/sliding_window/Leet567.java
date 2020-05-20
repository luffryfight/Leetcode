package cn.sliding_window;

public class Leet567 {
    public static boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        char[] str1=s1.toCharArray();
        char[] str2=s2.toCharArray();
        //
        int[] sArr=new int[26];
        int[] tArr=new int[26];
        //初始化
        int valid=0;
        for (int i = 0; i < s1.length(); i++) {
            sArr[str1[i]-'a']++;
            if(sArr[str1[i]-'a']==1){
                valid++;//有效的
            }
        }
        int left=0,right=0;
        int count=0;
        //遍历
        while(right<s2.length()){
            int ch=str2[right]-'a';
            right++;
            if(sArr[ch]!=0){//判断是否存在
                tArr[ch]++;
                if(tArr[ch]==sArr[ch]){
                    count++;
                }
            }
            while(right-left>=s1.length()){//超出窗口范围
                if(valid==count){
                    return true;
                }
                int temp=str2[left]-'a';
                left++;
                if(sArr[temp]!=0){
                    if(tArr[temp]==sArr[temp]){
                        count--;
                    }
                    tArr[temp]--;
                }

            }

        }
        return false;
    }

    public static void main(String[] args) {
        String s1="abc";
        String s2="bbbca";
        System.out.println(Leet567.checkInclusion(s1,s2));
    }
}
