#include <iostream>
using namespace std;

int n;
long long d[116];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cin >> n;

	for (int i = 0; i < 3; i++)
		d[i] = 1;
	
	for (int i = 3; i < n; i++)
		d[i] = d[i-1] + d[i-3];

	cout << d[n-1];

	return 0;
}