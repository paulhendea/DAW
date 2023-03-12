import mongoose from 'mongoose'

// comment schema
let commentSchema = new mongoose.Schema({
  date: {
    type: Date,
    default: Date.now(),
    required: true,
  },
  nick: {
    type: String,
    required: true,
  },
  comment: {
    type: String,
    required: true,
    trim: true,
  },
})
// book schema
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
  author: {
    type: mongoose.Schema.Types.ObjectId,
    ref: 'authors',
  },
  comments: [commentSchema],
})
// Model
let Book = mongoose.model('books', bookSchema)

export { Book }
