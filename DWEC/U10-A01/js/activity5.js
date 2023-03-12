// To simplify the exercise there can only be one image blured at the time,
// when a second image is clicked will become the blured one,
// when the blured image is clicked will unblur it

function getCookies() {
  let cookies = new Map()
  let rawCookies = document.cookie
  rawCookies.split('; ').forEach((cookie) => {
    let [name, value] = cookie.split('=')
    cookies.set(name, value)
  })
  return cookies
}

function setCookie(name, value) {
  // if the cookie is already set, save null
  let cookies = getCookies()
  if (cookies.get(name) == value) value = null

  // by default expires in one week
  let oneWeekInMs = 1000 * 60 * 60 * 24 * 7
  let expireDate = new Date(Date.now() + oneWeekInMs)
  document.cookie = `${name}=${value}; expires=${expireDate}`
}

function loadImages(blurImageId) {
  // get images element
  let images = document.getElementById('images')

  for (let id = 0; id < 100; id++) {
    // create placeholders
    let image = document.createElement('img')
    image.id = id
    image.addEventListener('click', (event) => {
      // set cookie and reload
      setCookie('blurImage', id)
      location.reload()
    })
    images.append(image)

    // get images
    let blur = id == blurImageId ? '?blur&grayscale' : ''
    fetch(`https://picsum.photos/id/${id}/300` + blur)
      .then((response) => response.blob())
      .then((result) => {
        // create img and append to document
        image.setAttribute('src', URL.createObjectURL(result))
      })
      .catch((error) => console.log(error))
  }
}

// get cookies and load images with the blured one
var cookies = getCookies()
loadImages(cookies.get('blurImage'))
