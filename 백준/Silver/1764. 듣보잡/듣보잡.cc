#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	int n, m;
	cin >> n >> m;
	vector<string>str(n + m +1);
	vector<string>ans;

	for (int i = 0; i < n+m; i++) {
		cin >> str[i];
	}

	sort(str.begin(), str.end());
	int cnt = 0;

	for (int i = 0; i < n + m; i++) {
		if (str[i] == str[i + 1]) {
			ans.push_back(str[i]);
			cnt++;
		}
	}

	cout << cnt<<"\n";

	for (int i = 0; i < cnt; i++) {
		cout << ans[i]<<"\n";
	}
	



	return 0;
}