// Given an integer arrays nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i]


public class ProductOfArray {
   public int[] solution(int[] arr){
      int prefix=1;
      int postfix=1;

      int[] solutionArray = new int[arr.length];

      for(int i=0; i<arr.length; i++) {
         if(i==0){
            solutionArray[0] = 1;
            continue; 
         }

         int product = prefix * arr[i-1];
         solutionArray[i] = product;
         prefix = product;
      }

      for(int i=arr.length-1; i>=0; i--) {
         if(i == arr.length-1) {
            solutionArray[i] *= postfix;
            continue;
         }

         int product = postfix * arr[i+1];
         solutionArray[i] *= product;
         postfix = product;
      }
      return solutionArray;
   }

   public static void main(String[] args){
      int[] arr = {1, 2, 3, 4};

      ProductOfArray sol = new ProductOfArray();
      int[] solutionArray = sol.solution(arr);
      for(int i: solutionArray){
         System.out.print(i + " ");
      }
   }
}

