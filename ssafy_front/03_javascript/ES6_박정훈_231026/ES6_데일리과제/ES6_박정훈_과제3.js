let a = 30;
let b = 40;

function test_3() {
  this.a = 10;
  this.b = 20;

  let max = () => (a > b ? a : b);
  console.log(max());

  let min = function () {
    return this.a < this.b ? this.a : this.b;
  };
  console.log(min());
}