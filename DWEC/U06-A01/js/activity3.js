Map.prototype.invertMap = function () {
  let invertedMap = new Map()
  for (let [key, value] of this.entries()) {
    if (invertedMap.has(value)) invertedMap.get(value).push(key)
    else invertedMap.set(value, [key])
  }
  return invertedMap
}

// Test
const MAP = new Map()
MAP.set(1, 'Optimal')
  .set(2, 'Noteworthy')
  .set(3, 'Noteworthy')
  .set(4, 'Excellent')
  .set(5, 'Improvable')
  .set(6, 'Excellent')
  .set(7, 'Noteworthy')
console.log(MAP.invertMap())