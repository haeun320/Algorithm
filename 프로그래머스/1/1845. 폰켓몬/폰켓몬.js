function solution(nums) {
    const set = new Set(nums);
    const n = Math.floor(nums.length / 2);
    return set.size <= n ? set.size : n;
}