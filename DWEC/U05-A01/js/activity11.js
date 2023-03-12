const TEXT_COLOR = [
  '',
  'textBlue',
  'textGreen',
  'textRed',
  'textPurple',
  'textOrange',
  'textPink',
]
const SEPARATOR = '-'
const MINE = '*'
var board = []

function printBoard() {
  // prints the board to start the game
  // get the values or put default values instead
  let boardSize = Number(document.getElementById('boardSize').value) || 10
  let minesNumber = Number(document.getElementById('minesNumber').value) || 10

  // quick validation
  if (
    boardSize < 2 ||
    boardSize > 50 ||
    minesNumber < 1 ||
    minesNumber > 9999
  ) {
    document.getElementById('game').innerHTML = 'Bad configuration'
    return
  }
  if (boardSize * boardSize <= minesNumber) {
    document.getElementById('game').innerHTML = 'Bad configuration'
    return
  }

  // generate board
  newBoard(boardSize, minesNumber)

  // remove input form
  document.getElementById('input').remove()

  // create table
  let table = document.createElement('table')
  // prevent the contextmenu of right click to show on the board
  table.addEventListener('contextmenu', (e) => {
    e.preventDefault()
    return false
  })
  for (let row = 0; row < boardSize; row++) {
    let tableRow = document.createElement('tr')
    for (let col = 0; col < boardSize; col++) {
      let cell = document.createElement('td')
      cell.id = row + SEPARATOR + col
      cell.classList.add('green')
      cell.addEventListener('mousedown', (e) => {
        if (e.button === 0) revealSquare(row, col)
        else if (e.button === 2) tagSquare(row, col)
      })
      tableRow.appendChild(cell)
    }
    table.appendChild(tableRow)
  }
  // make sure game section is clean
  document.getElementById('game').innerHTML = ''
  document.getElementById('game').appendChild(table)
}

function newBoard(boardSize, minesNumber) {
  // creates the board
  board = get2DArray(boardSize)
  placeRandomMines(minesNumber)
  placeHintNumbers()
}

function tagSquare(row, col) {
  // tags a square
  // allow tag only on unchecked squares
  if (board[row][col] === 'revealed' || board[row][col] === 'checked') return

  let cell = document.getElementById(row + SEPARATOR + col)
  let cellText = cell.textContent
  if (cellText != '🚩') cell.innerHTML = '🚩'
  else cell.innerHTML = ''
}

function revealSquare(row, col) {
  // reveals the square clicked
  if (board[row][col] === MINE) gameOver()
  else if (!board[row][col]) clearArea([[row, col]])
  else if (board[row][col] != 'revealed') {
    let cell = document.getElementById(row + SEPARATOR + col)
    cell.classList.remove('green')
    cell.classList.add(TEXT_COLOR[board[row][col]])
    cell.innerHTML = board[row][col]
    board[row][col] = 'revealed'
  }

  if (isGameFinished()) finishGame()
}

function isGameFinished() {
  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[0].length; col++) {
      // if any square is different from revealed, checked or a mine the game is not finished
      if (
        board[row][col] != 'checked' &&
        board[row][col] != 'revealed' &&
        board[row][col] != MINE
      ) {
        return false
      }
    }
  }
  return true
}

function clearArea(area) {
  // recursive function to clean areas with empty squares

  // reveal squares on the board (including squares with numbers)
  for (let i in area) {
    let [row, col] = area[i]
    let cell = document.getElementById(row + SEPARATOR + col)
    if (board[row][col] && board[row][col] != 'revealed') {
      cell.classList.add(TEXT_COLOR[board[row][col]])
      cell.innerHTML = board[row][col]
      board[row][col] = 'revealed'
    }
    cell.classList.remove('green')
  }

  // filter squares that are not empty (squares with numbers)
  area = area.filter(isEmptySquare)
  if (area.length === 0) return

  // update board values to keep track of checked squares
  for (let i in area) {
    let [row, col] = area[i]
    board[row][col] = 'checked'
  }

  // expand selection
  newArea = []
  for (let i = 0; i < area.length; i++) {
    let [squareRow, squareCol] = area[i]
    let start = {
      row: squareRow - 1,
      col: squareCol - 1,
    }
    let end = {
      row: squareRow + 1,
      col: squareCol + 1,
    }

    for (let row = start['row']; row <= end['row']; row++) {
      for (let col = start['col']; col <= end['col']; col++) {
        let square = [row, col]
        // only save valid, non duplicate and non checked squares
        if (
          !isOutOfLimit(square) &&
          !isDuplicateSquare(newArea, square) &&
          !isCheckedSquare(square)
        )
          newArea.push(square)
      }
    }
  }

  clearArea(newArea)
}

