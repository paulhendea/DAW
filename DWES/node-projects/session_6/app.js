// libraries
import express from 'express'
import mongoose from 'mongoose'
import bodyParser from 'body-parser'

// routers
import { books } from './routes/books.js'
import { authors } from './routes/authors.js'

// db config
mongoose.Promise = global.Promise
mongoose.set('strictQuery', true)
mongoose.connect('mongodb://127.0.0.1:27017/books')

const app = express()

// middleware and routes
// app.use((req, res, next) => res.send({ message: 'currently unavailable by maintenance' })) /* UNCOMMENT FOR MAINTENENCE */
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))
app.use('/books', books)
app.use('/authors', authors)

// run app
app.listen(3000)
