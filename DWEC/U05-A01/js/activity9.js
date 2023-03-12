// The succession is 1,1,3,4,7,13,24,44,81,149,274,etc. makes no sense...
// Should be 0, 1, 1, 2, 4, 7, 13, 24, 44, 81, 149, 274, etc.

function recursiveTribonacciOf(number) {
  // quick validation
  if (number < 0) number = -number
  if (number === 0) return 0
  if (number === 1) return 1
  if (number === 2) return 1
  return (
    recursiveTribonacciOf(number - 3) +
    recursiveTribonacciOf(number - 2) +
    recursiveTribonacciOf(number - 1)
  )
}

function tribonacciOf(number) {
  // quick validation
  if (number < 0) number = -number
  if (number === 0) return 0
  if (number === 1) return 1
  if (number === 2) return 1

  // we know the first three numbers
  let num1 = 0
  let num2 = 1
  let num3 = 1
  let next = num1 + num2 + num3

  // calculate the following numbers
  for (let i = 3; i < number; i++) {
    // switch values and calculate
    [num1, num2, num3] = [num2, num3, next]
    next = num1 + num2 + num3
  }
  return next
}

// call the functions
console.log(`Recursive Tribonacci of 10: ${recursiveTribonacciOf(10)}`)
console.log(`Iterative Tribonacci of 10: ${tribonacciOf(10)}`)

console.log('Tribonacci succession: ')
for (let i = 0; i < 12; i++) {
  console.log(tribonacciOf(i))
}
console.log('etc.')
