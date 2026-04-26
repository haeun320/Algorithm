class Solution {
    int[] num;
    int len;
    int cnt = 0;
    int target;
    
    public int solution(int[] numbers, int target) {
        this.num = numbers;
        this.len = num.length;
        this.target = target;
        
        perm(0, 0);
        return cnt;
    }
    
    public void perm(int idx, int sum) {
        if (idx == len) {
            if (sum == target) {
                cnt++;
            }
            
            return;
        }
        
        perm(idx+1, sum + num[idx]);
        perm(idx+1, sum - num[idx]);
    }
}