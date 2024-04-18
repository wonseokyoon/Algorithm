#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;


int main() {
	int n;
	cin >> n;
	int x[100001], y[100001];
	vector<pair<int, int>>v;


	for (int i = 0; i < n; i++) {
		cin >> x[i];
		cin >> y[i];
		v.push_back({ x[i],y[i] });
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < n; i++) {
		cout << v[i].first<<" ";
		cout << v[i].second<<"\n";
	}

	
	return 0;
}