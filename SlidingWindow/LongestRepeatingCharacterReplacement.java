package SlidingWindow;
/*
Longest Repeating Character Replacement Leetcode: 424 Difficulty: Medium

You are given a string a and an integer k. You can choose any character of the string and change it to any other
uppercase character. You can perform the operation k times.

Return the length of the longest bstring of teh same letter you can get after performing the above operations.
*/

public class LongestRepeatingCharacterReplacement {
    public int solution(String s, int k) {
        int[] freqArr = new int[26];
        int left=0;
        int ans=0;
        int maxOccurance=0;

        for(int right=0; right < s.length(); right++) {
            maxOccurance = Math.max(maxOccurance, ++freqArr[s.charAt(right) - 'A']);

            if(((right - left) + 1) - maxOccurance > k) {
                freqArr[s.charAt(left) - 'A']--;
                left++;
            }
            ans = Math.max(maxOccurance, right-left+1);
        }
        return ans;
    }

    public static void main(String[] args) {    
        String s = "PXQXOXA";
        int k = 2;

        LongestRepeatingCharacterReplacement seq = new LongestRepeatingCharacterReplacement();
        int ans = seq.solution(s, k);
        System.out.println(ans);
    }
}