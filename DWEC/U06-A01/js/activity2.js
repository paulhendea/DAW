// Add mean method to Array prototype
Array.prototype.mean = function() {
  let total = this.reduce((acc, cur) => acc + cur, 0)
  return total / this.length
}

// Test
const NUMBERS = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
console.log(NUMBERS.mean())