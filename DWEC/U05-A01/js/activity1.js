const NUMBERS = 500
const MIN_RANDOM = 1
const MAX_RANDOM = 10000

// create html elements
let list = document.createElement('ul')

// write numbers
for (let i = 0; i < NUMBERS; i++) {
  let listItem = document.createElement('li')
  let randomNum = parseInt(Math.random() * (MAX_RANDOM - MIN_RANDOM) + MIN_RANDOM)
  listItem.innerHTML = `${randomNum} is ${parity(randomNum)}`
  list.appendChild(listItem)
}
// append list to document
document.getElementById('main').appendChild(list)

function parity(number) {
  return number % 2 === 0 ? 'even' : 'odd'
}