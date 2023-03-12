const RANDOM_BACKGROUND = 'https://source.unsplash.com/random'

// create event listener for keydown alt + F12
document.addEventListener('keydown', (event) => {
  if (event.altKey && event.key === 'F12') {
    // set a new random number to the end of the url as query params, 
    // this will not affect the request but the browser will think 
    // it is a different resource so will refresh the background
    let randomQuery = '?' + Math.floor(Math.random() * 100)
    // set the background to random one from unsplash.com/random
    document.documentElement.style.cssText = `background-image: url(${RANDOM_BACKGROUND + randomQuery}); background-size: cover;`
  }
})