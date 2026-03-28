// Given 2 strings s and t, return true if t is an anagram of s, and false otherwise.


public class Anagram {
   public boolean checkAnagram(String s, String t){
      if(s.length() != t.length()) return false;
      
      int[] freqArray = new int[26];
      for(int i=0; i<s.length(); i++){
         freqArray[s.charAt(i) - 'a']++;
         freqArray[t.charAt(i) - 'a']--;
      }

      for(int i: freqArray) {
         if(i != 0) return false;
      }

      return true;
   }

   public static void main(String[] args) {
      String a = "hello";
      String b = "elloh";
      Anagram anagram = new Anagram();
      boolean result = anagram.checkAnagram(a, b);
      if(result){
         System.out.println("It's an anagram");
      } else {
         System.out.println("It's not an anagram");
      } 
   }
}
