function pow(num) {
  return Math.pow(num, 3);
}
console.log("2의 세제곱 : " + pow(2));

const arrowPow = (num) => {
  return Math.pow(num, 3);
};
console.log("2의 세제곱 화살표함수 : " + arrowPow(2));