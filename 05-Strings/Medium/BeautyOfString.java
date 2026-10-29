public class BeautyOfString {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }
    static int beautySum(String s) {

        int n = s.length();
        int totalBeauty = 0; 

        for (int i = 0; i < n; i++) {

             int[] freq = new int[26]; 

             for (int j = i; j < n; j++) { 

                freq[s.charAt(j) - 'a']++; 

                int minFreq = Integer.MAX_VALUE; 
                int maxFreq = Integer.MIN_VALUE; 
                
                for (int k = 0; k < 26; k++) { 

                    if (freq[k] > 0) {
                        minFreq = Math.min(minFreq, freq[k]); 
                        maxFreq = Math.max(maxFreq, freq[k]); 
                    } 
                } 
                totalBeauty += maxFreq - minFreq;
                } 
        } 
        return totalBeauty; 
    }
}
