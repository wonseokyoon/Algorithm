	#define _CRT_SECURE_NO_WARNINGS
	#include <stdio.h>
	#include<string>
	#include<iostream>
	#include<algorithm>
	#include<vector>
	#include<cmath>
	#define ull unsigned long long
	#define ll unsigned long long
	using namespace std;

	ll n;
	ll dp[1000001];
	ll ans;
	ll dpp(int n) {
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2])%15746;
		}
		
		return dp[n];
	}

	int main() {
		ios_base::sync_with_stdio(false);
		cin.tie(NULL);
		cout.tie(NULL);
		
		cin >> n;
		cout<<dpp(n);



		return 0;
	}