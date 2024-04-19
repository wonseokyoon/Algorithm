#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>

using namespace std;

int compare(string x,string y) {
	if (x.length() == y.length()) return x < y;
	else {
		return x.length() < y.length();
	}
}

int main() {
	int n;
	string str[20000];

	cin >> n;


	for (int i = 0; i < n; i++) {
		cin >> str[i];
	}

	sort(str, str + n, compare);

	for (int i = 0; i < n; i++) {
		if (str[i] == str[i - 1]) continue;
		cout<<str[i]<<"\n";
	}



	return 0;
}
