const mongoose = require('mongoose')

let tareaSchema = new mongoose.Schema({
  titulo: {
    type: String,
    minlength: 1,
    required: true,
    trim: true,
  },
  fecha: {
    type: Date,
    default: Date.now(),
    required: true,
  },
  prioridad: {
    type: Number,
    required: true,
    min: 0,
    max: 2,
  },
})

let Tarea = mongoose.model('tarea', tareaSchema)

module.exports = Tarea
