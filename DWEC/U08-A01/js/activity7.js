let box1 = document.getElementById('box1')
let box2 = document.getElementById('box2')

box1.addEventListener('dragstart', (event) => {
  box1.style.opacity = 0.5
})
box1.addEventListener('dragend', (event) => {
  box1.style.opacity = 1
})

box2.addEventListener('dragenter', (event) => {
  box2.style.cssText = 'background-color: red;'
})
box2.addEventListener('dragleave', (event) => {
  box2.style.cssText = 'background-color: transparent;'
})
box2.addEventListener('dragover', (event) => {
  event.preventDefault()
})
box2.addEventListener('drop', (event) => {
  // change text and background
  box2.style.cssText = 'background-color: green'
  box2.textContent = box1.textContent

  // remove event listeners from box 1
  box1.textContent = ''
  box1.style.cssText = 'background-color: transparent'
  box1.removeAttribute('draggable')
})
