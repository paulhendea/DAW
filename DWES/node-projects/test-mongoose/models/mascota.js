import mongoose from 'mongoose'

// Schema
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
let Mascota = mongoose.model('mascota', mascotaSchema)

export { Mascota }
