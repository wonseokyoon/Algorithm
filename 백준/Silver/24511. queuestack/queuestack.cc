#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
#include<cmath>
#include<stack>
#include<queue>
#include<deque>

#define ull unsigned long long
#define ll unsigned long long

using namespace std;


int A[100001];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	deque<int>deq;	//0
	
	int N;
	cin >> N;
	int a,b;
	for (int i = 0; i < N; i++) {
		cin >> A[i];
	}
	for (int i = 0; i < N; i++) {
		cin >> b;
		if (A[i] == 0) deq.push_back(b);
	}

	int M,c,res;
	cin >> M;
	for (int i = 0; i < M; i++) {
		cin >> c;
		deq.push_front(c);
		//res=deq.back();
		//deq.pop_back();
		//deq.push_front(res);
		cout << deq.back() << " ";
		deq.pop_back();
	}




	return 0;
}