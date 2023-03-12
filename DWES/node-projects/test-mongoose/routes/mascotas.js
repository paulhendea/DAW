import express from 'express'
import { Mascota } from '../models/mascota.js'

let router = express.Router()

// Servicio de listado
router.get('/', (req, res) => {
  Mascota.find()
    .then((resultado) => {
      res.send(resultado)
    })
    .catch((error) => {
      res.send([])
    })
})
// Servicio de inserción
router.post('/', (req, res) => {
  let nuevaMascota = new Mascota({
    nombre: req.body.nombre,
    tipo: req.body.tipo,
  })
  nuevaMascota
    .save()
    .then((resultado) => {
      res.send({ error: false, resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error añadiendo mascota' })
    })
})
// Servicio de borrado
router.delete('/:id', (req, res) => {
  Mascota.findByIdAndRemove(req.params.id)
    .then((resultado) => {
      res.send({ resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error borrando mascota' })
    })
})

export { router as mascotas }