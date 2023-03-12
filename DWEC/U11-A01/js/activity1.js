// define variables and function
let x = 0, y = 0
function loadAnimation() {
  const canvas = document.getElementById('canvas')
  const context = canvas.getContext('2d')
  context.beginPath()
  
  // draw gray rectangle
  context.fillStyle = 'gray'
  context.fillRect(x, y, 5, 50)

  // go to next rectangle or the first one
  x = x < 100 ? x + 10 : 0

  // draw black rectangle
  context.fillStyle = 'black'
  context.fillRect(x, y, 5, 50)
}

// play animation every 100ms
setInterval(() => {
  requestAnimationFrame(loadAnimation)
},  100);
