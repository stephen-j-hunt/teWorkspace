
function incrementArray(arr, inc = 1) {
    const result = [];
    for (const v of arr) {
        result.push(v + inc);
    }
    return result;
}

function decrementArray(arr) {
    const result = [];
    for (const v of arr) {
        result.push(v - 1);
    }
    return result;
}

function doubleArray(arr) {
    const result = [];
    for (const v of arr) {
        result.push(v * 2);
    }
    return result;
}

function transformArray(arr, fn) {
    const result = [];
    for (const v of arr) {
        result.push(fn(v));
    }
    return result;
}


const nums = [1, 2, 3, 4, 5, 6, 7, 8, 9];
console.log(incrementArray(nums));
console.log(decrementArray(nums));
console.log(incrementArray(nums, -1));
console.log(doubleArray(nums));
console.log(transformArray(nums, x => x + 1));
console.log(transformArray(nums, x => x * 2));

const result = nums.map(x => x * 3);
console.log(result);

nums.forEach(x => {
    console.log(`value is ${x}`);
})

console.log(nums.filter(x => x % 2 === 0));
console.log(nums.filter(x => x % 2 === 1));
console.log(nums.find(x => x % 2 === 0));
console.log(nums.findIndex(x => x % 2 === 0));
console.log(nums.join("|"));
console.log(nums.some(x => x > 7));

function every(arr, fn) {
    for (const v of arr) {
        if (!fn(v)) return false;
    }
    return true;
}

console.log(nums.every(x => x > 7));

// sum all the values in an array 
function sumArray(arr) {
    let acc = 0;
    for (const v of arr) {
        acc += v;
    }
    return acc;
}

const sum = nums.reduce((acc, v) => acc += v, 0);
console.log(sum);

const words = ['fe', 'fi', 'fo', 'fum'];
const count = words.reduce((acc, word) => acc += word.length, 0);
console.log(count);

// title case this name: 
const names = ["mickey", "theo", "mouse"]; // ==> "Mickey Theo Mouse"
const fullname = names.reduce((acc, word) =>
    acc += word.substring(0, 1).toUpperCase() + word.substring(1) + ' '
    , '');

console.log(fullname.trim());



