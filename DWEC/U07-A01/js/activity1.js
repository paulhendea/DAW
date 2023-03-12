function addParagraph() {
  // reset response
  print('')
  
  // get data
  let text = document.getElementById('text').value
  let position = +document.getElementById('position').value

  // validation
  if (!text) return print('Wrong text :(')
  if (isNaN(position) || !position || position < 1) return print('Wrong position :(')

  // get list node
  let list = document.getElementsByTagName('ol')[0]
  if (position > list.children.length +1) return print('Wrong position :(')
  // create new node
  let listItem = document.createElement('li')
  listItem.innerHTML = text
  // put paragraph
  list.insertBefore(listItem, list.children[position -1]) 
}

function print(message) {
  let response = document.getElementById('response')
  response.innerHTML = message
}
