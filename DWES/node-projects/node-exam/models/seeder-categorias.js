/* Me he dado cuenta del error al darle la vuelta a la hoja del examen :( */

const mongoose = require('mongoose')
const Categoria = require('./Categoria')

// db config
mongoose.Promise = global.Promise
mongoose.set('strictQuery', true)
mongoose.connect('mongodb://127.0.0.1:27017/carreras')

let promesa = new Categoria({
  codigo: 'PROM',
  descripcion: 'PROMESA',
  minEdad: 18,
  maxEdad: 24,
})
  .save()
  .then((result) => console.log(result))
  .catch((error) => console.log(error))

let senior = new Categoria({
  codigo: 'SEN',
  descripcion: 'SENIOR',
  minEdad: 25,
  maxEdad: 39,
})
  .save()
  .then((result) => console.log(result))
  .catch((error) => console.log(error))

let vetA = new Categoria({
  codigo: 'VET-A',
  descripcion: 'VETERANOS A',
  minEdad: 40,
  maxEdad: 49,
})
  .save()
  .then((result) => console.log(result))
  .catch((error) => console.log(error))

let vetB = new Categoria({
  codigo: 'VET-B',
  descripcion: 'VETERANOS B',
  minEdad: 50,
  maxEdad: 59,
})
  .save()
  .then((result) => console.log(result))
  .catch((error) => console.log(error))

let vetC = new Categoria({
  codigo: 'VET-C',
  descripcion: 'VETERANOS C',
  minEdad: 60,
  maxEdad: 100,
})
  .save()
  .then((result) => console.log(result))
  .catch((error) => console.log(error))
