#include <bits/stdc++.h>
using namespace std;

#define DEBUG 0

#if DEBUG
#define debug_2d(arr, r, c) do { cout << #arr << ":\n"; for(int i=0; i<r; i++) { for(int j=0; j<c; j++) cout << arr[i][j] << " "; cout << "\n"; } } while(0)
#define debug_que(q) do { cout << #q << " (size=" << q.size() << "): "; queue<pair<int, int>> temp = q; while(!temp.empty()) { auto [x, y] = temp.front(); temp.pop(); cout << "(" << x << "," << y << ") "; } cout << endl; } while(0)
#else
#define debug_2d
#define debug_que
#endif

// 전역 변수 선언
int N;
int area[101][101];
int visited[101][101];

int bfs(int x, int y, int rain) {
	if (visited[y][x] || area[y][x] <= rain) return 0;

	queue<pair<int, int>> q; // 큐 선언
	q.push({x, y});
	debug_que(q);

	visited[y][x] = true;

	int dy[] = {-1, 1, 0, 0};
	int dx[] = {0, 0, -1, 1};

	while (!q.empty()) {
		debug_que(q);
		auto [vx, vy] = q.front(); q.pop();

		for (int i = 0; i < 4; i++) {
			int nx = vx + dx[i];
			int ny = vy + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			
			if (!visited[ny][nx]) {
				visited[ny][nx] = true;

				if (area[ny][nx] > rain)
					q.push({nx, ny});
			}
		}
	}

	return 1;
}

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	cin >> N;

	// 전체 높이 정보 입력
	for (int i = 0; i < N; i++) {
		for (int j = 0; j < N; j++) {
			cin >> area[i][j];
		}
	}
	
	int result = 0;

	for (int rain = 0; rain < 101; rain++) {
		memset(visited, false, sizeof(visited)); // visited를 false로 초기화
		debug_2d(visited, N, N);

		int c = 0;

		for (int y = 0; y < N; y++) {
			for (int x = 0; x < N; x++) {
				c += bfs(x, y, rain);
			}
		}

		if (c == 0)
			break;

		result = max(result, c);
	}

	cout << result;

	return 0;
}