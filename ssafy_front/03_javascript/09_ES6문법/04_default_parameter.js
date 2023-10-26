function myInfo(name, age = 0, address = "x", email = "x") {
  console.log(
    `이름 : ${name}, 나이 : ${age}, 주소 : ${address}, email=${email}`
  );
}

myInfo("양띵균", 42);
myInfo("yang");
myInfo("yang", 10, "역삼");


function myInfo2(name, age = 0, address, email) {
  console.log(
    `이름 : ${name}, 나이 : ${age}, 주소 : ${address}, email=${email}`
  );
}

myInfo2("yang", 10, "역삼");