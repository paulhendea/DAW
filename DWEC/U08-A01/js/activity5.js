// create button
let deleteButton = document.createElement('button')
deleteButton.textContent = 'Delete'
deleteButton.style.cssText = 'display: none; padding: 0.5rem; position: relative; top: 30%; color: white; background-color: black; font-weight: bold; border: none'
deleteButton.addEventListener('click', () => {
  // remove box and button
  let box = document.getElementById('box')
  document.body.removeChild(box)
  document.body.removeChild(deleteButton)
})
document.body.appendChild(deleteButton)

document.getElementById('box').addEventListener('scroll', (scroll) => {
  // get box element
  let box = document.getElementById('box')

  // if the scroll is at the bottom show button
  if (box.offsetHeight + box.scrollTop == box.scrollHeight) {
    deleteButton.style.display = 'inline'
  }
  else {
    // else hide button
    deleteButton.style.display = 'none'
  }
})