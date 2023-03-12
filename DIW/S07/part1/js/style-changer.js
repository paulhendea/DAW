const RETRO = 'css/retro.css'
const MODERN = 'css/modern.css'

function changeStyle() {
  // change css ref
  let style = document.getElementById('style')
  style.href = style.href.includes(RETRO) ? MODERN : RETRO
  
  // change button text
  let button = document.getElementById('styleButton')
  button.innerHTML = button.textContent === 'Retro' ? 'Modern' : 'Retro'
}