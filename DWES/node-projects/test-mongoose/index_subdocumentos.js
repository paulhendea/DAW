import mongoose from 'mongoose'
import express from 'express'
import bodyParser from 'body-parser'
let app = express()

// middleware
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))

// db config
mongoose.Promise = global.Promise
mongoose.connect('mongodb://127.0.0.1:27017//contactos_subdocumentos')

// schema
let restauranteSchema = new mongoose.Schema({
  nombre: {
    type: String,
    required: true,
    minlength: 1,
    trim: true,
  },
  direccion: {
    type: String,
    required: true,
    minlength: 1,
    trim: true,
  },
  telefono: {
    type: String,
    required: true,
    unique: true,
    trim: true,
    match: /^\d{9}$/,
  },
})

let mascotaSchema = new mongoose.Schema({
  nombre: {
    type: String,
    required: true,
    minlength: 1,
    trim: true,
  },
  tipo: {
    type: String,
    required: true,
    enum: ['perro', 'gato', 'otros'],
  },
})

let contactoSchema = new mongoose.Schema({
  nombre: {
    type: String,
    required: true,
    unique: true,
    minlength: 1,
    trim: true,
  },
  telefono: {
    type: String,
    required: true,
    trim: true,
    match: /^\d{9}$/,
  },
  edad: {
    type: Number,
    min: 18,
    max: 120,
  },
  restauranteFavorito: restauranteSchema,
  mascotas: [mascotaSchema],
})
let Contacto = mongoose.model('contacto', contactoSchema)

// routes
app.get('/contactos', (req, res) => {
  Contacto.find()
    .then((resultado) => {
      res.send(resultado)
    })
    .catch((error) => {
      res.send([])
    })
})

app.get('/contactos/:id', (req, res) => {
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

// obtener parametros por query string
app.get('/contactos', (req, res) => {
  if (req.query.id) {
    // Buscar por id
  } else {
    // Listado general de contactos
  }
})

app.post('/contactos', (req, res) => {
  let nuevoContacto = new Contacto({
    nombre: req.body.nombre,
    telefono: req.body.telefono,
    edad: req.body.edad,
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

app.put('/contactos/:id', (req, res) => {
  Contacto.findByIdAndUpdate(
    req.params.id,
    {
      $set: {
        nombre: req.body.nombre,
        telefono: req.body.telefono,
        edad: req.body.edad,
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

app.delete('/contactos/:id', (req, res) => {
  Contacto.findByIdAndRemove(req.params.id)
    .then((resultado) => {
      res.send({ error: false, resultado: resultado })
    })
    .catch((error) => {
      res.send({ error: true, mensajeError: 'Error eliminando contacto' })
    })
})

// run app
app.listen(3000)
