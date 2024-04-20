#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>

using namespace std;
long long int a[500001];
int num;
int answer[500001] = { 0, };

int binary_search(int start,int end,int find) {
	while (start <= end) {
		int mid = (start + end) / 2;

		if (find == a[mid]) {
			return 1;
		}
		else if (find < a[mid]) {
			end = mid - 1;
		}
		else if (find > a[mid]) {
			start = mid + 1;
		}
	}
	return 0;
	

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int n,m;
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	sort(a, a + n);

	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> num;
		cout<<binary_search(0,n-1,num)<<" ";
	}




	


	
	return 0;
}