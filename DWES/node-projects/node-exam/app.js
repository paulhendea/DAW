// libraries
const express = require('express')
const mongoose = require('mongoose')
const bodyParser = require('body-parser')

// routers
const index = require(__dirname + '/routes/index')
const categorias = require(__dirname + '/routes/categorias')
const participantes = require(__dirname + '/routes/participantes')

// db config
mongoose.Promise = global.Promise
mongoose.set('strictQuery', true)
mongoose.connect('mongodb://127.0.0.1:27017/carreras')

let app = express()

// middleware and routes
app.set('view engine', 'ejs')
app.use('/public', express.static(__dirname + '/public'))
app.use(bodyParser.json())
app.use(bodyParser.urlencoded())
app.use('/', index)
app.use('/categorias', categorias)
app.use('/participantes', participantes)


// run app
app.listen(8080)
