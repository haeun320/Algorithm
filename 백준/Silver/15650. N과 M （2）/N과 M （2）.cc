#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10];
int isused[10];

void func(int digit) {
	if (digit == m) {
		for (int i = 0; i < m; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
		return;
	}

	for (int i = 1; i <= n; i++) {
		if (!isused[i]) {
			if (digit > 0 && arr[digit-1] > i)
				continue;
			arr[digit] = i;
			isused[i] = true;
			func(digit+1);
			isused[i] = false;
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> n >> m;
	func(0);
	return 0;
}