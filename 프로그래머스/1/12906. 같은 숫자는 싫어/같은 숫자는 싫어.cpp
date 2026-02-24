#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;
    answer.reserve(arr.size());

    for (int num: arr){
        if (answer.empty() || answer.back() != num){
            answer.push_back(num);
        }
    }

    return answer;
}