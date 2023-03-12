import express from 'express'

import { Author } from '../models/Author.js'

const router = express.Router()

// routes
router.get('/', function (req, res) {
  Author.find()
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.get('/:id', function (req, res) {
  Author.findById(req.params.id)
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.post('/', function (req, res) {
  let newAuthor = new Author({
    name: req.body.name,
    birthDate: req.body.birthDate,
  })

  newAuthor
    .save()
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.put('/:id', function (req, res) {
  Author.findByIdAndUpdate(
    req.params.id,
    {
      name: req.body.name,
      birthDate: req.body.birthDate,
    },
    { new: true }
  )
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

router.delete('/:id', function (req, res) {
  Author.findByIdAndDelete(req.params.id)
    .then((result) => res.send({ result }))
    .catch((error) => res.send({ error }))
})

export { router as authors }
