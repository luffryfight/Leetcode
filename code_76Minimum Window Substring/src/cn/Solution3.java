package cn;

//自己改进的
public class Solution3 {
    public static String minWindow(String s, String t) {
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        //
        int[] sArr = new int[128];
        int[] tArr = new int[128];
        //初始化
        int valid = 0;
        for (int i = 0; i < t.length(); i++) {
            tArr[str2[i]]++;
            /*if(tArr[str2[i]]==1){
                valid++;
            }*/
        }
        for (int i = 0; i < 128; i++) {//统计有效个数，即aa是算一个，因为不是map对应关系
            if (tArr[i] != 0) {                 //need,size()就会是一个,二数组是两个
                valid++;
            }
        }
        int left = 0, right = 0;
        int count = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < str1.length) {
            char ch = str1[right];
            right++;
            if (tArr[ch] != 0) {//包含
                sArr[ch]++;
                if (sArr[ch] == tArr[ch]) {//相同元素且个数相同
                    count++;
                }
            }
            while (valid == count) {
                if (right - left < len) {//更新结果
                    len = right - left;
                    start = left;
                }
                char temp = str1[left];
                left++;
                if (tArr[temp] != 0) {
                    if (sArr[temp] == tArr[temp]) {
                        count--;
                    }
                    sArr[temp]--;
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "aa";
        //System.out.println(Leet76.minWindow(s1,s2));
    }
}
