var words = []

function addWord() {
  let word = document.getElementById('text').value

  // if the word is empty print stats and exit
  if (!word) {
    printStats()
    return
  }

  document.getElementById('response').innerHTML = `${word} was added :)`
  words.push(word)
}

function printStats() {
  // get the map from the array
  let wordsMap = arrayToMap(words)

  // create the list
  let list = document.createElement('ul')

  // for each element in the dictionary insert an item
  let maxProgressValue = getMaxNumber(wordsMap)
  for (let key in wordsMap) {
    let listItem = document.createElement('li')
    listItem.innerHTML = `${key}: ${wordsMap[key]}`

    // create a progress bar with some attributes
    let progressBar = document.createElement("progress");
    progressBar.setAttribute("max", maxProgressValue);
    progressBar.setAttribute("value", wordsMap[key]);
    listItem.appendChild(progressBar);
    
    list.appendChild(listItem)
  }

  // clean the response and append the list
  document.getElementById('response').innerHTML = ''
  document.getElementById('response').appendChild(list)
}

function arrayToMap(array) {
  let map = {}
  for (let element of array) {
    // if the element exists add 1
    if (map[element]) map[element]++
    // else initialize it
    else map[element] = 1
  }
  return map
}

function getMaxNumber(stats) {
  // gets the max value to use in the progress bar
  let max = 0
  for (let key in stats) {
    max = Math.max(max, stats[key])
  }
  return max
}
