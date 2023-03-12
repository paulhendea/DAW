function sortList() {
  // get the paragraphs node
  let list = document.getElementById('list')

  // convert the list to array, sort alphabetically and fill new list with sorted elements
  let sortedList = document.createElement('ul')
  sortedList.id = 'list'
  ;[...list.children]
    .sort((a, b) => a.textContent.localeCompare(b.textContent), 'es')
    .forEach(element => sortedList.appendChild(element))

  // replace list
  list.parentNode.replaceChild(sortedList, list)
}