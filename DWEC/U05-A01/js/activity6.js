function recursiveFibonacciOf(number) {
  // quick validation
  if (number < 0) number = -number
  if (number === 0) return 0
  if (number === 1) return 1
  return recursiveFibonacciOf(number - 2) + recursiveFibonacciOf(number - 1)
}

function fibonacciOf(number) {
  // quick validation
  if (number < 0) number = -number
  if (number === 0) return 0
  if (number === 1) return 1

  // we know the first two numbers
  let num1 = 0
  let num2 = 1
  let next = num1 + num2

  // calculate the following numbers
  for (let i = 2; i < number; i++) {
    // switch values and calculate
    ;[num1, num2] = [num2, next]
    next = num1 + num2
  }
  return next
}

// call the functions
console.log(`Recursive fibonacci of 10: ${recursiveFibonacciOf(10)}`)
console.log(`Iterative fibonacci of 10: ${fibonacciOf(10)}`)
