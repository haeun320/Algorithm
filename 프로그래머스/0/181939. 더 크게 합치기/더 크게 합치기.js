function solution(a, b) {
    let r1 = a.toString() + b.toString();
    let r2 = b.toString() + a.toString();
    return r1 > r2 ? Number(r1) : Number(r2);
}