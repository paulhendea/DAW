document.addEventListener('keydown', (keyboard) => {
  // get speed element and content
  let speedElement = document.getElementById('speed')
  let speed = +speedElement.textContent

  // check key and speed
  if (keyboard.key == 'ArrowUp' && speed < 120) speedElement.textContent = speed + 1
  else if (keyboard.key == 'ArrowDown' && speed > 0) speedElement.textContent = speed - 1
})