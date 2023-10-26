const id = "ssafy";
const name = "싸피";
const age = 3;

const member1 = {
  id: id,
  name: name,
  age: age,
  info: function () {
    console.log("info");
  },
};

const member2 = {
  id,
  name,
  age,
  info() {
    console.log("info");
  },
};

console.log(member1);
console.log(member2);
