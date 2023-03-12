function closeCookies() {
  let cookies = document.getElementById('cookies')
  cookies.style.cssText = 'transform: translateY(100px); transition: 0.5s ease;'
  setInterval(() => {
    cookies.remove()
  }, 1000);
}