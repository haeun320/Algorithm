#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll func(ll a, ll b, ll c) {
	if (b == 1) return a % c;

	if (b % 2 == 1) {
		ll v = func(a, (b-1)/2, c);
		return ((v * v) % c) * a % c;
	}

	ll v = func(a, b/2, c);
	return v * v % c;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	ll a, b, c;
	cin >> a >> b >> c;

	cout << func(a, b, c);
	return 0;
}