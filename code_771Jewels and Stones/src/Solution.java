import java.util.HashSet;
/*本题可以用空间换时间*/
public class Solution {
    public static int numJewelsInStones(String J, String S) {
        HashSet<Character> set_J=new HashSet<>();
        for(char ch:J.toCharArray()){//放入
            set_J.add(ch);
        }
        int num_count=0;
        for (char ch:S.toCharArray()) {
            if(set_J.contains(ch)){
                num_count++;
            }
        }
        return num_count;
    }
}
