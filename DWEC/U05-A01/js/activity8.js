function isAnagram(text, ...words) {
  // clean and sort text
  text = cleanText(text)
  text = sortText(text);
  for (let i in words) {
    // clean and sort every word before check
    words[i] = cleanText(words[i])
    words[i] = sortText(words[i])
    // cant be anagrams if the length is different
    if (words[i].length != text.length) return false  
    // compare both
    if (text != words[i]) return false
  }

  // if everything went ok
  return true
}

function cleanText(text) {
  // removes any non-alphabetical character
  // and converts special ones to normal form
  return text
    .trim()
    .toLowerCase()
    .normalize('NFD')
    .replaceAll(/[^a-zñ]/g, '')
}

function sortText(text) {
  // converts to array, sorts, and returns string
  return [...text].sort().join('')
}

// show result
const TEXT = 'Animal'
const WORDS = ['Manila']
console.log(isAnagram(TEXT, ...WORDS))