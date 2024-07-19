import java.util.Scanner;
class dpString {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        
        int[] dp = new int[n];
        dp[0] = 1;
        
        int max = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= i - dp[i - 1]; j--) {
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i]++;
                } else {
                    break;
                }
            }
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
		System.out.println("Enter a string:");
		String str = in.next();
		System.out.println(lengthOfLongestSubstring(str));
    }
}
