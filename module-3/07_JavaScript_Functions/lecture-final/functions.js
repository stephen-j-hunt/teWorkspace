
function add(a, b) {
    return a + b;
}

// there is not function overloading in javascript
function add(a, b, c = 0, d = 0) {
    return a + b + c + d;
}

function countEven() {
    const args = Array.from(arguments);
    let count = 0;
    for (const v of args) {
        if (v % 2 === 0) count++;
    }
    return count;
}

function countEven2(...args) {
    let count = 0;
    for (const v of args) {
        if (v % 2 === 0) count++;
    }
    return count;
}

console.log(add(1, 2));
console.log(countEven(1, 2, 3, 4, 5, 6, 7, 8, 9));
console.log(countEven2(1, 2, 3, 4, 5, 6, 7, 8, 9));



