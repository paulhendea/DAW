import mongoose from 'mongoose'

// db config
mongoose.Promise = global.Promise
mongoose.set('strictQuery', true)
mongoose.connect('mongodb://127.0.0.1:27017/contacts')

// schema config
let contactSchema = new mongoose.Schema({
  name: {
    type: String,
    required: true,
    minLength: 1,
    trim: true,
  },
  telephone: {
    type: String,
    required: true,
    unique: true,
    trim: true,
    match: /^\d{9}$/,
  },
  age: {
    type: Number,
    min: 18,
    max: 120,
  },
})
let Contact = mongoose.model('contacts', contactSchema)

// add one contact
let contact1 = new Contact({
  name: 'Paul',
  telephone: '627849111',
  age: 23,
})
contact1
  .save()
  .then((result) => console.log('Contact saved:', result))
  .catch((error) => console.log('Error:', error))

let contact2 = new Contact({
  name: 'Alejandro',
  telephone: '123456789',
  age: 20,
})
contact2
  .save()
  .then((result) => console.log('Contact saved:', result))
  .catch((error) => console.log('Error:', error))

// find contacts
Contact.findByIdAndUpdate(
  '6398a852b57a879199fa32d7', 
  { 
    $set: { name: 'Paul Hendea' },
    $inc: { __v: 1 },
  },
  { new: true },
).then((result) => console.log(result))
  .catch((error) => console.error(error))
