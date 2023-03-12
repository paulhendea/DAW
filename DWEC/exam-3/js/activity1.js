// FUNCTIONS
function getFormData() {
  // get data
  let product = document.getElementById('producto').value
  let amount = +document.getElementById('cantidad').value
  let pricePerUnit = +document.getElementById('precio-unitario').value

  // reset inputs
  document.getElementById('producto').value = ''
  document.getElementById('cantidad').value = ''
  document.getElementById('precio-unitario').value = ''

  // quick validation
  if (!product) product = 'undefined'
  if (isNaN(amount)) amount = 0
  if (isNaN(pricePerUnit)) pricePerUnit = 0

  return { product, amount, pricePerUnit }
}

function calculateTotal() {  
  // get table info
  let total = 0
  let tableBody = document.getElementById('table-body').children
  for (let i = 0; i < tableBody.length; i++) {
    // get the total product price from each row (4th cell content)
    let totalProductPrice = tableBody[i].children[3].textContent
    total += Number(totalProductPrice)
  }

  let formatter = new Intl.NumberFormat('en-EN', { maximumFractionDigits: 2 })
  
  // set totals
  let basePrice = document.getElementById('base-imponible')
  basePrice.textContent = formatter.format(total)
  let iva = document.getElementById('iva')
  const IVA = iva.getAttribute('datos-iva')
  iva.textContent = formatter.format(total * +IVA)
  let totalPrice = document.getElementById('total')
  totalPrice.textContent = formatter.format(total * (+IVA + 1))
}

function addTableLine(lineInfo) {
  let tableBody = document.getElementById('table-body')

  // create row
  let row = document.createElement('tr')

  let formatter = new Intl.NumberFormat('en-EN', { maximumFractionDigits: 2 })
  
  // create cells and fill
  let product = document.createElement('td')
  product.textContent = lineInfo.product
  let amount = document.createElement('td')
  amount.textContent = formatter.format(lineInfo.amount)
  let pricePerUnit = document.createElement('td')
  pricePerUnit.textContent = formatter.format(lineInfo.pricePerUnit)
  let totalPrice = document.createElement('td')
  totalPrice.textContent = formatter.format(lineInfo.pricePerUnit * lineInfo.amount)
  
  // create actions cell
  let actions = document.createElement('td')
  let detail = document.createElement('button')
  detail.textContent = 'detail'
  detail.addEventListener('click', (event) => {
    // raise alert with the details
    alert(`Product detail\nProduct: ${lineInfo.product}\nAmount: ${lineInfo.amount}\nPrice per unit: ${lineInfo.pricePerUnit}\nTotal price: ${lineInfo.pricePerUnit * lineInfo.amount}`)
  })
  let remove = document.createElement('button')
  remove.textContent = 'delete'
  remove.addEventListener('click', (event) => {
    // remove the row from the table body
    tableBody.removeChild(row)
    calculateTotal()
  })
  actions.append(detail, remove)

  // append data to row, and row to table
  row.append(product, amount, pricePerUnit, totalPrice, actions)
  tableBody.append(row)
}

// EVENT LISTENERS
let add = document.getElementById('add')
add.addEventListener('click', (event) => {
  let lineInfo = getFormData()
  addTableLine(lineInfo)
  calculateTotal()
})