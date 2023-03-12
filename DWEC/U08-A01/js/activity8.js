const IMAGES = {
  distribucion: '../img/distribucion.jpg',
  oficina: '../img/oficina.jpg',
  produccion: '../img/produccion.jpg',
}
const DEFAULT_IMAGE = '../img/oficina.jpg'

// set input event listener to form select flied
let typeInput = document.getElementById('tipo')
typeInput.addEventListener('input', (event) => {
  // get the form value and the equivalent path
  let value = event.target.value
  let imageSrc = IMAGES[value] ?? DEFAULT_IMAGE
  
  // set the image
  let image = document.getElementById('imagen')
  image.setAttribute('src', imageSrc)
})

// set onclick event listener to button
let button = document.getElementById('mostrarDescripcion')
button.addEventListener('click', (event) => {
  // show description
  let description = document.getElementById('fDescripcion')
  description.style.display = 'block'
  
  // delete button
  button.parentNode.removeChild(button)
})