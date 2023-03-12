var mysql = require('mysql')

var connection = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: '',
  database: 'articles',
})

connection.connect(function (error) {
  if (error)
    console.log(error)
  else 
    console.log('Connected successfully! :)')
})

module.exports = connection