// libraries
const express = require('express')
const mongoose = require('mongoose')
const bodyParser = require('body-parser')

// routers
const tareas = require(__dirname + '/routes/tareas')
const index = require(__dirname + '/routes/index')

// db config
mongoose.Promise = global.Promise
mongoose.connect('mongodb://127.0.0.1:27017/tareas')

let app = express()

// middleware and routes
app.set('view engine', 'ejs')
app.use('/public', express.static(__dirname + '/public'))
app.use(bodyParser.json())
app.use('/', index)
app.use('/tareas', tareas)

// run app
app.listen(8080)
