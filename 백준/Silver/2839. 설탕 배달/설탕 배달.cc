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

		int n;
		cin >> n;
		int cnt = 0; //가방의 갯수
		while (n>0) {
			if (n % 5 == 0) { // 5로 나눠질때
				cnt = cnt + n / 5;
				cout << cnt;
				return 0;
			}
			else {
				n -= 3;
				cnt++;
			}
		}
	
		if (n != 0) cout << "-1";
		else cout << cnt;
				


		return 0;
	}