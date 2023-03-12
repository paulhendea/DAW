/**
 * Capitalize the first letter of a text
 * @param {string} text
 */
function capitalize(text) {
  return text[0].toUpperCase() + text.slice(1)
}

/**
 * Format the random user data in the given element
 * @param {Element} userElement Element where the data will be written
 * @param {JSON} user Contains the user data
 */
function fillUser(userElement, user) {
  // get the relevant data
  let {
    picture,
    name,
    email,
    location: { street, city, state },
  } = user

  // create elements and append to userElement
  let imgElement = document.createElement('img')
  imgElement.src = picture.large
  userElement.append(imgElement)

  let nameElement = document.createElement('p')
  nameElement.textContent = `${name.title} ${name.first} ${name.last}`
  userElement.append(nameElement)

  let emailElement = document.createElement('a')
  emailElement.textContent = email
  emailElement.href = 'mailto:' + email
  userElement.append(emailElement)

  let addressElement = document.createElement('p')
  addressElement.textContent = `${street.name} ${street.number}`
  userElement.append(addressElement)

  let locationElement = document.createElement('p')
  locationElement.textContent = `${city}, ${state}`
  userElement.append(locationElement)
}

/**
 * Creates an event listener on the given element
 * @param {Element} userElement Element to create the event listener on
 */
function generateEventButton(userElement) {
  // create hover event
  userElement.addEventListener('mouseenter', (event) => {
    userElement.style.transform = 'scale(1.2)'
  })
  userElement.addEventListener('mouseleave', (event) => {
    userElement.style.transform = 'none'
  })

  // create click event
  userElement.addEventListener('click', (event) => {
    // clear element and set loading text
    userElement.innerHTML = ''
    userElement.textContent = 'loading...'

    fetch('https://randomuser.me/api')
      .then((result) => result.json())
      .then((person) => {
        // clear element and fill with user data
        userElement.innerHTML = ''
        fillUser(userElement, person.results[0])
      })
      .catch((error) => console.log(error))
  })
}

/**
 * Main code
 */
let main = document.createElement('main')
document.body.append(main)
main.textContent = 'Waiting users...'
// Request for users
fetch('https://randomuser.me/api?results=10')
  .then((result) => result.json())
  .then((content) => {
    // clear main element
    main.innerHTML = ''

    // for each person fill the card
    for (person of content.results) {
      let article = document.createElement('article')
      fillUser(article, person)
      generateEventButton(article)
      main.append(article)
    }
  })
  .catch((error) => console.log(error))
