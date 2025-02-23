import java.util.*;

public class print_longest_palindrome_subsequence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String br = a;
        String b = new StringBuilder(br).reverse().toString();
        System.out.println(b);
        int n = a.length();
        int m = b.length();
        int[][] dp = new int[n+1][m+1];

        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(a.charAt(i-1) == b.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        // for(int i=0; i<=n; i++){
        //     for(int j=0; j<=m; j++){
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        System.out.println(dp[n][m]);

        String ans = "";
        int i=n, j=m;

        while(i!=0 && j!=0) {
            if(a.charAt(i-1) == b.charAt(j-1)){
                ans += a.charAt(i-1);
                i--;
                j--;
            }
            else{
                if(dp[i-1][j] > dp[i][j-1]){
                    i--;
                }
                else{
                    j--;
                }
            }
        }

        String revans = new StringBuilder(ans).reverse().toString();
        System.out.println(revans);

        in.close();
    }
}
