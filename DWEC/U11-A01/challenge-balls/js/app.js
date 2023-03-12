class Ball {
  // attributes
  position = { x: 0, y: 0 }
  direction = { x: 0, y: 0 }
  size = 3
  color

  // constructor
  constructor(canvasWidth, canvasHeight) {
    this.position = {
      x: Math.round(canvasWidth / 2),
      y: Math.round(canvasHeight / 2),
    }
    this.direction = this.randomDirection()
    this.color = this.randomColor()
  }

  // methods
  randomDirection() {
    // give random direction between -3 and 3
    let direction = {
      x: Math.random() * 10 - 5,
      y: Math.random() * 10 - 5,
    }

    // if both x and y are 0 return a new random direction
    if (!direction.x && !direction.y) return this.randomDirection()
    
    return direction
  }
  updatePosition(canvasWidth, canvasHeight) {
    // update positions
    this.position.x += this.direction.x
    this.position.y += this.direction.y

    // check for borders
    if (this.position.x < 0 || this.position.x > canvasWidth) {
      // on collision change direction and add some randomness (-0.5 / 0.5)
      this.direction.x = this.direction.x * -1 + (Math.random() - 0.5)
      // if the opposite axe is 0, change it a little also
      if (this.direction.y === 0) this.direction.y = Math.random() * 0.2 - 0.1

      // finally update position
      this.position.x += this.direction.x
    }

    // same for the opposite axe
    if (this.position.y < 0 || this.position.y > canvasHeight) {
      this.direction.y = this.direction.y * -1 + (Math.random() - 0.5)
      if (this.direction.x === 0) this.direction.x = Math.random() * 0.2 - 0.1
      this.position.y += this.direction.y
    }
  }
  randomColor() {
    // give random color
    return '#' + Math.round(Math.random() * 0xffffff).toString(16)
  }
  draw(context) {
    context.beginPath()
    context.fillStyle = this.color
    context.arc(this.position.x, this.position.y, this.size, 0, 2 * Math.PI)
    context.fill()
  }
}

class Board {
  // attributes
  width = 0
  height = 0
  balls = []

  // constructor
  constructor(context, ballNumber) {
    this.width = context.canvas.clientWidth
    this.height = context.canvas.clientHeight
    // create balls
    for (let i = 0; i < ballNumber; i++) {
      this.balls.push(new Ball(this.width, this.height))
    }
  }

  // methods
  draw(context) {
    // clear canvas
    context.clearRect(0, 0, this.width, this.height)

    // draw balls
    this.balls.forEach((ball) => {
      ball.draw(context)
      ball.updatePosition(this.width, this.height)
    })
  }
}

const main = document.getElementById('main')
const canvas = document.getElementById('canvas')
// set canvas width and leave a little margin
canvas.width = main.clientWidth - 50
canvas.height = main.clientHeight - 50

// get context and board with 100 balls
const context = canvas.getContext('2d')
const board = new Board(context, 100)

// make them bounce
setInterval(() => {
  requestAnimationFrame(() => board.draw(context))
}, 10)
