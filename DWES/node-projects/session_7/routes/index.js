const express = require('express');

let router = express.Router();

// routes
router.get('/', (req, res) => {
  res.render('index')
})
router.get('/nueva_tarea', (req, res) => {
  res.render('nueva_tarea')
})

module.exports = router