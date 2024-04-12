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

	int main() {
		ios_base::sync_with_stdio(false);
		cin.tie(NULL);
		cout.tie(NULL);
		
		int t;
		cin >> t;
		int n;
		ll dp[101];

		for (int i = 0; i < t; i++) {
			cin >> n;
			dp[0] = 0;
			dp[1] = 1;
			dp[2] = 1;
			if (n <= 2) {
				cout << dp[n]<<"\n";
			}
			else {
				for (int j = 3; j <= n; j++) {
					dp[j] = dp[j - 3] + dp[j - 2];
				}
				cout << dp[n]<<"\n";
			}

		}


		return 0;
	}