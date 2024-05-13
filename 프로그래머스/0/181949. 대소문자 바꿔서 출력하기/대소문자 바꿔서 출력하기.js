const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    const arr = [...str]
    for (let i = 0; i < str.length; i++){
        ch = arr[i]
        if (ch >= 'A' && ch <= 'Z'){
            arr[i] = ch.toLowerCase();
        }
        else {                                      
            arr[i] = ch.toUpperCase();
        }
    }
    console.log(arr.join(''));
});