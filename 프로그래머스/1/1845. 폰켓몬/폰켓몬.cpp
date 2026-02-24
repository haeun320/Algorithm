#include <bits/stdc++.h>
using namespace std;

int solution(vector<int> nums)
{
    set<int> s(nums.begin(), nums.end());
    return min(nums.size()/2, s.size());
}