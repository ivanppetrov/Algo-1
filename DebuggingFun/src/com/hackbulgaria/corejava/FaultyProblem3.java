package com.hackbulgaria.corejava;

public class FaultyProblem3 {
    
    public String reverseEveryWordInString(String sentence){
        String[] words = sentence.split(" ");
        String result = "";
        for (String word: words){
        	sentence = sentence.replaceFirst(word, reverse(word).toString());
        }
        return sentence;
    }

    private CharSequence reverse(String word) {
        return Utils.reverseMe(word);
    }
}
