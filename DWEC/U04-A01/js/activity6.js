// get array with numbers
let numberList = getNumberArray(20, 1, 50);

// loop through the array
let charPattern = '';
for (const number of numberList) {
   charPattern += getChar('*', number);
   charPattern += '<br>'; 
}

// create document elements
let arrayObject = document.createElement('code');
arrayObject.innerHTML = 'Array: ' + JSON.stringify(numberList);
let paragraph = document.createElement('p');
paragraph.innerHTML = charPattern;

// append elements
document.getElementById('code').appendChild(arrayObject);
document.getElementById('pattern').appendChild(paragraph);

function getNumberArray(number, min, max) {
  let array = [];
  for (let i = 0; i < number; i++) {
    // fill the array with random numbers between min and max
    array[i] = Math.floor(Math.random() * (max - min) + min + 1);
  }
  return array;
}

function getChar(char, number) {
    // return the a string with a 'char' a 'number' of times
    let result = '';
    for (let i = 0; i < number; i++) {
        result += char;
    }
    return result;
}