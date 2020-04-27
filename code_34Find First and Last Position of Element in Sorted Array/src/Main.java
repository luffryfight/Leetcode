public class Main {
    public static void main(String[] args) {
        int nums[]={5,7,7,8,8,10};
        int target=6;
        int arr[]=Solution2.searchRange(nums,target);
        System.out.println(arr[0]+" "+arr[1]);
    }
}
