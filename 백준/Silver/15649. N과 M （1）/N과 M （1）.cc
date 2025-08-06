#include <bits/stdc++.h>
using namespace std;

int n, m;
int arr[10];
bool isused[10];

void func(int digit) {
	if (digit == m) { // m개 모두 고름
		for (int i = 0; i < m; i++) {
			cout << arr[i] << ' ';
		}
		cout << '\n';
		return;
	}

	for (int i = 1; i <= n; i++) { // 1부터 n까지의 수에 대해
		if (!isused[i]) { // 아직 i가 사용되지 않은 수라면
			arr[digit] = i; // 현재 자리를 i로 채움
			isused[i] = true;
			func(digit+1); // 다음 자리수를 정함
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