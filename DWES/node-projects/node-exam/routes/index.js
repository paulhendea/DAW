const express = require('express')

const router = express.Router()

// routes
router.get('/', (req, res) => {
  res.render('index')
})
router.get('/nueva_categoria', (req, res) => {
  res.render('nueva_categoria')
})
router.get('/nuevo_participante', (req, res) => {
  res.render('nuevo_participante')
})

module.exports = router
