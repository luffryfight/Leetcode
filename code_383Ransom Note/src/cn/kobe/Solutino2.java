package cn.kobe;

public class Solutino2 {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote == "" && magazine == "") return true;
        else if (ransomNote == "" || magazine == "") return false;
        int len1 = ransomNote.length(), len2 = magazine.length();
        if (len1 > len2) return false;

        int l1 = 0, l2 = 0;
        while (l2 < len2) {
            if (magazine.charAt(l2) == ransomNote.charAt(l1)) {
                l1++;
                l2++;
                if (l1 == len1) return true;
            } else {
                l2++;
                l1 = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(Solutino2.canConstruct("", "a"));
    }
}
