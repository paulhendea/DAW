// libraries
import mongoose from 'mongoose'
import express from 'express'
import bodyParser from 'body-parser'

// routers
import { mascotas } from './routes/mascotas.js'
import { restaurantes } from './routes/restaurantes.js'
import { contactos } from './routes/contactos.js'

// db config
mongoose.Promise = global.Promise
mongoose.connect('mongodb://127.0.0.1:27017/contactos')

let app = express()

// load middleware and routers
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))
app.use('/mascotas', mascotas)
app.use('/restaurantes', restaurantes)
app.use('/contactos', contactos)

// run app
app.listen(3000)
