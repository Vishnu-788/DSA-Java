package SlidingWindow;

import java.util.HashSet;

/*
Longest Substring without repeating character Leetcode 3, Difficulty: Medium.
*/

public class LongestSubStringWithoutRepeatingCharacter {

	public int solution(String s) {
		HashSet<Character> visited = new HashSet<>();
		int ans = 0;
		int left = 0;
		int right = 0;

		while (right < s.length()) {
			char c = s.charAt(right);
			while(visited.contains(c)){
				visited.remove(s.charAt(left));
				left++;
			}
			visited.add(c);
			ans = Math.max((right-left)+1, ans);
			right++;
		}
		return ans;
	}

	public static void main(String[] args) {
		String s = "abatman";
		LongestSubStringWithoutRepeatingCharacter obj =
			new LongestSubStringWithoutRepeatingCharacter();
		int ans = obj.solution(s);
		System.out.println(ans);
	}
}
