const express = require('express')
const Participante = require(__dirname + '/../models/Participante')
const Categoria = require(__dirname + '/../models/Categoria')
const moment = require('moment')

const router = express.Router()

// routes
router.get('/', (req, res) => {
  Participante.find()
    .populate('categoria')
    .then((result) => {
      console.log(result)
      res.render('lista_participantes', { participantes: result })
    })
    .catch((error) => console.log(error))
})
router.post('/', (req, res) => {
  let dorsal = ultimoDorsal() ?? 1111
  let edad = calcularEdad(req.body.fechaNacimiento)
  let categoria = calcularCategoria(edad)
  console.log({ dorsal })
  console.log({ categoria })

  let nuevoParticipante = new Participante({
    dorsal: dorsal + 1,
    nombre: req.body.nombre,
    apellidos: req.body.apellidos,
    fechaNacimiento: req.body.fechaNacimiento,
    categoria: categoria,
  })
  nuevoParticipante
    .save()
    .then((result) => res.render('nuevo_participante', { error: false }))
    .catch((error) => {
      console.log(error)
      res.render('nuevo_participante', { error: true, message: error })
    })
})

// helper functions
function ultimoDorsal() {
  return Participante.findOne()
    .sort({ _id: -1 })
    .then((result) => result.dorsal)
    .catch((error) => console.log(error))
}

function calcularCategoria(edad) {
  return Categoria.findOne({
    minEdad: { $lte: edad },
    maxEdad: { $gte: edad },
  })
    .then((result) => result._id)
    .catch((error) => console.log(error))
}

function calcularEdad(fechaNacimiento) {
  let now = moment()
  let birthDate = moment(fechaNacimiento)
  return moment.duration(now.diff(birthDate)).years()
}

module.exports = router
