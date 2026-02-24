#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    answer.reserve(commands.size());
    
    for(const auto& cmd : commands){
        vector<int> tmp(array.begin() + cmd[0] - 1, array.begin() + cmd[1]);
        nth_element(tmp.begin(), tmp.begin() + cmd[2] - 1, tmp.end());
        answer.push_back(tmp[cmd[2] - 1]);
    }
    
    return answer;
}