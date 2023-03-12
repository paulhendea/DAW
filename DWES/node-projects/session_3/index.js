import mongoose from "mongoose"

// db config
mongoose.Promise = global.Promise
mongoose.set('strictQuery', true)
mongoose.connect('mongodb://127.0.0.1:27017/books')

// schema config
let bookSchema = new mongoose.Schema({
  title: {
    type: String,
    required: true,
    minLength: 3,
    trim: true,
  },
  publisher: {
    type: String,
    trim: true,
  },
  price: {
    type: Number,
    required: true,
    min: 0,
  },
})
let Book = mongoose.model('books', bookSchema)

// add books
let book1 = new Book({
  title: 'El capitán Alatriste',
  publisher: 'Alfaguara',
  price: 15,
})
book1.save()
  .then(result => console.log('Saved:', result))
  .catch(error => console.error(error))

let book2 = new Book({
  title: 'El juego de Ender',
  publisher: 'Ediciones B',
  price: 8.95,
})
book2.save()
  .then(result => console.log('Saved:', result))
  .catch(error => console.error(error))

let book3 = new Book({
  title: 'A',
  price: 12,
})
book3.save()
  .then(result => console.log('Saved:', result))
  .catch(error => console.error(error))

// find books
Book.find({ price: {$gte: 10, $lte: 20} })
  .then(result => console.log('Books between 10€ and 20€:', result))
  .catch(error => console.error(error))

Book.findById('6398af57ac61a4ea9a3980af')
  .then(result => console.log('Found by Id:', result))
  .catch(error => console.error(error))

// remove books
Book.findByIdAndRemove('6398af57ac61a4ea9a3980af')
  .then(result => console.log('Book deleted by Id:', result))
  .catch(error => console.error(error))

// update books
Book.findByIdAndUpdate(
  '6398af57ac61a4ea9a3980ae',
  { 
    $set: { price: 19.99 },
    $inc: { __v: 1 },
  },
  { new: true },
).then(result => console.log('Book updated by Id:', result))
  .catch(error => console.error(error))