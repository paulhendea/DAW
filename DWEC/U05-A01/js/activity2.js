function reset() {
  document.getElementById('response').innerHTML = ''
}

function print() {
  let rows = document.getElementById('row').value
  let cols = document.getElementById('cols').value
  let color = document.getElementById('color').value

  // quick validate
  rows = rows ? rows : undefined
  cols = cols ? cols : undefined
  color = color ? color : undefined

  printTable(rows, cols, color)
}

function printTable(rows = 10, cols = 4, color = 'black') {
  // get the table
  let table = document.createElement('table')
  table.setAttribute('class', 'center')
  table.style.border = `3px solid ${color}`
  table.style.width = '100%'
  
  // get rows
  for (let i = 0; i < rows; i++) {
    let row = document.createElement('tr')

    // get cols
    for (let j = 0; j < cols; j++) {
      let cell = document.createElement('td')
      cell.style.border = `1px solid ${color}`
      cell.innerHTML = getRandomEmoji()
      row.appendChild(cell)
    }
    table.appendChild(row)
  }
  document.getElementById('response').appendChild(table)
}

function getRandomEmoji() {
  const EMOJI = ["✌","😂","😝","😁","😱","👉","🙌","🍻","🔥","🌈","☀","🎈","🌹","💄","🎀","⚽","🎾","🏁","😡","👿","🐻","🐶","🐬","🐟","🍀","👀","🚗","🍎","💝","💙","👌","❤","😍","😉","😓","😳","💪","💩","🍸","🔑","💖","🌟","🎉","🌺","🎶","👠","🏈","⚾","🏆","👽","💀","🐵","🐮","🐩","🐎","💣","👃","👂","🍓","💘","💜","👊","💋","😘","😜","😵","🙏","👋","🚽","💃","💎","🚀","🌙","🎁","⛄","🌊","⛵","🏀","🎱","💰","👶","👸","🐰","🐷","🐍","🐫","🔫","👄","🚲","🍉","💛","💚"]
  let randomEmoji = Math.floor(Math.random() * EMOJI.length)
  return EMOJI[randomEmoji]
}

// when the page loads...
let title = document.createElement('h3')
title.innerHTML = 'Default values'
document.getElementById('response').appendChild(title)
printTable()
title = document.createElement('h3')
title.innerHTML = '20 rows, 10 cols'
document.getElementById('response').appendChild(title)
printTable(20, 10)
for (let i = 0; i < 10; i++) {
  title = document.createElement('h3')
  title.innerHTML = `Table ${i+1} with 5 rows, 4 cols, and green color`
  document.getElementById('response').appendChild(title)
  printTable(5, 4, 'green')
}