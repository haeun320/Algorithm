#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	vector<int> a(9);
	for (int i = 0; i < 9; i++) {
		cin >> a[i];
	}

	int sum = accumulate(a.begin(), a.end(), 0);
	int target = sum - 100;

	for (int i = 0; i < 8; i++) {
		for (int j = i + 1; j < 9; j++) {
			if (a[i] + a[j] == target) {
				a.erase(a.begin() + max(i, j));
				a.erase(a.begin() + min(i, j));

				sort(a.begin(), a.end());
				for (auto& x : a) cout << x << '\n';
				return 0;
			}
		}
	}

	return 0;
}
