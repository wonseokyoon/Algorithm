#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include<string>
#include<iostream>
#include<algorithm>


using namespace std;


int main() {

	int n;
	cin >> n;
	string str;
	int cnt = 0;

	for (int i = 0; i < n; i++) {
		cin >> str;

		int ary[26] = { 0, };
		ary[str[0] - 'a'] = 1;

		for (int j = 1; j < str.length(); j++) {
			if (str[j] == str[j - 1]) continue;
			else if (str[j] != str[j - 1] && ary[str[j] - 'a'] == 1) { //재등장
				cnt++;
				break;
			}
			else{ //새로운 단어 
				ary[str[j] - 'a'] = 1;
			}
		}
	}
	cout << n-cnt;


	return 0;
}
