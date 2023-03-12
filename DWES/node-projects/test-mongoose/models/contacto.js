import mongoose from 'mongoose'

// schema
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
  restauranteFavorito: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'restaurante',
  },
  mascotas: [
    {
      type: mongoose.Schema.Types.ObjectId,
      ref: 'mascota',
    },
  ],
})
let Contacto = mongoose.model('contacto', contactoSchema)

export { Contacto }
