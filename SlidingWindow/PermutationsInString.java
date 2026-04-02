package SlidingWindow;
import java.util.Arrays;

/*
Permutation In String Leetcode: 567; Difficulty: Medium;

Given two strings s1 and s2, return  if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.
*/

public class PermutationsInString {
    public boolean containsPermutation(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i=0; i<s1.length(); i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        for(int i=0; i<s2.length() - s1.length(); i++) {
            if(Arrays.equals(map1, map2)) {
                return true;
            }
            map2[s2.charAt(i + s1.length()) - 'a']++;
            map2[s2.charAt(i) - 'a']--;
        }

        return Arrays.equals(map1, map2);
    }

    public static void main(String[] args) {
        String s1 = "aabmc";        
        String s2 = "abbcdaabcdfre";

        PermutationsInString obj = new PermutationsInString();
        boolean contains = obj.containsPermutation(s1, s2);

        if(contains) {
            System.out.println("Permuation exists.");
        } else {
            System.out.println("Permutation doesn't exist.");
        }
    }
}
