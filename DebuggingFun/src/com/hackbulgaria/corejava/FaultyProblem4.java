package com.hackbulgaria.corejava;

public class FaultyProblem4 {
    public static boolean areEqual(int e, int k) {
//        k++;
//        k--;
        return e == k;
    }

    public static boolean areEqual(float a, float b) {
        return Math.abs(a - b) < 0.00001;
    }

    public static boolean haveEqualSubstrings(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            String substringA = a.substring(i, a.length());
            String substringB = b.substring(i, a.length());
            if (substringA.equals(substringB)){
                return true;
            }
        }
        return false;
    }
}
