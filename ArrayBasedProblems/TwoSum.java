
// Given an array of integers nums and an integer target , return indices of the two numbers such that they add up to the target.

// You may asssume that each input would have exactly one solution,  and you may not use the element twice. 
import java.util.HashMap;

public class TwoSum {
   public int[] sumIndices(int[] array, int target){
      HashMap<Integer, Integer> sumMap = new HashMap<>();
      for(int i=0; i<array.length; i++){
         int diff = target-array[i]; // You can name the diff as complement. In algorithms we use the name as complement.
         Integer pos = sumMap.get(diff);
         if(pos != null) {
            return new int[]{pos, i};
         }
         // Store the current value and its index for future complements
         sumMap.put(array[i], i);
      }
      return new int[]{-1, -1};

   }

   public static void main(String[] args) {

      int[] nums = {9, 7, 2, 11, 15};
      TwoSum obj = new TwoSum();
      int[] result = obj.sumIndices(nums, 9);
      if(result[0] == -1){
         System.out.println("No two sums.");
      } else {
         System.out.println(nums[result[0]] + " + " + nums[result[1]] + " = " + "9");
      }

   }
}

