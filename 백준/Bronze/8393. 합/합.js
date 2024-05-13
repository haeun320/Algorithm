const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
    rl.close();
}).on('close', function () {
    const n = Number(input[0]);
    let sum = n * (n+1) / 2
    console.log(sum);
});