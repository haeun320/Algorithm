#include <bits/stdc++.h>
using namespace std;

vector<vector<pair<int, int>>> graph;
vector<bool> visited;
long long dist[5001] = {0};

void dfs(int v) {
	visited[v] = true;

	for (auto& e : graph[v]) {
		int nv = e.first;
		int nw = e.second;

		if (!visited[nv]) {
			dist[nv] = dist[v] + nw;
			dfs(nv);
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	int n;
	cin >> n;

	graph.resize(n+1);
	visited.resize(n+1, false);

	for (int i = 0; i < n-1; i++) {
		int a, b, c;
		cin >> a >> b >> c;
		graph[a].push_back({b, c});
		graph[b].push_back({a, c});
	}

	dfs(1);
	cout << *max_element(dist + 1, dist + n + 1);

	return 0;
}