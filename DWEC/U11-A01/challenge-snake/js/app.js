const canvas = document.getElementById('snake')
const ctx = canvas.getContext('2d')

// create the unit
const UNIT = 32
const BOARD = {
  marginLeft: UNIT,
  marginTop: 3 * UNIT,
  marginRight: UNIT,
  marginBottom: UNIT,
  width: 17 * UNIT,
  height: 15 * UNIT,
}

// load images
const boardImg = new Image()
boardImg.src = 'img/ground.png'

const foodImg = new Image()
foodImg.src = 'img/food.png'

// load audio files
const deadAudio = new Audio('audio/dead.mp3')
const eatAudio = new Audio('audio/eat.mp3')
const upAudio = new Audio('audio/up.mp3')
const rightAudio = new Audio('audio/right.mp3')
const leftAudio = new Audio('audio/left.mp3')
const downAudio = new Audio('audio/down.mp3')

// deadAudio.src = 'audio/dead.mp3'
// eatAudio.src = 'audio/eat.mp3'
// upAudio.src = 'audio/up.mp3'
// rightAudio.src = 'audio/right.mp3'
// leftAudio.src = 'audio/left.mp3'
// downAudio.src = 'audio/down.mp3'

// create the snake
let snake = []

snake[0] = {
  x: 9 * UNIT,
  y: 10 * UNIT,
}

// create the food
let food = {
  x: Math.floor(Math.random() * 17 + 1) * UNIT,
  y: Math.floor(Math.random() * 15 + 3) * UNIT,
}

// create the score var
let score = 0

//control the snake
const DIRECTIONS = {
  left: { keys: ['a', 'A', 'ArrowLeft'], value: 'LEFT' },
  up: { keys: ['w', 'W', 'ArrowUp'], value: 'UP' },
  right: { keys: ['d', 'D', 'ArrowRight'], value: 'RIGHT' },
  down: { keys: ['s', 'S', 'ArrowDown'], value: 'DOWN' },
}
let direction = ''

document.addEventListener('keydown', (event) => {
  let key = event.key
  if (DIRECTIONS.left.keys.includes(key) && direction != DIRECTIONS.right.value) {
    direction = DIRECTIONS.left.value
    leftAudio.play()
  } else if (DIRECTIONS.up.keys.includes(key) && direction != DIRECTIONS.down.value) {
    direction = DIRECTIONS.up.value
    upAudio.play()
  } else if (DIRECTIONS.right.keys.includes(key) && direction != DIRECTIONS.left.value) {
    direction = DIRECTIONS.right.value
    rightAudio.play()
  } else if (DIRECTIONS.down.keys.includes(key) && direction != DIRECTIONS.up.value) {
    direction = DIRECTIONS.down.value
    downAudio.play()
  }
})

// check collision function
function collision(snakeHead, snakeBody = []) {
  return snakeBody.some(
    (bodyPart) => snakeHead.x === bodyPart.x && snakeHead.y === bodyPart.y
  )
}

// draw everything to the canvas
function draw() {
  // draw board
  ctx.drawImage(boardImg, 0, 0)

  // draw snake body
  snake.forEach((bodyPart, position) => {
    ctx.fillStyle = position === 0 ? 'green' : 'white'
    ctx.fillRect(bodyPart.x, bodyPart.y, UNIT, UNIT)

    ctx.strokeStyle = 'red'
    ctx.strokeRect(bodyPart.x, bodyPart.y, UNIT, UNIT)
  })

  // draw food
  ctx.drawImage(foodImg, food.x, food.y)

  // old head position
  let snakeHead = { ...snake[0] }

  // which direction
  if (direction == DIRECTIONS.left.value)
    snakeHead.x -= UNIT

  if (direction == DIRECTIONS.up.value)
    snakeHead.y -= UNIT

  if (direction == DIRECTIONS.right.value)
    snakeHead.x += UNIT

  if (direction == DIRECTIONS.down.value)
    snakeHead.y += UNIT

  // if the snake eats the food
  if (snakeHead.x === food.x && snakeHead.y === food.y) {
    score++
    eatAudio.play()
    food = {
      x: Math.floor(Math.random() * 17 + 1) * UNIT,
      y: Math.floor(Math.random() * 15 + 3) * UNIT,
    }
    // we don't remove the tail
  } else {
    // remove the tail
    snake.pop()
  }

  // check for collisions
  if (
    snakeHead.x < BOARD.marginLeft ||
    snakeHead.x >= BOARD.marginLeft + BOARD.width ||
    snakeHead.y < BOARD.marginTop ||
    snakeHead.y >= BOARD.marginTop + BOARD.height ||
    collision(snakeHead, snake)
  ) {
    // stop the game
    deadAudio.play()
    return false
  }

  // add new head
  snake.unshift(snakeHead)

  // print score
  ctx.fillStyle = 'white'
  ctx.font = '45px Changa one'
  ctx.fillText(score, 2 * UNIT, 1.6 * UNIT)

  // if the game continues return true
  return true
}

// call draw function every 100 ms
let game = setInterval(() => {
  if (!draw()) clearInterval(game)
}, 100)
