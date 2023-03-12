// get the prime numbers between 1 and 1000 and save them as list items
let list = document.createElement('ul')
for (let i = 1; i <= 1000; i++) {
  if (isPrime(i)) {
    let listItem = document.createElement('li')
    listItem.innerHTML = i
    list.appendChild(listItem)
  }
}
// append te list to the document
document.getElementById('main').appendChild(list)

function isPrime(number) {
  // zero or negative numbers can't be prime numbers
  // by convention 1 is not a prime number
  if (number <= 1) return false

  // if the number can be divided evenly by any number 
  // between 2 and its square root is not prime
  let squareRoot = Math.sqrt(number)
  for (let i = 2; i <= squareRoot; i++) {
    if (number % i === 0) return false
  }
  return true
}