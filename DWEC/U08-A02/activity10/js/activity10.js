let addButton = document.getElementById('add')
addButton.addEventListener('click', (event) => {
  let [number1, number2] = getNumbers()
  setResult(number1 + number2)
})

let subtractButton = document.getElementById('subtract')
subtractButton.addEventListener('click', (event) => {
  let [number1, number2] = getNumbers()
  setResult(number1 - number2)
})

let multiplyButton = document.getElementById('multiply')
multiplyButton.addEventListener('click', (event) => {
  let [number1, number2] = getNumbers()
  setResult(number1 * number2)
})

let divideButton = document.getElementById('divide')
divideButton.addEventListener('click', (event) => {
  let [number1, number2] = getNumbers()
  setResult(number1 / number2)
})

let clearEntryButton = document.getElementById('ce')
clearEntryButton.addEventListener('click', (event) => {
  document.getElementById('number1').value = ''
  document.getElementById('number2').value = ''
  setResult('')
})

function getNumbers() {
  let number1 = +document.getElementById('number1').value
  let number2 = +document.getElementById('number2').value
  return [number1, number2]
}
function setResult(number) {
  let result = document.getElementById('result')
  result.value = number
}
