	#define _CRT_SECURE_NO_WARNINGS
	#include <stdio.h>
	#include<string>
	#include<iostream>
	#include<algorithm>
	#include<vector>
    #include<cmath>

	using namespace std;

	
	int search(int x) {
		int cnt = 0;
		int pcnt = 0;
        int r;
		if (x == 1) {
			pcnt = 1;
		}
		else {
			for (int i = x + 1; i <= 2 * x; i++) {
				r = sqrt(i);
				for (int j = 2; j <= r; j++) {
					if (i % j == 0) { //소수x
						cnt++;
						break;
					}
				}
				if (cnt == 0) { //소수
					pcnt++;
				}
				cnt = 0;
			}
		}
	return pcnt;

}



int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);
	
	int n=1;

	while (1) {
		cin >> n;
		if (n == 0) break;
		cout<<search(n);
		cout << "\n";
	}

	return 0;
}