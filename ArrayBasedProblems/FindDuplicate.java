// Given an integer array nums, return true .if any value appears atleast twice in the array, return false if every element is distinct.

import java.util.HashSet;

public class FindDuplicate {
   public boolean findDuplicate(int[] nums){
      HashSet<Integer> seen = new HashSet<>();
      for (int i=0; i<nums.length; i++){
         if(seen.contains(nums[i])){
            return true;
         }
         seen.add(nums[i]);
      }
      return false; 

   }


   public static void main() {
      int[] nums = {10, 20, 40, 30, 20};
      FindDuplicate duplicate = new FindDuplicate();
      boolean exists = duplicate.findDuplicate(nums);
      if(exists) {
         System.out.println("Duplicate exists!");
      } else {
         System.out.println("Duplicate doesn't exist!");
      }
   }
}

