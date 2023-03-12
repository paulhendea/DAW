const mongoose = require('mongoose')

let participanteSchema = new mongoose.Schema({
  dorsal: Number,
  nombre: String,
  apellidos: String,
  fechaNacimiento: Date,
  categoria: mongoose.Schema.Types.ObjectId,
})

let Participante = mongoose.model('participantes', participanteSchema)

module.exports = Participante
