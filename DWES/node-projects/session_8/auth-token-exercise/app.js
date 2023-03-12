const express = require('express')
const bodyParser = require('body-parser')
const jwt = require('jsonwebtoken')

let usuarios = [
  { login: 'nacho', password: '1234' },
  { login: 'arturo', password: '5678' },
]

// generar Token
const secreto = 'secretoNode'
let generarToken = (login) => {
  return jwt.sign({ login }, secreto, { expiresIn: '2 hours' })
}

// middleware and settings
let app = express()
app.set('view engine', 'ejs')
app.use('/public', express.static('./public'))
app.use(bodyParser.json())

// routes
app.get('/', (req, res) => {
  res.render('index')
})

app.get('/inicio', (req, res) => {
  res.render('inicio')
})

app.get('/login', (req, res) => {
  res.render('login')
})

app.post('/login', (req, res) => {
  let usuario = usuarios.filter((usuario) => {
    return usuario.login == req.body.login && usuario.password == req.body.password
  })
  console.log('login post 1')
  if (usuario.length == 1) {
    res.send({ error: false, token: generarToken(req.body.login) })
  } else res.send({ error: true })
})

let validarToken = (token) => {
  try {
    let resultado = jwt.verify(token, secreto)
    return resultado
  } catch (error) {
    return false
  }
}

let protegerRuta = (req, res, next) => {
  let token = req.headers['authorization']
  console.log('TOKEN=' + token)
  if (validarToken(token)) {
    next()
  } else {
    res.render('login')
  }
}

app.get('/protegido', protegerRuta, (req, res) => {
  res.render('protegido')
})

// run app
app.listen(8080)
