class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int count = 0;
		int length = 0;
        int left = 0;
        int[] arr = new int[26];

        for (int right = 0; right < s.length(); right++) {
            arr[s.charAt(right) - 'A']++;
            count = Math.max(count,arr[s.charAt(right) - 'A']);
            if ((right - left + 1 - count) > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            length = Math.max(length,right-left+1);
        }
        return length;
    }
}