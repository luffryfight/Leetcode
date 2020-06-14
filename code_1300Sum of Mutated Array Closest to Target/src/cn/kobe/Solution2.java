package cn.kobe;

public class Solution2 {
    /*
    * 思路就是那个思路，为啥就是写出来会差点意思？
    * */
    public static int findBestValue(int[] arr, int target){
        int len=arr.length;

        int max=0,sum=0;
        /*for (int i = 0; i < len; i++) {
            if(max<arr[i])
                max=arr[i];//找出最大值
            sum+=arr[i];
        }*/
        for(int ch:arr){
            sum+=ch;
            if(max<ch){
                max=ch;
            }
        }
        if(sum<=target) return max;
        //计算平均值
        int aver=target/len;
        while(true){
            int next=getSum(arr,aver+1);
            int curr=getSum(arr,aver);
            if(target<next&&target>curr){
                //下面这一步是比较两者谁的距离更小
                if(target*2>next+curr) aver++;
                break;
            }else{
                aver++;
            }
        }
        return aver;
    }
    //小于value相加，大于就加value
    public static int getSum(int[] arr,int value){
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]<value){
                sum+=arr[i];
            }else{
                sum+=value;
            }
        }
        return sum;
    }
}
