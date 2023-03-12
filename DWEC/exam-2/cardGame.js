function Card(suit, value) {
  // attributes
  const SUIT = ['hearts', 'clovers', 'diamonds', 'spades']
  this.suit = +suit
  this.value = +value

  // methods
  this.toString = () => {
    // translate suit
    let suit = SUIT[this.suit]

    // translate value
    let value = this.value
    switch (value) {
      case 1:
        value = 'Ace'
        break
      case 11:
        value = 'Jack'
        break
      case 12:
        value = 'Queen'
        break
      case 13:
        value = 'King'
    }

    return `${value} of ${suit}`
  }
}

function Deck() {
  // constructor function
  this.getDeck = () => {
    let cards = []
    for (let i = 0; i <= 3; i++) {
      for (let j = 1; j <= 13; j++) {
        cards.push(new Card(i, j))
      }
    }
    return cards
  }
  // attributes
  this.cards = this.getDeck()

  // methods
  this.shuffle = () => {
    // return a random number between -1,1 in order to sort randomly
    this.cards.sort((a, b) => Math.floor(Math.random() * 3) - 1)
  }

  this.getCard = () => {
    // returns a card from the deck while removing it
    return this.cards.pop()
  }

  this.toString = () => {
    return this.cards.join('\n')
  }
}

// add reset function to Deck prototype
Deck.prototype.resetCards = function () {
    this.cards = this.getDeck()
}

function Player(name, email, birthDate) {
  // validation
  if (!name) return null
  if (!/^\w+\@\w+\.\w{2,3}$/.test(email)) return null
  function getAge(birthDate) {
    // substract the birth date to the actual 
    let yearsOld = new Date(Date.now() - birthDate.getTime())
    // take in count that js dates start in 1970
    return yearsOld.getFullYear() - 1970
  }
  birthDate = new Date(Date.parse(birthDate))
  if (getAge(birthDate) < 18) return null

  // attributes
  this.name = name
  this.email = email
  this.birthDate = birthDate
  this.hand = []

  // methods
  this.addCard = (card) => {
    this.hand.push(card)
  }

  this.dropCard = () => {
    return this.hand.pop()
  }

  this.toString = () => {
    return `name: ${this.name} \nage: ${getAge(this.birthDate)} \nemail: ${this.email}`
  }
}

// game testing :)

// create deck and shuffle
let deck = new Deck()
deck.shuffle()
console.log('Deck\n----------------')
console.log(deck + '\n')

// create player, show info and add some cards to his hand
let player = new Player('Paul', 'paul@email.com', '09-09-1999')
console.log('Player\n----------------')
console.log(player + '\n')
for (let i = 0; i < 5; i++) {
  let card = deck.getCard()
  console.log(`Adding ${card}`)
  player.addCard(card)
}
console.log('\n')

// drop some cards
for (let i = 0; i < 3; i++) {
  let card = player.dropCard()
  console.log(`Dropping ${card}`)
}
console.log('\n')

// show actual deck
console.log('Deck current state\n----------------')
console.log(deck + '\n')

// reset deck and show again
deck.resetCards()
console.log('Deck after reset\n----------------')
console.log(deck + '\n')