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

	long long dp[501][501];
	long long res[501];
	int main() {
		ios_base::sync_with_stdio(false);
		cin.tie(NULL);
		cout.tie(NULL);
		int n,t;
		cin >> n;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				cin >> t;
				dp[i][j] = t;
			}
		}

		for (int i = n; i >= 1; i--) {
			for (int j = 0; j < n; j++) {
				dp[i-1][j] += max(dp[i][j], dp[i][j + 1]);
			}
		}

		cout << dp[1][1];

		return 0;
	}