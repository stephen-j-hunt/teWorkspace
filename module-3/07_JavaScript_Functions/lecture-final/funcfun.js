
function add(a, b) {
    return a + b;
}

const add2 = function (a, b) {
    return a + b;
}

// "fat arrow" function
// "given a & b, execute the code block"
const add3 = (a, b) => {
    return a + b;
}

const add4 = (a, b) => a + b;

console.log(add(1, 2));
console.log(add2(2, 3));
console.log(typeof (add2));
console.log(add3(3, 4));
console.log(typeof (add3));
console.log(add4(3, 4));
console.log(typeof (add4));

const obj = {
    add5: function (a, b) { return a + b },
    add6: (a, b) => a + b,
    add7(a, b) { return a + b }
};

console.log(obj.add5(3, 4));
console.log(obj.add6(4, 5));
console.log(obj.add6(5, 6));

// function that returns a function
function makeAddr(a) {
    return (x) => x + a;
}

const incrementBy10 = makeAddr(10);
console.log(incrementBy10(12));
console.log(makeAddr(10)(3)); // a = 10; x = 3;

// function that accepts a function as an argument
function acceptFn(fn) {
    return fn(5, 5);
}

console.log(acceptFn(add));
console.log(acceptFn((a, b) => a * b));




