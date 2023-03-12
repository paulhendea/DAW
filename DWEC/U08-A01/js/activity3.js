// get the box element
let box = document.getElementById('box')

// remove default event from contextmenu
box.addEventListener('contextmenu', (element) => element.preventDefault())

// paint green when mouse enter and revert on mouse leave
box.addEventListener('mouseenter', () => box.classList.add('bg-green'))
box.addEventListener('mouseleave', () => box.classList.remove('bg-green'))

// paint red when mouse down and revert on mouse up
box.addEventListener('mousedown', (mouse) => {
  if (mouse.button == 0) box.classList.add('bg-red')
  else if (mouse.button == 2) box.classList.add('bg-blue')
})
box.addEventListener('mouseup', (mouse) => {
  if (mouse.button == 0) box.classList.remove('bg-red')
  else if (mouse.button == 2) box.classList.remove('bg-blue')
})