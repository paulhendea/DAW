// toggle hamburger menu animation
let hamburger = document.getElementById('hamburger')
let menu = document.getElementById('menu')
hamburger.addEventListener('click', (event) => {
  hamburger.classList.toggle('open')
  menu.classList.toggle('open')
})

// function to update lang-social-buttons position by a given query
function updateLangSocialButtons(query) {
  let langSocialButtons = document.getElementById('lang-social-buttons')
  if (query.matches) {
    let navButtons = document.getElementById('nav-buttons')
    navButtons.insertBefore(langSocialButtons, navButtons.firstChild)
  } else {
    let menuButtons = document.getElementById('menu-buttons')
    menuButtons.append(langSocialButtons)
  }
}

// update initial position and initial carousels
const mediaQuery = window.matchMedia('(min-width: 768px)')
updateLangSocialButtons(mediaQuery)

// update media query events
mediaQuery.addEventListener('change', updateLangSocialButtons)

// cookies
let cookies = new Map()
document.cookie.split('; ').forEach((cookie) => {
  let [key, value] = cookie.split('=')
  cookies.set(key, value)
})

if (!cookies.has('cookies') || cookies.get('cookies') != 'accepted') {
  let cookiesBanner = document.getElementById('cookies-banner')
  cookiesBanner.style.display = 'flex'
  
  let acceptButton = cookiesBanner.querySelector('#cookiesAccepted')
  acceptButton.addEventListener('click', event => {
    document.cookie = 'cookies=accepted'
    cookiesBanner.style.display = 'none'
  })

  let declineButton = cookiesBanner.querySelector('#cookiesDeclined')
  declineButton.addEventListener('click', event => {
    document.cookie = 'cookies=declined'
    cookiesBanner.style.display = 'none'
  })

} 