// Given an array of strings, group the anagrams together. You can return the answer in any order.
// An anagram is word ...


import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;


public class AnagramGroup {
   public List<List<String>> solution(String[] stringsArray) {
      
      HashMap<String, List<String>> freqStringMap = new HashMap<>();
      
      int[] freqArray = new int[26];
      for(String text: stringsArray){
         
         Arrays.fill(freqArray, 0);
         for(int i=0; i<text.length(); i++){
            freqArray[text.charAt(i) - 'a']++;
         }
         
         String freqText = "";
         for(int i=0; i<freqArray.length; i++){
            freqText += freqArray[i];
         }
         
         freqStringMap.computeIfAbsent(freqText, v -> new ArrayList<String>()).add(text); 
      }

      List<List<String>> result = new ArrayList<>();
      for(String key: freqStringMap.keySet()){
         result.add(freqStringMap.get(key));    
      }
      return result;

   }

   public static void main(String[] args){
     String[] stringsArray = new String[]{"eat", "tea", "tan", "ate", "not", "bat"};

     AnagramGroup obj = new AnagramGroup();
     List<List<String>> anagramList = obj.solution(stringsArray);
     System.out.println(anagramList);
   }
}
