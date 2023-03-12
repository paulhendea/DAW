const mongoose = require('mongoose')

let categoriaSchema = new mongoose.Schema({
  codigo: String,
  descripcion: String,
  minEdad: Number,
  maxEdad: Number,
})

let Categoria = mongoose.model('categorias', categoriaSchema)

module.exports = Categoria
