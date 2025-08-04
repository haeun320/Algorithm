#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int M, N;
	cin >> M >> N;

	vector<bool> sieve(N + 1, true);
	sieve[1] = false;

	int m = static_cast<int>(sqrt(N));

	for (int i = 2; i < m + 1; i++) {
		if (sieve[i] == true) {
			for (int j = i * i; j < N + 1; j += i) {
				sieve[j] = false;
			}
		}
	}

	for (int i = M; i < N + 1; i++) {
		if (sieve[i] == true)
			cout << i << '\n';
	}

	return 0;
}