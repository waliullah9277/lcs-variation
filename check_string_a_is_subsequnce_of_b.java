import java.util.*;

public class check_string_a_is_subsequnce_of_b {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();

        // normal approach
        // int x = 0;
        // boolean found = false;
        // for(char ch: b.toCharArray()){
        //     if(ch == a.charAt(x)){
        //         x++;
        //     }
        //     if(x == a.length()){
        //         found = true;
        //         break;
        //     }
        // }
        // if(found)System.out.println("YES");
        // else System.out.println("NO");

        // lcs approach
        int n = a.length();
        int m = b.length();

        int[][] dp = new int[n+1][m+1];

        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        if(dp[n][m] == a.length()) System.out.println("YES");
        else System.out.println("NO");



        in.close();
    }
}
