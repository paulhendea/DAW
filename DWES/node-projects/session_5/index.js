import mongoose from 'mongoose'

// db config
mongoose.Promise = global.Promise
mongoose.set('strictQuery', true)
mongoose.connect('mongodb://127.0.0.1:27017/books')

// schema config
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
let Book = mongoose.model('books', bookSchema)

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

// add documents
// using async/await to make sure the authors are created first
async function addBooks() {
  // create authors
  let author1 = new Author({
    name: 'James Patterson',
    birthDate: 1947,
  })
  await author1
    .save()
    .then((result) => {
      console.log('Saved:', result)
      return result
    })
    .catch((error) => console.log(error))

  let author2 = new Author({
    name: 'Manel',
    birthDate: 2000,
  })
  await author2
    .save()
    .then((result) => {
      console.log('Saved:', result)
      return result
    })
    .catch((error) => console.log(error))

  let author3 = new Author({
    name: 'Juan Carlos',
    birthDate: 2000,
  })
  await author3
    .save()
    .then((result) => {
      console.log('Saved:', result)
      return result
    })
    .catch((error) => console.log(error))

  // create books
  let book1 = new Book({
    title: 'El capitán Alatriste',
    publisher: 'Alfaguara',
    price: 15,
    author: author1.id,
  })
    .save()
    .then((result) => console.log('Saved:', result))
    .catch((error) => console.error(error))

  let book2 = new Book({
    title: 'El juego de Ender',
    publisher: 'Ediciones B',
    price: 8.95,
    author: author2.id,
  })
    .save()
    .then((result) => console.log('Saved:', result))
    .catch((error) => console.error(error))

  let book3 = new Book({
    title: 'Book of the life',
    publisher: 'best publisher',
    price: 12,
    author: author2.id,
  })
    .save()
    .then((result) => console.log('Saved:', result))
    .catch((error) => console.error(error))

  // book with comments
  let book4 = new Book({
    title: 'Most popular book',
    publisher: 'Mars',
    price: 4.99,
    author: author3.id,
    comments: [
      {
        date: '2020-09-09',
        nick: 'paulhendea',
        comment: 'This book is awesome, congrats!',
      },
      {
        nick: 'manelator',
        comment: 'Nice',
      },
    ],
  })
    .save()
    .then((result) => console.log('Saved:', result))
    .catch((error) => console.error(error))
}
// addBooks()

// Select top 3 cheaper books
Book.find()
  .select('title price')
  .sort('price')
  .limit(3)
  .then((result) => console.log('Top 3 cheaper books:', result))
  .catch((error) => console.log(error))

// Select author names with books under 10$
Book.find({ price: { $lt: 10 } }).then((result) => {
  let authorsWithBooksUnder10 = result.map((book) => book.author)
  Author.find({ _id: { $in: authorsWithBooksUnder10 } })
    .select('-_id name')
    .then((result) => console.log('Authors with books under 10$:', result))
    .catch((error) => console.log(error))
})
