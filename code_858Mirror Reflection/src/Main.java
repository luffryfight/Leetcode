public class Main {
    public static void main(String[] args) {
        int i,m=3;
        double a=0.0;
        for(i=0;i<=m;i++)
            a=a+f(i);
        System.out.println(a);
    }
    public static double f(int n)
    {
        int i;
        double s=0;
        for(i=1;i<=n;i++)
            s+=1/i;
        return s;
    }
}
