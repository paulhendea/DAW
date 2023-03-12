// TODO how to make constructor params mandatory? 
class Computer {
  brand
  model
  ram
  storage
  screenInches

  constructor(brand, model, ram = 4, storage = 512, screenInches = 17) {
    this.brand = brand
    this.model = model
    this.ram = isNaN(ram) ? 4 : +ram
    this.storage = isNaN(storage) ? 521 : +storage
    this.screenInches = isNaN(screenInches) ? 17 : +screenInches
  }

  toString() {
    return JSON.stringify(this, null, 2)
  }
}

class Laptop extends Computer {
  autonomy

  constructor(brand, model, ram = 4, storage = 256, screenInches = 12, autonomy = 4) {
    super(brand, model, ram, storage, screenInches)
    this.autonomy = isNaN(autonomy) ? 4 : +autonomy
  }

  toString() {
    return JSON.stringify(this, null, 2)
  }
}

// Test
let computer = new Computer('Gigabyte', '5234')
console.log(computer.toString())
let laptop = new Laptop('Apple', 'MacBook')
console.log(laptop.toString())
