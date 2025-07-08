#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	string s;
	getline(cin, s);

	int result[26] = { 0 };

	for (int i = 0; i < s.length(); i++) {
        int idx = s[i] - 'a';  
		result[idx]++;
	}

	for (int i = 0; i < 26; i++)
		cout << result[i] << " ";

	return 0;
}