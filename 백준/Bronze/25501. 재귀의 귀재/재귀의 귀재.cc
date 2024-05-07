#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
#include<string.h>
#define ull unsigned long long

using namespace std;

int cnt;


int count() {
	cnt++;
	return cnt;
}

int recursion(const char* s, int l, int r) {
	if (l >= r) return 1;
	else if (s[l] != s[r]) return 0;
	else {
		count();
		return recursion(s, l + 1, r - 1);
	}
}

int isPalindrome(const char* s) {
	return recursion(s, 0, strlen(s) - 1);
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int T;
	char S[1001];


	cin >> T;
	for (int i = 0; i < T; i++) {
		cnt = 0;
		cin >> S;
		cout << isPalindrome(S)<<" ";
		cout << count() <<"\n";
	}


	return 0;
}