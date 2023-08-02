let num1 = 10; 
let num2 = 10.2;
let msg = "hi";
let bool = true; 
let nullVal = null; 
let unVal; 
let obj = {}; 
let obj2 = new Object(); 
let symbol = Symbol();

console.log(num1);
console.log(num2);
console.log(msg);
console.log(bool);
console.log(nullVal);
console.log(unVal);
console.log(obj);
console.log(obj2);
console.log(symbol);

console.log('-----------------')

let a = "haha";
console.log(typeof a); // string
a = 123;
console.log(typeof a); // number
a = false;
console.log(typeof a); // boolean
a = {
  a: 123,
};
console.log(typeof a); // object
a = [1, 2, 3, 4];
console.log(typeof a); // object
a = null;
console.log(typeof a); // object
a = undefined;
console.log(typeof a); // undefined
