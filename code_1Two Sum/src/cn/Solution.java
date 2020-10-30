package cn;

public class Solution {
    static  int test=12;
//public:
//	vector<int> twoSum(vector<int>& nums, int target) {
//		int i = 0, j = 0;
//		for (i = 0; i<nums.size() - 1; i++)
//		for (j = i + 1; j<nums.size(); j++)
//		if (nums[i] + nums[j] == target)
//			return{ i, j };
//		return{ 0 };
//	}
    public static void main(String[] args) {
        boolean b=false;
        /*change(b);
        System.out.println(b);*/

    }
    public static void change(boolean a){
        //static int x=1;
        if(a){
            a=false;
            System.out.println(a);
        }else{
            a=true;
            System.out.println(a);
        }
    }
    public void note(){
        System.out.println(test);
        test=124;
        System.out.println(test);
    }
}
