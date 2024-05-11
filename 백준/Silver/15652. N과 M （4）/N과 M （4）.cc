#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
#include<string.h>
#define ull unsigned long long
#define ll long long

using namespace std;
int N,M;
int arr[9] = { 0, };
bool ox[9] = { 0, };	//방문한건 1 , 방문 안한건 0

void seq(int n,int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			cout << arr[i] << " ";
		}
		cout << "\n";
		return;
	}

	
	for (int i = n; i <= N; i++) {
			arr[cnt] = i;
			seq(i,cnt + 1);
	}


}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N >> M;

	seq(1,0);
	

	return 0;
}