const ANIMALS = ['dog', 'cat', 'bird', 'fish', 'elephant']
const FOODS = ['spaghetti', 'cake', 'steak', 'sausage']
const NUMBERS = [1, 3, 2, 5, 3, 4, 6, 34, 5, 4, 23, 423]

// test function
console.log('Animals with 3 letters: ')
console.log(filter(ANIMALS, hasThreeLetters))
console.log('Foods with letter S: ')
console.log( filter(FOODS, startsWithLetterS))
console.log('Numbers greater than 5: ')
console.log(filter(NUMBERS, isGreaterThan5))

function filter(array, callbackFunction) {
  // create a new array to contains the filtered elements
  let resultElements = []
  // for each element in the array
  for (let i in array) {
    // call the callback function
    if (callbackFunction(array[i])) {
      resultElements.push(array[i])
    }
  }
  return resultElements
}

function isGreaterThan5(number) {
  return number > 5
}

function hasThreeLetters(word) {
  return word.length === 3
}

function startsWithLetterS(word) {
  return word.startsWith('s')
}