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
int N;

void cantor(int N) {
	int size = pow(3, N - 1);	// size:3^(N-1) -> 공백문자 반복용

	if (N == 0) {
		cout << "-";
		return;
	}

	cantor(N - 1);

	for (int i = 0; i < size; i++) {	//공백문자 나열
		cout << " ";
	}

	cantor(N - 1);

	return;



}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (cin >> N) {
		cantor(N);
		cout << "\n";
	}

	return 0;
}