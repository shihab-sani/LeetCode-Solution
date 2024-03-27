import java.util.HashSet;

class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length = 0;
        int left = 0;
        char chr;
        HashSet<Character> sets = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            chr = s.charAt(right);
            while (sets.contains(chr)) {
                sets.remove(s.charAt(left));
                left++;
            }
            sets.add(chr);
            length = Math.max(length,right-left+1);
        }
        return length;
    }
}