	#define _CRT_SECURE_NO_WARNINGS
	#include <stdio.h>
	#include<string>
	#include<iostream>
	#include<algorithm>
	#include<vector>

	using namespace std;
	
	int n, m,cnt;
	int arr[100];
	void search(int x,int y) {
		if (y == m) {
			for (int i = 0; i < m; i++) {
				cout << arr[i]<<" ";
			}
			cout << "\n";
			return;
		}
		for (int i = x; i <= n	; i++) {
			arr[y] = i;
			search(i + 1, y + 1);
		}

	
	}

	int main() {
		ios::sync_with_stdio(false);
		cin.tie(0);
		cout.tie(0);

		
		cin >> n >> m;

		search(1,0);

		return 0;
	}