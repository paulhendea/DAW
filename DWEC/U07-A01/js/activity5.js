function searchText() {
  // get text
  let text = document.getElementById('text').value
  let regexp = new RegExp(text, 'g')
  
  // find in the article 
  let content = document.getElementById('content').children
  for (let children of content) {
    children.innerHTML = children.textContent.replace(regexp, `<mark>${text}</mark>`)
  }
}