import express from 'express'

import { Book } from '../models/Book.js'

const router = express.Router()

// middleware
router.use((req, res, next) => {
  console.log({
    date: new Date().toString(),
    method: req.method,
    router: '/books',
    uri: req.url,
  })
  next()
})

// routes
router.get('/', function (req, res) {
  Book.find()
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.get('/:id', function (req, res) {
  Book.findById(req.params.id)
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.post('/', function (req, res) {
  let newBook = new Book({
    title: req.body.title,
    publisher: req.body.publisher,
    price: req.body.price,
    author: req.body.author,
    comments: req.body.comments,
  })

  newBook
    .save()
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.put('/:id', function (req, res) {
  Book.findByIdAndUpdate(
    req.params.id,
    {
      title: req.body.title,
      publisher: req.body.publisher,
      author: req.body.author,
      $push: { 'comments': req.body.comments }
    },
    { new: true }
  )
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.delete('/:id', function (req, res) {
  Book.findByIdAndDelete(req.params.id)
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

export { router as books }
