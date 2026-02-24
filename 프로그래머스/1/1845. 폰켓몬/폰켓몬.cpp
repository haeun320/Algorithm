#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    set<int> s;
    for (const auto& n: nums){
        s.insert(n);
    }
    
    return min(nums.size()/2, s.size());
}