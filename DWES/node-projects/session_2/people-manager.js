import { newPerson, removePerson } from './people.js'

let people = [
  { name: 'Nacho', telephone: '966112233', age: 40 },
  { name: 'Ana', telephone: '911223344', age: 35 },
  { name: 'Mario', telephone: '611998877', age: 15 },
  { name: 'Laura', telephone: '633663366', age: 17 },
]

console.log('Add Juan', newPerson(people, { name: 'Juan', telephone: '965661564', age: 60 }))
console.log('Add Juan again', newPerson(people, { name: 'Juan', telephone: '965661564', age: 60 }))
console.log('Add Rodolfo', newPerson(people, { name: 'Rodolfo', telephone: '910011001', age: 20 }))
console.log('Remove Rodolfo', removePerson(people, '910011001'))
console.log('Remove Rodolfo again', removePerson(people, '910011001'))
console.log(people)