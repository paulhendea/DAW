const COL_NAMES = ['1','2','3','4','5','6','7','8','9','10'];
const ROW_NAMES = ['A','B','C','D','E','F','G','H','I','J'];
const SHIPS = [4,3,3,3,2,2,2,1,1];

// the object board will be used to represent the board and pieces
// multidimensional array of 10 by 10
// 0 for empty 1 there is a piece :)
var board = [...Array(10)].map(() => Array(10).fill(0));

// print the board
printBoard();

function printBoard() {
  generateRandomBoard();

  // create a table of 10x10
  let table = document.createElement('table');
  // create rows
  for (let i = 0; i < 10; i++) {
    let row = document.createElement('tr');
    // create cells
    for (let j = 0; j < 10; j++) {
      let cell = document.createElement('td');
      cell.innerHTML =  `<p class="tag">${ROW_NAMES[j] + COL_NAMES[i]}</p>`;
      if (board[i][j]) cell.setAttribute('class', 'dark');
      row.appendChild(cell);
    }
    table.appendChild(row);
  }
  document.getElementById('board').append(table);
}

function generateRandomBoard() {
  // for every battle ship get a random location
  for (let i = 0; i < SHIPS.length; i++) {
    let randomSquare = getRandomSquare();
    let pieceLocation = getValidLocation(randomSquare, SHIPS[i]);
    // if no location is available for this random square keep searching
    if (pieceLocation === null) {
      i--;
      continue;
    }

    // else put the piece on the board
    putPiece(pieceLocation);
  }
}

function putPiece(piece) {
  // get start and end coordinates
  let [start, end] = [...piece];

  let squares = [];
  // fill squares array with all the squares between start and end
  // in case the piece is 1x1
  if (start[0] === end[0] && start[1] === end[1]) {
    squares.push(start);
  }
  // in case the piece is vertical
  else if (start[0] === end[0]) {
    for (let i = start[1]; i <= end[1]; i++) {
      squares.push([start[0], i]);
    }
  }
  else {
    // in case the piece is horizontal
    for (let i = start[0]; i <= end[0]; i++) {
      squares.push([i, start[1]]);
    }
  }

  // set board values for the piece
  for (let square of squares) {
    board[square[0]][square[1]] = 1;
  } 
}

function getRandomSquare() {
  // returns a random square 
   let column = Math.floor(Math.random() * 10);
   let row = Math.floor(Math.random() * 10);
   return [column, row];
}

function getValidLocation(square, length) {
  // calculate all possible positions
  let pieceEnds = [
    getTop(square, length),
    getBottom(square, length),
    getLeft(square, length),
    getRight(square, length)
  ];

  let availablePieceEnds = [];
  // get all available positions
  for (let pieceEnd of pieceEnds) {
    if (isAvailable(square, pieceEnd)) 
    availablePieceEnds.push(pieceEnd);
  }

  // if there are no available positions for the piece return null
  if (availablePieceEnds.length === 0) return null;
  else {
    // return random available position
    let random = Math.floor(Math.random() * availablePieceEnds.length);
    let randomLocation = [square, availablePieceEnds[random]];
    return orderCoordinates(...randomLocation);
  }
}

/*
* FUNCTIONS TO GET START/END COORDINATES IN EVERY DIRECTION
* FROM RANDOM SQUARE AND PIECE LENGTH
*/
function getTop(square, length) {
  let column = square[0] - length +1;
  return [column, square[1]];
}

function getBottom(square, length) {
  let column = square[0] + length -1;
  return [column, square[1]];
}

function getLeft(square, length) {
  let row = square[1] - length +1;
  return [square[0], row];
}

function getRight(square, length) {
  let row = square[1] + length -1;
  return [square[0], row];
}

function isAvailable(squareA, squareB) {
  // check if its valid
  if (!isValid(squareA) || !isValid(squareB)) return false;

  // put the coordinates in order, start is top left
  let [start, end] = orderCoordinates(squareA, squareB);

  // increment the range to search in order to check the space around
  start = [start[0] -1, start[1] -1];
  end = [end[0] +1, end[1] +1]

  // if values go out of the limit correct them
  start[0] = start[0] >= 0 ? start[0] : 0;
  start[1] = start[1] >= 0 ? start[1] : 0;
  end[0] = end[0] <= 9 ? end[0] : 9;
  end[1] = end[1] <= 9 ? end[1] : 9;

  // check availability
  for (let i = start[0]; i <= end[0]; i++) {
    for (let j = start[1]; j <= end[1]; j++) {
      if (board[i][j]) return false;
    }
  }

  // if everything went ok :)
  return true;

}

function orderCoordinates(squareA, squareB) {
  // returns a new array with the first coordinate on top left
  let start = [];
  let end = [];
  if (squareA[0] >= squareB[0] && squareA[1] >= squareB[1]) {
    [start, end] = [[...squareB], [...squareA]];
  }
  else {
    [start, end] = [[...squareA], [...squareB]];
  }
  return [start, end];
}

function isValid(square) {
  let column = square[0];
  let row = square[1];
  
  // check if the coordinates are out of limit
  if (
    column < 0 ||
    column > 9 ||
    row < 0 ||
    row > 9
  ) return false;

  // if everything went ok :)
  return true;  
}