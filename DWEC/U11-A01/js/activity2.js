// get the number of times from local storage
let times = localStorage.getItem('numberOfTimes')

// if there is no variable on local storage set to 1
if (times === null) times = 1
else times++

// set title
let titleNumber = document.getElementById('number-of-times')
titleNumber.textContent = times

// set local storage variable
localStorage.setItem('numberOfTimes', times)