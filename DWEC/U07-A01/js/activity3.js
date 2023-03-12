function showCookiesPermission() {
  // create elements
  let aside = document.createElement('aside')
  aside.id = 'cookies'
  let text = document.createElement('p')
  text.textContent = 'The cookie on this page will be used to display the num of times you visited the web'
  let acceptBtn = document.createElement('button')
  acceptBtn.textContent = 'Accept'
  acceptBtn.setAttribute('onclick', 'acceptCookies()')
  let declineBtn = document.createElement('button')
  declineBtn.textContent = 'Decline'
  declineBtn.setAttribute('onclick', 'declineCookies()')

  // append elements
  aside.appendChild(text)
  aside.appendChild(acceptBtn)
  aside.appendChild(declineBtn)
  document.body.appendChild(aside)
}

function showTimes(times) {
  // set new cookie
  document.cookie = `times=${+times +1}`
  
  // create elements
  let aside = document.createElement('aside')
  aside.innerHTML = `<p>You visited this web ${times} times</p>`
  aside.id = 'times'

  // append elements
  document.body.appendChild(aside)
}

function acceptCookies() {
  // set the cookie
  let date = new Date()
  date.setFullYear(date.getFullYear() +1)
  document.cookie = `times=1; expires=${date.toUTCString()}`

  // show times
  showTimes(1)
  
  // close cookies banner
  closeCookiesPermission()
}

function declineCookies() {
  // just close de cookies banner
  closeCookiesPermission()
}

function closeCookiesPermission() {
  // transition out and remove element
  let cookiesBanner = document.getElementById('cookies')
  cookiesBanner.style.cssText = 'transform: translateY(100px); transition: 0.5s ease'
  setTimeout(() => {
    document.body.removeChild(cookiesBanner)
  }, 1000);
}
 
// get cookies
let cookiesArray = document.cookie
let cookies = new Map()
for (let cookie of cookiesArray.split('; ')) {
  let [name, value] = cookie.split('=')
  cookies.set(name, value)
}
// check for times cookie
if (cookies.has('times')) {
  showTimes(cookies.get('times'))
}
else showCookiesPermission()