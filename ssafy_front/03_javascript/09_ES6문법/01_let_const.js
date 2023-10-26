// let 블록스코프 / 재선언 X 재사용 O

let a = 100;
{
  //블록 안에 있으므로 외부의 a와는 별개의 a
  let a = 200;
  console.log(a);
}
console.log(a);

// 함수 스코프도 스코프로 인정
let b = 100;
function info() {
  let b = 200;
}

// const 블록스코프 / 재선언 X 재사용 X
const name = "yang";
console.log(id);
id = "lee"; //불가능
console.log(id);
