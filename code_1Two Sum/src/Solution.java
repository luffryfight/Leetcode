import java.util.SortedSet;

/**
 * @author 86137
 * @date 2021/7/4 11:39
 * TODO: //要消灭的是最具危险的  即最快到达的而不是距离最近的、、、、
 */
public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int len=dist.length;
        int[] vistied=new int[len];
        int res=0;
        while(res<len){
            int min=Integer.MAX_VALUE;
            int index=0;
            for(int i=0;i<len;i++){
                if(vistied[i]==0){
                    if(dist[i]<=0){
                        return res;
                    }
                    dist[i]-=speed[i];
                    if(dist[i]<min){
                        min=dist[i];
                        index=i;
                    }
                }
            }
            vistied[index]=1;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[] arr1 = {46, 33, 44, 42, 46, 36, 7, 36, 31, 47, 38, 42, 43, 48, 48, 25, 28, 44, 49, 47, 29, 32, 30, 6, 42, 9, 39, 48, 22, 26, 50, 34, 40, 22, 10, 45, 7, 43, 24, 18, 40, 44, 17, 39, 36};
        int[] arr2 = {1,   2,   1, 3,   1, 1, 1,   1, 1,   1, 1,   1,  1, 1,   7, 1,   1,  3,  2,  2,  2,  1, 2,  1, 1, 1,   1, 1,   1,  1,  1, 6,  1,   1,  1, 8,  1, 1,   1, 3,   6, 1,   3, 1, 1};

        solution.eliminateMaximum(arr1, arr2);
    }
}
