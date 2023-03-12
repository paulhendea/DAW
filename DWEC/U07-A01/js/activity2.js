// set timer
setInterval(print, 1000)

// redirect to google in 5 sec
setTimeout(() => {
  window.location.href = 'https://www.google.es/'
}, 5000)

// timer function
var count = 4
function print(message) {
  document.getElementById('counter').textContent = count--
}