const express = require('express')
const Categoria = require(__dirname + '/../models/Categoria')

const router = express.Router()

// routes
router.post('/', (req, res) => {
  let nuevaCategoria = new Categoria({
    codigo: req.body.codigo,
    descripcion: req.body.descripcion,
    minEdad: req.body.minEdad,
    maxEdad: req.body.maxEdad,
  })
  nuevaCategoria
    .save()
    .then((result) => res.render('nueva_categoria', { error: false }))
    .catch((error) => res.render('nueva_categoria', { error: true, message: error }))
})

module.exports = router
