/*
  
    Given two strings, determine if these are anagrams of each other. Two strings are
    anagrams of each other, if, and only if, they contain all the same characters the same
    amount of times.
    a. Examples: heart and earth, cars and scar, star and rats
    b. Additionally, the following test case MUST pass:
    i. “Tom Marvolo Riddle” -&gt; “I am Lord Voldemort”
  
 */
public class Anagrams {

    public static void main(String[] args) {
        Anagrams a = new Anagrams();
        System.out.println(a.isAnagram("heart", "earth"));
        System.out.println(a.isAnagram("cars", "scar"));
        System.out.println(a.isAnagram("star", "rats"));
        System.out.println(a.isAnagram("Tom Marvolo Riddle", "I am Lord Voldemort"));
    }

    public boolean isAnagram(String s1, String s2) {
        int[] chars = new int[58];
        s1 = s1.replaceAll("\\s", "").toLowerCase();
        s2 = s2.replaceAll("\\s", "").toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            chars[s1.charAt(i) - 65]++;
            chars[s2.charAt(i) - 65]--;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != 0) {
                return false;
            }
        }
        return true;
    }

}