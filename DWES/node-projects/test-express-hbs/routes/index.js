var express = require('express')
var router = express.Router()

var multer = require('multer')
var storage = multer.diskStorage({
  destination: './public/images',
  filename: (req, file, cb) => {
    cb(null, `${Date.now()}-${file.originalname}`)
  },
})
var upload = multer({
  storage: storage,
})

var fs = require('fs')

/* GET home page. */
router.get('/', function (req, res, next) {
  var data = {
    title: 'Available articles now',
    articles: [
      { code: 1, price: 12, description: 'pear' },
      { code: 2, price: 132, description: 'apple' },
      { code: 3, price: 23, description: 'orange' },
    ],
    discount: { monday: '5%', tuesday: '10%' },
  }
  res.render('index', data)
})

router.get('/upload/image', function (req, res, next) {
  res.render('upload/image')
})

router.post('/upload/image', upload.array('image', 5), function (req, res, next) {
  var pagina =
    '<!doctype html><html><head></head><body>' +
    '<p>Se subieron las fotos</p>' +
    '<br><a href="/">Retornar</a></body></html>'
  res.send(pagina)
})

router.get('/image', function (req, res, next) {
  fs.readdir('./public/images/', function (err, files) {
    var pagina = '<!doctype html><html><head></head><body>'
    for (let x = 0; x < files.length; x++) {
      pagina += '<img src="images/' + files[x] + '" width="500px"><br>'
    }
    pagina += '<br><a href="/">Retornar</a></body></html>'
    res.send(pagina)
  })
})

router.get('/login', function (req, res, next) {
  res.render('login')
})

router.post('/login', function (req, res, next) {
  req.session.mail = req.body.mail

  res.send(
    '<!doctype html><html><head></head><body>' +
      '<p>Se creó la variable de sesión</p>' +
      '<p>Puede ingresar al panel de control:</p>' +
      '<a href="/panel">Ingresar</a><br>' +
      '</body></html>'
  )
})

router.get('/panel', function (req, res, next) {
  if (req.session.mail) {
    var pagina =
      '<!doctype html><html><head></head><body>' +
      '<p>Bienvenido</p>' +
      req.session.mail +
      '<br><a href="/logout">Logout</a></body></html>'
  } else {
    var pagina =
      '<!doctype html><html><head></head><body>' +
      '<p>No tiene permitido ingresar sin login</p>' +
      '<br><a href="/">Retornar</a></body></html>'
  }

  res.send(pagina)
})

router.get('/logout', function (req, res, next) {
  req.session.destroy()

  res.send(
    '<!doctype html><html><head></head><body>' +
      '<br><a href="/">Retornar</a></body></html>'
  )
})

module.exports = router
