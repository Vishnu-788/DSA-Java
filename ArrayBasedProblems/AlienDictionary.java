// In an alien language, surprisingly, they also use English lowercase letters, but possibly in a
// different order.
// The order of the alphabet is some permutation of lower case letters.

// Given an sequence of words written in the alien language, and the order of the alphabet, return
// true if and only if the given words are sorted lexicographically in this alien language.
import java.util.HashMap;

public class AlienDictionary {
  public boolean solution(String order, String[] words) {
    HashMap<Character, Integer> orderMap = new HashMap<>();
    char[] charArray = order.toCharArray();

    for (int i = 0; i < charArray.length; i++) {
      orderMap.put(charArray[i], i);
    }

    for (int i = 0; i < words.length - 1; i++) {
      String word1 = words[i];
      String word2 = words[i + 1];

      for (int j = 0; j < word1.length(); j++) {
        int posValue1 = orderMap.get(word1.charAt(j));
        int posValue2 = orderMap.get(word2.charAt(j));

        if (posValue1 > posValue2) return false;
        if (posValue1 < posValue2) break;
      }
    }
    return true;
  }

  public static void main(String[] args) {}
}
