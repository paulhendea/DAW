// crate a regex to validate urls
// double backslash is used because we are working with strings
const URL_REGEX = new RegExp(
    '^' /* start */ +
    '[a-z\\.\\-\\+]{2,17}\\:\\/{1,3}' /* check the protocol */ +
    '(\\w+(\\.\\w+)*(\\:.*)?\\@)?' /* user and password */ +
    '(\\w+(\\.\\w+)+)+' /* machine name separated by periods */ +
    '(\\:[0-9]{2,4})?' /* port */ +
    '((\\/(\\w+(\\.\\w+)*))*(\\?(\\w+\\=\\w+(\\&\\w+\\=\\w+)*)+)?)?' /* path and query params */ +
    '$' /* end */
)

function validateURL() {
  let url = document.getElementById('url').value
  if (URL_REGEX.test(url)) print('Ok :)')
  else print('Incorrect url >:(')
}

function print(message) {
  let response = document.getElementById('response')
  response.innerHTML = `<p>${message}</p>`
}
