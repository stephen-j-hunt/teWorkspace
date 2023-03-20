/*
    Example of a multi-line comment just like in C#/Java
*/

// Single line comment

console.log("hello world, again");

/**
 * Functions start with the word function.
 * They don't have a return type and the naming convention is camel-case.
 */
function variables() {
  const aConstant = 1;
  let s = 'hello';
  s = 'world';
  console.log(s);
  console.log(typeof (s));
  s = 3.14;
  console.log(s);
  console.log(typeof (s));
  s = null;
  console.log(typeof (s));


  // arrays
  let a = [1, 2, "A", "B"];
  console.log(a);
  console.table(a);

  // objects
  const me = {};
  console.log(me);
  me.name = "mike";
  console.log(me);
  console.log(me.name);
  console.log(me['name']);

  const t = true;
  const f = false;

}


function doingMath() {
  console.log(2 + 2);
  console.log(2 * 2);
  console.log("hello " + "world");
  console.log("4" + 2);
  console.log("4" + true);
  console.log("10" - 2);
  console.log("10" * 2);

  console.log(parseInt("3.14"));
  console.log(parseFloat('3.14'));
  console.log(parseInt('mike'));
}

function stringFormatting() {
  const lat = 23.3;
  const long = 78.6;
  console.log(`lat ${lat}, long ${long}`);
}

function equality() {
  console.log(1 == 1);
  console.log(1 == 2);
  console.log(1 != 2);
  console.log("A" == "A");
  console.log("1" == 1);
  console.log("1" === 1);
  console.log("1" !== 1);

  isTrue(true);
  isTrue(false);
  isTrue(2);
  isTrue(0); // falsey
  isTrue("");
  isTrue(null);
  isTrue(undefined);
  isTrue(-0);
  isTrue(NaN);

  let x = null
  if (x && x.value === 4) {
    console.log("bad stuff");
  }

  console.log(NaN == NaN);
  console.log(Number.isNaN(NaN));

  console.log(!"");

}

function isTrue(x) {
  if (x) {
    console.log("true");
  } else {
    console.log("false");
  }
}


function objects() {
  const me = {
    first: 'mike'
  };
  console.log(me);
  console.log(typeof (me));
  me.last = 'smith';
  console.log(me);
  delete me.last;
  console.log(me);
  me['last'] = 'smith';
  console.log(me);

  me.address = {
    street: '1776 Mentor Ave',
    city: 'cincinnati'
  };

  console.log(me);
  if (me.age) {
    console.log('age exists');
  }

}

function someMathFunctions() {
  console.log(Math.abs(-2));
  console.log(Math.ceil(2.34));
  console.log(Math.floor(2.34));
  console.log(Math.max(3, 6, 4));
  console.log(Math.min(3, 6, 4));

  console.log(Math.sign(3));
  console.log(Math.sign(-3));
  console.log(Math.sign(0));


}

function someStringFunctions() {
  console.log("hello world".length);
  console.log("hello".charAt(0));
  console.log("hello".includes('he'));
  console.log("hello".endsWith('o'));
  console.log("hello".substring(1, 3));
  console.log('     hello     '.trim());

}

function workingWithArrays() {

  const arr = [1, 2];
  console.log(arr);
  console.log(arr.length);

  // push() & pop() the end of the array
  arr.push(3);
  console.log(arr);
  console.log(arr.pop());
  console.log(arr);

  // unshift() & shift() the beginning of the array
  arr.unshift(-1);
  console.log(arr);
  console.log(arr.shift());
  console.log(arr);



}

