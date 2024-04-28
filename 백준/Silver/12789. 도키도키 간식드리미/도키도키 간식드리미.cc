		#define _CRT_SECURE_NO_WARNINGS
		#include <stdio.h>
		#include<string>
		#include<iostream>
		#include<algorithm>
		#include<vector>
		#include<cmath>
		#include<stack>
		#include<queue>
		#define ull unsigned long long
		#define ll unsigned long long
		using namespace std;
	
	int main() {
		ios_base::sync_with_stdio(false);
		cin.tie(NULL);
		cout.tie(NULL);

		deque<int>deq;
		stack<int>st;

		int n,num;
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> num;
			deq.push_back(num);
		} // 5 4 1 3 2
		st.push(-1);
		deq.push_back(-1);

		int cnt = 1;
		int pcnt = 1;
		int res;
		while(1) {	
			if (deq.front() == -1 && st.top() != cnt) break;

			if (deq.front() == cnt) {	//덱에 cnt와 일치하는 값 존재
				deq.pop_front(); 	//덱에서 해당 값 삭제
				cnt++;
				pcnt++;
			}

			else if (st.top() == cnt) {	//스택에 cnt와 일치하는 값 존재
				st.pop();
				cnt++;
				pcnt++;
			}
			
			else if(deq.front()!=cnt &&st.top()!=cnt) {	//덱에도 스택에도 cnt와 일치하는 값이 존재 x
				res = deq.front();	//해당 값 저장
				st.push(res);	//스택에 쌓음
				deq.pop_front();	//덱에서 해당값 삭제
			}
		}
		//cnt=11
		if (cnt - 1 == n) {
			cout << "Nice";
		}
		else {
			cout << "Sad";
		}
		

		return 0;
	}