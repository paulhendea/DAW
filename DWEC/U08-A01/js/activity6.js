window.addEventListener('load', (load) => {
  // remove loader
  let loadingElement = document.getElementById('loading')
  loadingElement.parentNode.removeChild(loadingElement)
  
  // show main content
  let mainElement = document.getElementsByTagName('main')[0]
  mainElement.style.display = 'block'
})