var express = require('express')
var router = express.Router()
var os = require('os')
var mongoose = require('mongoose')

/* GET home page. */
router.get('/', function (req, res, next) {
  res.render('index', { title: 'Express' })
})

/* Exercise 1 */
router.get('/date', function (req, res, next) {
  let date = new Intl.DateTimeFormat('default', {
    year: 'numeric',
    month: 'numeric',
    day: 'numeric',
    hour: 'numeric',
    minute: 'numeric',
    second: 'numeric',
    hour12: false,
    timeZone: 'America/Los_Angeles',
  }).format(new Date())

  res.send({
    error: false,
    date: date,
  })
})

router.get('/user', function (req, res, next) {
  res.send({
    error: false,
    userInfo: os.userInfo().username,
  })
})

/* Exercise 2 */
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

router.get('/books', function (req, res) {
  Book.find()
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.get('/books/:id', function (req, res) {
  Book.findById(req.params.id)
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.post('/books', function (req, res) {
  let newBook = new Book({
    title: req.body.title,
    publisher: req.body.publisher,
    price: req.body.price,
  })

  newBook
    .save()
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.put('/books/:id', function (req, res) {
  Book.findByIdAndUpdate(
    req.params.id,
    {
      title: req.body.title,
      publisher: req.body.publisher,
      price: req.body.price,
    },
    { new: true }
  )
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.delete('/books/:id', function (req, res) {
  Book.findByIdAndDelete(req.params.id)
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

module.exports = router
