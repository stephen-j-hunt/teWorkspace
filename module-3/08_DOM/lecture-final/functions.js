

function add(a, b) {
    return a + b;
}

function acceptFn(callback) {
    return callback(5, 5);
}

const addvar = add;


console.log(typeof (add));
console.log(typeof (addvar));
console.log(acceptFn(add));
console.log(acceptFn((a, b) => a * b));