function isDuplicateSquare(array, square) {
  // check if the square exists in the array
  for (let i in array) {
    let element = array[i]
    if (element[0] === square[0] && element[1] === square[1]) return true
  }
  return false
}

function isOutOfLimit(square) {
  // check if its out of limits
  if (
    square[0] < 0 ||
    square[1] < 0 ||
    square[0] >= board.length ||
    square[1] >= board.length
  ) {
    return true
  } else return false
}

function isCheckedSquare(square) {
  // check if the square is checked
  if (board[square[0]][square[1]] === 'checked') return true
  else return false
}

function isEmptySquare(square) {
  // check if its not empty
  if (board[square[0]][square[1]]) {
    return false
  } else return true
}

function finishGame() {
  console.log('game finished')
  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[0].length; col++) {
      // removes event listeners
      let cell = document.getElementById(row + SEPARATOR + col)
      cell.parentNode.replaceChild(cell.cloneNode(true), cell)
      // set color red if there is a mine
      if (board[row][col] === MINE) {
        let cell = document.getElementById(row + SEPARATOR + col)
        cell.classList.remove('green')
        cell.classList.add('blue')
        cell.innerHTML = '🙂'
      }
    }
  }
}

function gameOver() {
  console.log('game over')
  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[0].length; col++) {
      // removes event listeners
      let cell = document.getElementById(row + SEPARATOR + col)
      cell.parentNode.replaceChild(cell.cloneNode(true), cell)
      // set color red if there is a mine
      if (board[row][col] === MINE) {
        let cell = document.getElementById(row + SEPARATOR + col)
        cell.classList.remove('green')
        cell.classList.add('red')
      }
    }
  }
}

function get2DArray(size) {
  // return 2d array with specified size
  return [...Array(size)].map(() => Array(size))
}

function placeRandomMines(numberOfMines) {
  // places mines randomly on the board
  for (let i = 0; i < numberOfMines; i++) {
    let [row, col] = getRandomSquare()
    board[row][col] = MINE
  }
}

function placeHintNumbers() {
  // iterate the array
  for (let row = 0; row < board.length; row++) {
    for (let col = 0; col < board[row].length; col++) {
      // for every undefined cell set the value of the mines around
      if (!board[row][col]) board[row][col] = getMinesAround(row, col)
    }
  }
}

function getMinesAround(squareRow, squareCol) {
  // returns the number of mines around the given square
  // set start and end for check while checking the array limits
  start = {
    row: squareRow - 1 < 0 ? 0 : squareRow - 1,
    col: squareCol - 1 < 0 ? 0 : squareCol - 1,
  }
  end = {
    row: squareRow + 1 < board.length ? squareRow + 1 : squareRow,
    col: squareCol + 1 < board.length ? squareCol + 1 : squareCol,
  }

  // iterate the area and check
  let mines = 0
  for (let row = start.row; row <= end.row; row++) {
    for (let col = start.col; col <= end.col; col++) {
      if (board[row][col] === MINE) mines++
    }
  }

  return mines
}

function getRandomSquare() {
  // returns a random undefined square
  let row, col
  do {
    row = Math.floor(Math.random() * board.length)
    col = Math.floor(Math.random() * board[0].length)
  } while (board[row][col] != undefined)
  return [row, col]
}
