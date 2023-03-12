const express = require('express')

let Tarea = require(__dirname + '/../models/tarea.js')

const FILTRO_DEFAULT = 'fecha'
const FILTROS = ['fecha', 'prioridad']
const PRIORIDADES = ['BAJA', 'NORMAL', 'ALTA']
const MESES = [
  'Enero',
  'Febrero',
  'Marzo',
  'Abril',
  'Mayo',
  'Junio',
  'Julio',
  'Agosto',
  'Septiembre',
  'Octubre',
  'Noviembre',
  'Diciembre',
]

let router = express.Router()

// routes
router.get('/', (req, res) => {
  let orden = FILTRO_DEFAULT
  if (FILTROS.includes(req.query.orden)) orden = req.query.orden

  Tarea.find().sort(orden)
    .then((result) => res.render('lista_tareas', { tareas: result }))
    .catch((error) => res.render('lista_tareas', { tareas: [] }))
})
router.get('/:id', (req, res) => {
  Tarea.findById(req.params.id)
    .then((result) => {
      res.render('ficha_tarea', { tarea: result, prioridades: PRIORIDADES })
    })
    .catch((error) => res.render('ficha_tarea', { tarea: null }))
})
router.post('/', (req, res) => {  
  let nuevaTarea = new Tarea({
    titulo: req.body.titulo,
    fecha: req.body.fecha,
    prioridad: req.body.prioridad,
  })
  nuevaTarea.save()
    .then(result => res.send({ error: false, tarea: result }))
    .catch(error => res.send({ error: true, message: error}))
})
router.delete('/:id', (req, res) => {
  Tarea.findByIdAndDelete(req.params.id)
    .then(result => res.send({ error: false, tarea: result }))
    .catch(error => res.send({ error: true, message: error }))
})

module.exports = router
