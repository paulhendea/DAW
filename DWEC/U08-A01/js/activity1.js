// create message element with position absolute
let message = document.createElement('p')
message.textContent = 'I will follow you (ﾉ´ з `)ノ'
message.style.cssText = 'position: absolute; width: fit-content; padding: 1rem; border: 1px solid blue; transition: 0.1s ease;'
document.body.appendChild(message)

// create circle element with position absolute
let circle = document.createElement('div')
circle.style.cssText = 'position: absolute; width: 2rem; height: 2rem; border: 5px solid black; border-radius: 50%; transition: 0.01s ease;'
document.body.appendChild(circle)

// add event listener to document for mouse move and set top and left properties to the elements based on mouse position + some math :)
document.addEventListener('mousemove', (cursor) => {
  circle.style.top = (cursor.clientY - circle.offsetHeight / 2) + 'px'
  circle.style.left = (cursor.clientX - circle.offsetWidth / 2) + 'px'
  
  message.style.top = (cursor.clientY - message.offsetHeight - 20) + 'px'
  message.style.left = (cursor.clientX - message.offsetWidth - 20) + 'px'
})