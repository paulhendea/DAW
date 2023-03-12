// recursive function to get all the text from a node
function getAllText(node) {
  let text = ''
  for (let children of node.childNodes) {
    // node type 1 is element and 3 is text
    if (children.nodeType == 1) text += getAllText(children)
    else if (children.nodeType == 3) text += children.textContent
  }
  return text
}

// get all text from the page
let pageText = getAllText(document.body)
// save in the array every word using a regexp
let wordsArray = [...pageText.matchAll(/\w+/g)]
// print the result
let response = document.getElementById('response')
// don't forget to add the response words
response.textContent = `There are ${wordsArray.length + 4} words :)`