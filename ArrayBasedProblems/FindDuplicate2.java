// Given an integer nums and integer k, return true if there are two distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

import java.util.HashMap;


public class FindDuplicate2 {
   public boolean containsDuplicate2(int[] nums, int k){
      HashMap<Integer, Integer> seen = new HashMap<>();
      int pos1=-1;
      int pos2=-1;

      for(int i=0; i<nums.length; i++){
         if(seen.containsKey(nums[i])){
            pos1=i;
            pos2=seen.get(nums[i]);
            break; 
         }
         seen.put(nums[i], i);
      }

      if(Math.abs(pos1-pos2) <= k && pos1 > -1){
         return true;
      }
      return false;
   }

   public static void main(String[] args){
      int[] nums = {10, 30, 40, 20, 10, 60};
      int k = 4;
      
      FindDuplicate2 dup = new FindDuplicate2();
      boolean result = dup.containsDuplicate2(nums, k);
      if(result){
         System.out.println("True");
      } else {
         System.out.println("False");
      }

   }
}
