let date = new Date()
if (date.getDay() === 6 || date.getDay() === 0 || date.getHours() < 9 || date.getHours >= 14) {
  print('Site closed! :(')
}
else {
  print('Welcome :)')
}

function print(message) {
  let response = document.getElementById('response')
  response.innerHTML = message
}
