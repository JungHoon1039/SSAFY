import { title, add, sub } from "./08_module1.js";
import calc from "./08_module2.js";

console.log(title);

document.querySelector("#calc").addEventListener("click", () => {
  let num1 = +document.querySelector("#num1").value;
  let num2 = +document.querySelector("#num2").value;

  //모듈1
  console.log(add(num1, num2));
  console.log(sub(num1, num2));

  //모듈2
  console.log(calc.add(num1, num2));
  console.log(calc.sub(num1, num2));
});
