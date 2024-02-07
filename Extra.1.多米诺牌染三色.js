let coloring = function (str) {
  let str1 = str[0].split("");
  let str2 = str[1].split("");
  let n = str1.length;

  let res = 1;
  let pre = 0;
  let i = 0;

  let MOD = 1000000007;

  if (str1[i] === str2[i]) {
    res *= 3;
    pre = 1;
    i++;
  } else {
    res *= 6;
    pre = 2;
    i += 2;
  }

  while (i < n) {
    if (str1[i] === str2[i]) {
      if (pre === 1) {
        res = (res * 2) % MOD;
        pre = 1;
        i++;
      } else {
        res = res * 1;
        pre = 1;
        i++;
      }
    } else {
      if (pre === 1) {
        res = (res * 2) % MOD;
        pre = 2;
        i += 2;
      } else {
        res = (res * 3) % MOD;
        pre = 2;
        i += 2;
      }
    }
  }

  return res;
};

console.log(coloring(["a", "a"]));
console.log(coloring(["ab", "ab"]));
console.log(coloring(["abb", "acc"]));
console.log(coloring(["abb", "acc"]));
console.log(coloring(["aacx", "bbcx"]));
