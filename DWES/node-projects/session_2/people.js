export { newPerson, removePerson }

function newPerson(array, newPerson) {
  return new Promise((resolve, reject) => {
    let aux = array.filter(person => person.telephone == newPerson.telephone)
    if (aux.length == 0) {
      array.push(newPerson)
      resolve(newPerson)
    }
    else reject('Error: This telephone is taken')
  })
}

function removePerson(array, telephone) {
  return new Promise((resolve, reject) => {
    let personIndex = array.findIndex(person => person.telephone == telephone)
    if (personIndex > -1) {
      resolve(array.splice(personIndex, 1)[0])
    }
    else reject('Error: No coincidence')
  })
}