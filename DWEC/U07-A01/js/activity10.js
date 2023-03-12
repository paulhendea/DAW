// get the paragraphs node
let paragraphs = document.getElementById('content').children

// save text into an array and remove from document
let auxArray = []
;[...paragraphs].forEach(element => {
  auxArray.push(element.textContent)
  element.parentNode.removeChild(element)
})

// set interval to progressively show the paragraphs
let content = document.getElementById('content')
const intervalID = setInterval(() => {
  // if the auxArray is empty, cancel the interval
  if (auxArray.length == 0) return clearInterval(intervalID)

  // create a paragraph with the following content in auxArray and append to the page
  let paragraph = document.createElement('p')
  paragraph.textContent = auxArray.shift()
  content.appendChild(paragraph)
}, 1000);