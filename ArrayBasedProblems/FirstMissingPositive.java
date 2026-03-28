/*
First Missing Positive. Leetcode: 41, Difficulty: Hard

Given an unsorted integer array nums, return the smallest missing positive integer.
You must implement an algorithm that runs in O(n) time and uses constant extra space.
*/

public class FirstMissingPositive {
    public int getFirstMissingInt(int[] nums) {

        int contains=0;
        for (int n: nums) {
            if(n == 1){
                contains++;
                break;
            }
        }

        // If contains were 1 then that means the list contains 1;
        if(contains == 0) {
            return 1;
        }

        // Convert all nums that are less than 1 and greater than the length of the array to 1.
        for(int i=0; i<nums.length; i++){
            if(nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }

        // If the num is anything other than 1, Consider the curr val as index and go to that index 
        // and convert the value present in there to negative.
        int n=nums.length;
        for(int i=0; i<nums.length; i++) {
            int index = Math.abs(nums[i]); 
            if(index == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[index] = -Math.abs(nums[index]);
            }
        }

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > 0) {
                return i;
            }
        }
        
        if(nums[0] > 0) {
            return n;
        }

        return n+1;
    }
    public static void main(String[] args) {
        int[] nums = {2, 5, 4, 8, -1, 1, 55, -12};
        FirstMissingPositive obj = new FirstMissingPositive();
        int missing = obj.getFirstMissingInt(nums);
        System.out.println(missing);

    }
}