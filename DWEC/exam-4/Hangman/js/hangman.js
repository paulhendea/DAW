class Hangman {
  // attributes
  AVAILABLE_STATES = { inProgress: 'inProgress', won: 'won', failed: 'failed' }
  state = ''
  sentence = []
  sentenceProgress = []
  testedLetters = []
  remainingTries = 3

  // constructor
  constructor(sentence) {
    // set sentence
    this.sentence = [...sentence.toLowerCase()]

    // loop the sentence and fill the progress with * or spaces
    for (let i = 0; i < sentence.length; i++) {
      if (sentence[i] === ' ') this.sentenceProgress[i] = ' '
      else this.sentenceProgress[i] = '*'
    }

    // set game state
    this.state = this.AVAILABLE_STATES.inProgress
  }

  // methods
  get getSentenceProgress() {
    return this.sentenceProgress.join('')
  }

  checkLetter(letter) {
    // check game state
    if (this.state != this.AVAILABLE_STATES.inProgress) return null

    // check if the letter was already tested and add it to tested letters
    if (this.testedLetters.includes(letter)) return this.getSentenceProgress
    this.testedLetters.push(letter)

    // if the given letter is not in the sentence return the progress unchanged
    if (!this.sentence.includes(letter)) {
      // if there is no more tries set to failed
      this.remainingTries--
      if (this.remainingTries <= 0) this.state = this.AVAILABLE_STATES.failed
      return this.getSentenceProgress
    }

    // else reveal the progress and return
    for (let i = 0; i < this.sentence.length; i++) {
      if (this.sentence[i] === letter) this.sentenceProgress[i] = letter
    }

    // if there is no more * change state to won
    if (!this.sentenceProgress.includes('*'))
      this.state = this.AVAILABLE_STATES.won

    return this.getSentenceProgress
  }

  toString() {
    // return a message with the state of the game
    let response = ''
    switch (this.state) {
      case this.AVAILABLE_STATES.inProgress:
        response = `Remaining tries: ${this.remainingTries}`
        break
      case this.AVAILABLE_STATES.won:
        response = 'Great job! You did it! :)'
        break
      case this.AVAILABLE_STATES.failed:
        response = `Nice try! The sentence was "${this.sentence.join('')}"`
        break
      default:
        response = 'Something went wrong... :('
    }

    return response
  }
}

// words of the puzzle
const WORD_COUNT = 6

fetch(`https://puzzle.mead.io/puzzle?wordCount=${WORD_COUNT}`)
  .then((response) => response.json())
  .then((result) => {
    console.log(result.puzzle)

    // start the game
    let hangman = new Hangman(result.puzzle)

    // print initial data
    let sentence = document.getElementById('sentence')
    // clear sentence content
    sentence.innerHTML = ''
    // fill with characters
    let progress = hangman.getSentenceProgress
    for (let i = 0; i < progress.length; i++) {
      let span = document.createElement('span')
      span.textContent = progress[i]
      sentence.append(span)
    }

    let tries = document.getElementById('tries')
    tries.textContent = hangman

    // set event listeners
    let reloadButton = document.getElementById('reload')
    reloadButton.addEventListener('click', (event) => {
      // get a new sentence and reset the game
      fetch(`https://puzzle.mead.io/puzzle?wordCount=${WORD_COUNT}`)
        .then((response) => response.json())
        .then((result) => {
          console.log(result.puzzle)

          // create a new game
          hangman = new Hangman(result.puzzle)

          // reset info
          // clear sentence content
          sentence.innerHTML = ''
          // fill with characters
          let progress = hangman.getSentenceProgress
          for (let i = 0; i < progress.length; i++) {
            let span = document.createElement('span')
            span.textContent = progress[i]
            sentence.append(span)
          }
          tries.textContent = hangman
        })
        .catch((error) => console.log(error))
    })

    document.addEventListener('keydown', (event) => {
      let key = event.key

      // if the key is not a letter ignore
      if (!/^\w$/.test(key)) return

      // make a try
      let progress = hangman.checkLetter(key)
      if (progress != null) {
        // clear sentence content
        sentence.innerHTML = ''
        // fill with characters
        let progress = hangman.getSentenceProgress
        for (let i = 0; i < progress.length; i++) {
          let span = document.createElement('span')
          span.textContent = progress[i]
          sentence.append(span)
        }
        tries.textContent = hangman
      }
    })
  })
  .catch((error) => console.log(error))
