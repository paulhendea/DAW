// declare a constant set and an array
const setWords = new Set()
var arrayWords = []

// ask for a word, if the users cancel or press submit without typing anything
// the program will continue
// also I suggest the using of do...while() since you can avoid to repeat code
var word = prompt('Write a word ,or leave it empty if you want to finish')
while (word != null && word != '') {
  setWords.add(word)
  word = prompt('Write a word ,or leave it empty if you want to finish')
}

// converts the set into an array using spread operator and saves it into arrayWords
arrayWords = [...setWords]

// sorts the array using one line function and localeCompare method
// by typing a (-) at the beginning the order will be reversed
arrayWords.sort((a, b) => -a.localeCompare(b, 'es'))

// for each element of the array writes a paragraph in the document with its value  
arrayWords.forEach(function (w) {
  document.write(`<p>${w}</p>`)
})
