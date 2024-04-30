#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string.h>
#include<iostream>
#include<utility>
#include<algorithm>
#include<vector>
#include<cmath>
#include<stack>
#include<queue>
#include<deque>
#define ull unsigned long long
#define ll unsigned long long
using namespace std;

bool bal[1001] = { 0, };	//풍선이 터졌는지 안터졌는지 확인	0이면 안터진거 1이면 터진거
int M[1001];
deque<pair<int, int>> deq;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;	//풍선 속 숫자
		deq.push_back(make_pair(num, i + 1));
	}
	int cnt,pcnt;
	while (1) {
		cnt = deq.front().first;	//풍선속 숫자 =cnt
		pcnt = deq.front().second;	//풍선 번호
		cout << pcnt << " ";	// 풍선번호 출력
		deq.pop_front();	//풍선 터트리기
		if (deq.empty()) break; //풍선을 다 터뜨렸으면 중지

		if (cnt > 0) {
			for (int i = 0; i < cnt - 1; i++) {
				deq.push_back(deq.front());
				deq.pop_front();
			}
		}
		else {
			for (int i = 0; i < -cnt; i++) {
				deq.push_front(deq.back());
				deq.pop_back();
			}
		}




	}

	
	

	
	return 0;
}