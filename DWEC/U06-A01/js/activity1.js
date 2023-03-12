// constructor function
class Point {
  constructor(x, y = 0) {
    // attributes
    this.x = typeof x != 'number' ? 0 : x
    this.y = typeof y != 'number' ? 0 : y

    // methods
    this.change = (x, y) => {
      this.x = typeof x != 'number' ? this.x : x
      this.y = typeof y != 'number' ? this.y : y
    }

    this.copy = () => new Point(this.x, this.y)

    this.equals = (pointB) => this.x === pointB.x && this.y === pointB.y

    this.addition = (pointB) => {
      let x = this.x + pointB.x
      let y = this.y + pointB.y
      return new Point(x, y)
    }

    this.getDistance = (pointB) => {
      let horizontalDistance = Math.abs(this.x - pointB.x)
      let verticalDistance = Math.abs(this.y - pointB.y)
      return Math.sqrt(horizontalDistance ** 2 + verticalDistance ** 2)
    }

    this.toString = () => `(${this.x},${this.y})`
  }
}

// tests
let a = new Point(true, 'hi')
let b = new Point(-15, 4)
console.log(`Point a -> ${a}`)
console.log(`Point b -> ${b}`)

a.change(5, 1)
console.log(`Changing point a -> ${a}`)

let aClone = a.copy()
console.log(`Copying point a -> ${aClone}`)
console.log(`a === aClone -> ${a.equals(aClone)}`)
console.log(`a === b -> ${a.equals(b)}`)
console.log(`Adding b to a -> ${a.addition(b)}`)
console.log(`Distance from ${a} to ${b} = ${a.getDistance(b)}`)
