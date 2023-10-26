function test_1() {
  let x = "let";
  {
    const x = "const";
    if (x === "const") {
      console.log("I am " + x);
    }
  }
  x = "changed";
  if (x === "changed") {
    console.log("I am let");
  }
}