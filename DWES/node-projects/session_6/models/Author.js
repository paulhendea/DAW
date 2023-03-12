import mongoose from 'mongoose'

// Schema
let authorSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    trim: true,
  },
  birthDate: {
    type: Number,
    min: 0,
    max: 2000,
  },
})
let Author = mongoose.model('authors', authorSchema)

export { Author }
