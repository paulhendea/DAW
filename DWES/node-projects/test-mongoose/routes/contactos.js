import express from 'express'
import { Contacto } from '../models/contacto.js'

let router = express.Router()

router.get('/', (req, res) => {
  Contacto.find()
    .then((resultado) => {
      res.send(resultado)
    })
    .catch((error) => {
      res.send([])
    })
})

router.get('/:id', (req, res) => {
  Contacto.findById(req.params.id)
    .then((resultado) => {
      if (resultado) res.send({ error: false, resultado: resultado })
      else
        res.send({
          error: true,
          mensajeError: 'No se han encontrado contactos',
        })
    })
    .catch((error) => {
      res.send({
        error: true,
        mensajeError: 'Error buscando el contacto indicado',
      })
    })
})

router.post('/', (req, res) => {
  let nuevoContacto = new Contacto({
    nombre: req.body.nombre,
    telefono: req.body.telefono,
    edad: req.body.edad,
    restauranteFavorito: req.body.restauranteFavorito,
    mascotas: req.body.mascotas,
  })
  nuevoContacto
    .save()
    .then((resultado) => {
      res.send({ error: false, resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error añadiendo contacto' })
    })
})

router.put('/:id', (req, res) => {
  Contacto.findByIdAndUpdate(
    req.params.id,
    {
      $set: {
        nombre: req.body.nombre,
        telefono: req.body.telefono,
        edad: req.body.edad,
        restauranteFavorito: req.body.restauranteFavorito,
        mascotas: req.body.mascotas,
      },
    },
    { new: true }
  )
    .then((resultado) => {
      res.send({ error: false, resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error actualizando contacto' })
    })
})

router.delete('/:id', (req, res) => {
  Contacto.findByIdAndRemove(req.params.id)
    .then((resultado) => {
      res.send({ error: false, resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error eliminando contacto' })
    })
})

export { router as contactos } 
