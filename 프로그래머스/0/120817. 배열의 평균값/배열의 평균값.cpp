#include <string>
#include <vector>

using namespace std;

double solution(vector<int> numbers) {
    double sum = 0, cnt = 0;
    for (auto& x: numbers){
        sum += x;
        cnt++;
    }
    return sum / cnt;
}