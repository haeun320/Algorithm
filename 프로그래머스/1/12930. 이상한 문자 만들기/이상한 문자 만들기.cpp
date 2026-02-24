#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i++){
        if (s[i] == ' ') {
            cnt = 0;
            continue;
        }
        
        s[i] = (cnt ^= 1) ? toupper(s[i]) : tolower(s[i]);
    }
    return s;
}