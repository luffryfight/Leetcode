package cn.kobe;

/**
 * 作用：
 * 2021/2/7
 */
public class Solution {

    //尝试1 超时
    /*public int maxScore(int[] cardPoints, int k) {
        return dfs(cardPoints,k,0,0,0,cardPoints.length-1);
    }

    public int dfs(int[] card,int k,int index,int score,int left,int right){
        if(index==k){
            return score;
        }

        return Math.max(dfs(card,k,index+1,score+card[left],left+1,right),
                    dfs(card,k,index+1,score+card[right],left,right-1));
    }*/

    public int maxScore2(int[] cardPoints, int k) {
        int len = cardPoints.length;//7
        int left = 0, right = len - 1;//6
        int max = 0, res = 0;
        for (int i = left; i < k; i++) {
            int temp = 0;
            for (int j = right; j > right - (k - i); j--) {
                temp += cardPoints[j];
                if (max + temp > res) {
                    res = temp + max;
                }
            }
            max += cardPoints[i];
        }
        return res;
    }

    //通过34个
    /*public int maxScore(int[] cardPoints, int k) {
        int len=cardPoints.length;//7
        int left=0,right=len-1;//6
        int max=0,res=0;
        for(int i=left;i<k;i++){
            int temp=0;
            for(int j=right;j>right-(k-i);j--){
                temp+=cardPoints[j];
                if(max+temp>res){
                    res=temp+max;
                }
            }
            max+=cardPoints[i];
        }
        return res;
    }*/


    //滑动窗口，保持区间长度 wideth  中和最小
    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;//7
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += cardPoints[i];
        }

        int temp = 0, min = Integer.MAX_VALUE;
        int wideth = len - k;
        for (int i = 0; i < len; i++) {
            temp += cardPoints[i];
            if (i >= wideth) {
                temp -= cardPoints[i - wideth];
            }
            if (i >= wideth - 1) {//索引和长度
                min = Math.min(min, temp);
            }
        }
        return sum - min;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 1};
        Solution solution = new Solution();
        System.out.println(solution.maxScore(arr, 3));
    }
}
