// get the video
let video = document.getElementById('video')

// add event listeners
video.addEventListener('click', (event) => {
  if (video.paused) video.play()
  else video.pause()
})

video.addEventListener('contextmenu', (event) => {
  event.preventDefault()

  let alert = document.getElementById('alert')
  if (alert.style.display === 'none') {
    let time = secondsToMinutesAndSeconds(video.duration)
    alert.textContent = `${time.min}:${time.sec}`
    alert.style.display = 'block'
  } else {
    alert.style.display = 'none'
  }
})

// function to transform seconds to seconds and minutes
function secondsToMinutesAndSeconds(seconds) {
  let formatter = new Intl.NumberFormat('en', { minimumIntegerDigits: 2, maximumFractionDigits: 0 })
  let min = formatter.format(seconds / 60)
  let sec = formatter.format(seconds % 60)
  return { min, sec }
}
