function solution(a, b) {
    let r1 = Number(a.toString() + b.toString());
    let r2 = 2 * a * b;
    return Math.max(r1, r2);
}