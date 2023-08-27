import java.util.Arrays;

public class test {
    public static int countSubstrings(String s) {
        // 动态规划
        char[] chars = s.toCharArray();
        int len = chars.length;

        // 定义dp数组, i ~ j 是否为回文串
        boolean[][] dp = new boolean[len][len];
        int res = 0;

        // dp[i][j] 需要判断 dp[i+1][j-1]
        // 所以数组矩阵需要从下往上遍历，从左到右遍历
        for(int i = len - 1; i >= 0; i--) {
            for(int j = i; j < len; j++) {
                if(chars[i] == chars[j]) {
                    if(j - i <= 1) {
                        res++;
                        dp[i][j] = true;
                    }else if(dp[i+1][j-1]) {
                        res++;
                        dp[i][j] = true;
                    }                       
                }
                System.out.println(i+","+j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcab";
        System.out.println(countSubstrings(s));
    }
}

