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

	//nCm=n-1Cm-1 + n-1Cm
	int n, m;
	ll dp[31][31];
	
	void dpp() {	//dp[i][j] = iCj
		for (int i = 1; i < 31; i++) {
			dp[0][i] = 1;
			dp[i][0] = 1;
			dp[i][i] = 1;
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}

		}
	}
	
	int main() {
		ios_base::sync_with_stdio(false);
		cin.tie(NULL);
		cout.tie(NULL);
		
		int T;
		cin >> T; 
			for (int i = 0; i < T; i++) {
				cin >> n >> m;	//n<m;
				dpp();
				cout << dp[m][n] <<"\n";
		}
		


		return 0;
	}