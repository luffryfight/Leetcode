package cn.kobe;

public class SolutIon3 {
    //如果s由重复字符串构成，s+s的第二起始位置就不在length的位置
    //但是效率好像还没暴力法高
    public boolean repeatedSubstringPattern(String s) {
        return (s + s).indexOf(s, 1) != s.length();
    }
}
