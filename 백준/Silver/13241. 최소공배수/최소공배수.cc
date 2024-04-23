#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>

using namespace std;


int main() {
	long long int a,b;
	cin >> a >> b;
	long long int min=b;
	if (a < b) min = a;

	long long int m;
	long long int cnt=1;
	while (cnt <= min) {
		if (a % cnt == 0 && b % cnt == 0) {
			m = cnt;
		}
		cnt++;
	}
	long long int M = a * b / m;

	cout << M;


	

	return 0;
}
