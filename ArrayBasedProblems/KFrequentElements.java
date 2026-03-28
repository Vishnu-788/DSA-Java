// Given an Integer array nums and an interger k, return the k most frequesnt elements. You may return in any order
import java.util.PriorityQueue;
import java.util.HashMap;

public class KFrequentElements {
   public int[] solution(int[] nums, int k) {
      
      HashMap<Integer, Integer> occuranceMap = new HashMap<>();

      for(int i: nums) {
         occuranceMap.put(i, occuranceMap.getOrDefault(i, 0) + 1);         
      }

      PriorityQueue<Integer> minHeap = new PriorityQueue<>(
         (a, b) -> occuranceMap.get(a) - occuranceMap.get(b) 
      );

      for(int n: occuranceMap.keySet()) {
         minHeap.add(n);

         if(minHeap.size() > k) {
            minHeap.poll();
         }
      }

      int[] result = new int[k];
      for(int i=0; i<k; i++) {
         result[i] = minHeap.poll(); 
      }

      return result;
   }

   public static void main(String[] args) {
      int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 4, 4};

      KFrequentElements obj = new KFrequentElements();
      int[] result = obj.solution(nums, 3);

      for(int n: result) {
         System.out.print(n);
      }
   }
}
