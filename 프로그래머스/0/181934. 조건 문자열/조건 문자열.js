function solution(ineq, eq, n, m) {
    if (ineq == "<"){
        if (eq == "=")
            return Number(n <= m);
        else 
            return Number(n < m);
    }
    else {
        if (eq == "=")
            return Number(n >= m);
        else 
            return Number(n > m);
    }
}