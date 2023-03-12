import express from 'express'
import { Restaurante } from '../models/restaurante.js'

let router = express.Router()

// Servicio de listado
router.get('/', (req, res) => {
  Restaurante.find()
    .then((resultado) => {
      res.send(resultado)
    })
    .catch((error) => {
      res.send([])
    })
})
// Servicio de inserción
router.post('/', (req, res) => {
  let nuevoRestaurante = new Restaurante({
    nombre: req.body.nombre,
    direccion: req.body.direccion,
    telefono: req.body.telefono,
  })
  nuevoRestaurante
    .save()
    .then((resultado) => {
      res.send({ error: false, resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error añadiendo restaurante' })
    })
})
// Servicio de borrado
router.delete('/:id', (req, res) => {
  Restaurante.findByIdAndRemove(req.params.id)
    .then((resultado) => {
      res.send({ resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error borrando restaurante' })
    })
})

export { router as restaurantes }