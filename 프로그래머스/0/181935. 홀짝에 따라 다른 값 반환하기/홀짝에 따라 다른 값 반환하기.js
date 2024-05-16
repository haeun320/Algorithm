function solution(n) {
    if (n % 2) {
        return ((n+1)/2)**2;
    }
    else {
        let k = n/2;
        return 2*k * (k+1) * (2*k+1)/3;
    }
}