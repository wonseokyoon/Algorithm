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

	int N;
	ll dp[10001][3];	//dp[n번째 집][색깔(빨파초)]


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> N;
	for (int i = 1; i <= N; i++) {
		cin >> dp[i][0] >> dp[i][1] >> dp[i][2];
	}

	for (int i = 2; i <= N; i++) {
		dp[i][0] += min(dp[i - 1][1], dp[i - 1][2]);
		dp[i][1] += min(dp[i - 1][0], dp[i - 1][2]);
		dp[i][2] += min(dp[i - 1][0], dp[i - 1][1]);
	}
	int ans1, ans2, ans3;
	ans1 = min(dp[N][0], dp[N][1]); //빨파중 작은거
	ans2 = min(dp[N][1], dp[N][2]); //파초중 작은거
	ans3 = min(ans1, ans2);
	

	cout << ans3;

	return 0;
}