/**
 * @author 86137
 * @date 2021/7/4 15:17
 * TODO:
 */
public class Test {
    int mod=1000000007;
    public int countGoodNumbers(long n) {
        long carry=20,res= n%2==0?1:5,len=n/2;
        int mod=1000000007;
        int t=1;
        while(len>0){
            if(len%2==1){
                System.out.println(res+":"+carry+":"+t);
                res=(res*carry)%mod;
            }
            len/=2;t*=2;
            carry=(carry*carry)%mod;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        Test test=new Test();
        System.out.println(test.countGoodNumbers(15));
    }
}
