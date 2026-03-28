/*
Longest Consecutive Sequence: Leetcode 128, Difficulty: Medium
Given an unsorted array of integers nums, return the lenght of the longest consecutive elements
sequence.
You must write an algorithm that runs in o(n) time.
*/

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int getLSC(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int lsc=1;
        int currLsc =1;
        for(int n: nums) {
            set.add(n);
        }

        for(int n: set) {
            if(set.contains(n-1)) {
                continue;
            } else {
                int num=n;
                currLsc=1;

                while(set.contains(num+1)) {
                    currLsc++;
                    num++;
                }

                if(lsc < currLsc) {
                    lsc=currLsc;
                }
            }
        }

        return lsc;
    }

    public static void main(String[] args) {
        int[] nums = {10, 30, 90, 0, 4, -1, 3, 5, 2, 1};

        LongestConsecutiveSequence obj = new LongestConsecutiveSequence();
        int lsc = obj.getLSC(nums);
        System.out.println(lsc);
    }
}
