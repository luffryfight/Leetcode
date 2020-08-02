class A {
    public String show(D obj){
        return ("A and D");
    }
    public String show(A obj){
        return ("A and A");
    }
}
class B extends A{
    public String show(B obj){
        return ("B and B");
    }
    public String show(A obj){
        return ("B and A");
    }
}
class C extends B{}
class D extends B{}
public class Test {
    /*优先级由高到低依次为：
    this.show(O)、super.show(O)、this.show((super)O)、super.show((super)O)。
    */
    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();                      //--------改正
        System.out.println("1"+a1.show(b));//AA
        System.out.println("2"+a1.show(c));//AA
        System.out.println("3"+a1.show(d));//AD
        System.out.println("4"+a2.show(b));//BB -----BA
        System.out.println("5"+a2.show(c));//BA
        System.out.println("6"+a2.show(d));//BA -----AD
        System.out.println("7"+b.show(b));// BB
        System.out.println("8"+b.show(c));// BB
        System.out.println("9"+b.show(d));// AD
        System.out.println("10"+d.show(a1));//BA
        System.out.println("11"+d.show(a2));//BB-----BA
        System.out.println("11"+d.show(b));// BB
        System.out.println("12"+d.show(c));// BB
    }
}
