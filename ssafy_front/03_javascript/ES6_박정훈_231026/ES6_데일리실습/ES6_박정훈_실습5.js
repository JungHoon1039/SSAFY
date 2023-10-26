const arr = [1, 2, 3, 4, 5, 6, 7];
console.log("배열 : " + arr);

const mapArr = arr.map((element) => {
  return element * 2;
});
console.log("요소 2배 배열 : " + mapArr);