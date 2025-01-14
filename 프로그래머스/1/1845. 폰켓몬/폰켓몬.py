def solution(nums):
    types = len(set(nums))
    half = len(nums)//2
    
    return types if (types < half) else half