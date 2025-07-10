#include <bits/stdc++.h>  
using namespace std;  

int main() {  
   ios::sync_with_stdio(0);  
   cin.tie(0);  

   int n, x, cnt = 0;  

   cin >> n;  

   vector<int> arr(n);

   for (int i = 0; i < n; i++) {  
       cin >> arr[i];  
   }  
   cin >> x;  
   
   sort(arr.begin(), arr.end());

   int p1 = 0;
   int p2 = n - 1;

   while (p2 > p1) {
       if (arr[p1] + arr[p2] > x)
           p2--;
       else if (arr[p1] + arr[p2] < x)
           p1++;
       else {
           p1++;
           cnt++;
       }
   }

   cout << cnt;

   return 0;  
}