import { Chess } from './chess.js'
const chess = new Chess()

// declare constants
const COLUMNS = ['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h']
const ROWS = [1, 2, 3, 4, 5, 6, 7, 8].reverse()
const PIECES = {
  p: { w: 'p', b: 'o' },
  n: { w: 'n', b: 'm' },
  b: { w: 'b', b: 'v' },
  r: { w: 'r', b: 't' },
  q: { w: 'q', b: 'w' },
  k: { w: 'k', b: 'l' },
}
const FLAGS = {
  nonCapture: 'n',
  pawnPushTwoSquares: 'b',
  enPassantCapture: 'e',
  capture: 'c',
  promotion: 'p',
  kingSideCastling: 'k',
  queenSideCastling: '1',
}

// load audio
let moveAudio = new Audio('../audio/move.mp3')
let captureAudio = new Audio('../audio/capture.mp3')
let checkAudio = new Audio('../audio/check.mp3')

// function to update the board
function updateBoard() {
  // remove existing pieces
  $('.piece').remove()

  // add updated pieces
  chess.board().forEach((row) => {
    row.forEach((piece) => {
      // check for null
      if (piece === null) return

      let pieceCode = PIECES[piece.type][piece.color]
      let pieceElement = $('<div></div>').text(pieceCode)
      pieceElement.attr('position', piece.square)
      pieceElement.addClass('piece')
      // draggable event for pieces
      pieceElement.draggable({ revert: true, revertDuration: 0 })
      $(`#${piece.square}`).append(pieceElement)
    })
  })
}

// function to manage droppable squares
function squareEvent(event, ui) {
  // get the squares data
  let targetSquare = this.id
  let originalSquare = ui.draggable.attr('position')

  let moves = chess.moves({ verbose: true, square: originalSquare })
  console.log(moves)
  moves.forEach((availableMove) => {
    // check if the move is valid
    if (
      availableMove.from === originalSquare &&
      availableMove.to === targetSquare
    ) {
      // update the move in the chess.js apis
      chess.move({
        from: originalSquare,
        to: targetSquare,
        promotion: 'q',
      })

      // check captures
      let flags = availableMove.flags
      let isCapture = flags.includes(FLAGS.capture) || flags.includes(FLAGS.enPassantCapture)

      // play audio
      if (chess.isCheck()) checkAudio.play()
      else if (isCapture) captureAudio.play()
      else moveAudio.play()

      // update the board
      updateBoard()
    }
  })
}

// create the board
let board = $('<table></table>')
board.attr('id', 'board')

ROWS.forEach((rowNumber) => {
  let row = $('<tr></tr>')
  COLUMNS.forEach((columnLetter) => {
    let square = $('<td></td>')
    square.attr('id', columnLetter + rowNumber)
    // droppable event for squares
    square.droppable({
      drop: squareEvent,
      hoverClass: 'squareHover',
    })
    row.append(square)
  })
  board.append(row)
})
$('#main').append(board)

// start game and print initial position
updateBoard()
