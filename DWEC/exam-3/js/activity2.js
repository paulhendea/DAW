function generar() {
  // get the the elements with id 'primero' and 'segundo'
  let primero = document.getElementById('primero')
  let segundo = document.getElementById('segundo')

  // generate 2 random numbers between 0 and 9
  let numero1 = parseInt(Math.random() * 10)
  let numero2 = parseInt(Math.random() * 10)

  // get the first child of first and second paragraph
  let parrafoAnterior1 = primero.firstChild
  let parrafoAnterior2 = segundo.firstChild

  // create a paragraph and put the first random number inside
  let parrafo1 = document.createElement('p')
  let texto1 = document.createTextNode(numero1)
  parrafo1.appendChild(texto1)

  // replace the child of first paragraph or append it if its empty
  if (parrafoAnterior1 != null) {
    primero.replaceChild(parrafo1, parrafoAnterior1)
  } else {
    primero.appendChild(parrafo1)
  }

  // create a second paragraph and put the second random number inside
  let parrafo2 = document.createElement('p')
  let texto2 = document.createTextNode(numero2)
  parrafo2.appendChild(texto2)

  // replace the child of the second paragraph or append it if its empty
  if (parrafoAnterior2 != null) {
    segundo.replaceChild(parrafo2, parrafoAnterior2)
  } else {
    segundo.appendChild(parrafo2)
  }
}

function comparar() {
  // get the the elements with id 'primero' and 'segundo'
  let primero = document.getElementById('primero')
  let segundo = document.getElementById('segundo')

  // get all paragraphs from first and only the first child from second
  let parrafo1 = primero.firstChild
  let parrafo2 = segundo.firstChild

  // if the paragraphs are empty exit without doing anything else
  if (parrafo1 === null || parrafo2 === null) return

  //  get the numbers of the first childs of the paragraphs
  let numero1 = parseInt(parrafo1.firstChild.nodeValue)
  let numero2 = parseInt(parrafo2.firstChild.nodeValue)

  // get the paragraph with the largest number, use cloneNode to avoid deleting the first paragraph
  let parrafoMayor =
    numero1 > numero2 ? parrafo1.cloneNode(true) : parrafo2.cloneNode(true)

  // get the result element and save his first child
  let resultado = document.getElementById('resultado')
  let parrafoAnterior = resultado.firstChild

  // set the result to be the largest number
  if (parrafoAnterior != null) {
    resultado.replaceChild(parrafoMayor, parrafoAnterior)
  } else {
    resultado.appendChild(parrafoMayor)
  }
}

// get button elements and add the proper event listeners to them  
let generate = document.getElementById('generar')
generate.addEventListener('click', generar)

let compare = document.getElementById('comparar')
compare.addEventListener('click', comparar)
