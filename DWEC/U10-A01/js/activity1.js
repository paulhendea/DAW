fetch('https://randomuser.me/api')
  .then((response) => response.json())
  .then((content) => {
    // get the relevant data
    let {
      picture,
      name,
      email,
      location: { street, city, state },
    } = content.results[0]

    // create elements and append to person
    let personElement = document.getElementById('person')

    let imgElement = document.createElement('img')
    imgElement.src = picture.large
    personElement.append(imgElement)

    let nameElement = document.createElement('p')
    nameElement.textContent = `${name.title} ${name.first} ${name.last}`
    personElement.append(nameElement)

    let emailElement = document.createElement('a')
    emailElement.textContent = email
    emailElement.href = 'mailto:' + email
    personElement.append(emailElement)

    let addressElement = document.createElement('p')
    addressElement.textContent = `${street.name} ${street.number}`
    personElement.append(addressElement)

    let locationElement = document.createElement('p')
    locationElement.textContent = `${city}, ${state}`
    personElement.append(locationElement)
  })
  .catch((error) => console.log(error))
