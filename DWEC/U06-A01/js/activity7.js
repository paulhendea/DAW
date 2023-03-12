const NIF_REGEXP = /^([0-9XYZ][0-9]{7})([A-Z])$/
const NIF_LETTER = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E']

function validateNIF() {
  // get data
  let nif = document.getElementById('nif').value

  // format validation
  if (!NIF_REGEXP.test(nif)) return print('Wrong NIF format >:(')

  // validate nif itself
  let [, nifNumber, nifLetter] = NIF_REGEXP.exec(nif)
  console.log(nifNumber)
  console.log(nifLetter)
  nifNumber = nifNumber.replace('X', 0).replace('Y', 1).replace('Z', 2)
  nifExpectedLetter = NIF_LETTER[nifNumber % NIF_LETTER.length]

  if (nifLetter != nifExpectedLetter) return print('Wrong NIF value >:(')
  else return print('The NIF is correct :)')
  
}


function print(message) {
  let response = document.getElementById('response')
  response.innerHTML = message
}
