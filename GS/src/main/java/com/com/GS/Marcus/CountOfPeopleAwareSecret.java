package com.GS.Marcus;

public class CountOfPeopleAwareSecret {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 4;
		int delay = 1;
		int forget = 3;
		System.out.println("count = " + peopleAwareOfSecret(n, delay, forget));
	}
	
	public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long dp[] = new long[n + 1], mod = (long)1e9 + 7, share = 0, res = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i)
            dp[i] = share = (share + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)] + mod) % mod;
        for (int i = n - forget + 1; i <= n; ++i)
            res = (res + dp[i]) % mod;
        return (int)res;
    }

}
