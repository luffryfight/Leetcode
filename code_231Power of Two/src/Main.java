import java.io.*;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        in.nextToken();
        int t = (int) in.nval;
        int i;
        long n, sum, mul;

        long[] foc = new long[10000005];
        long mod = 998244353;
        foc[0] = foc[1] = 1;
        for (i = 2; i < 10000005; i++)
            foc[i] = 1L * i * foc[i - 1] % mod;
        while (t-- > 0)
        {
            in.nextToken();
            n = (int) in.nval;
            sum = ((1 + n) * n / 2) % 998244353;
            pr.printf("%d ", sum * sum % mod);
            pr.println(fastPower(foc[(int) n], n <<1));
            pr.flush();
        }
        pr.flush();
    }

    public static long fastPower(long base,long power){
        long res=1;
        while(power>0){
            if((power&1)==1){
                res=(res*base)%998244353;
            }
            power>>=1;
            base=(base*base)%998244353;
        }
        return res%998244353;
    }
}