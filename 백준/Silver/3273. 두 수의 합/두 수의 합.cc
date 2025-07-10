#include <bits/stdc++.h>  
using namespace std;  

int main() {  
   ios::sync_with_stdio(0);  
   cin.tie(0);  

   int n, arr[100001], x, cnt = 0;

   cin >> n;  

   for (int i = 0; i < n; i++) {  
       cin >> arr[i];  
   }  
   cin >> x;  

   sort(arr, arr + n);
   
   int p1 = 0;
   int p2 = n - 1;

   while (p2 > p1) {
       if (arr[p1] + arr[p2] > x)
           p2--;
       else if (arr[p1] + arr[p2] < x)
           p1++;
       else {
           p1++;
           p2--;
           cnt++;
       }
   }

   cout << cnt;

   return 0;  
}