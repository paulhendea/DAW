const apikey = 'kM5A4ruzAwc8YU95lOm4vOG8JvuXUXZC'

async function procesarFetch() {
  await fetch('https://api.apilayer.com/exchangerates_data/symbols', {
    method: 'GET',
    headers: { apikey },
  })
    .then((response) => response.json())
    .then((data) => {
      let moneda1 = document.getElementById('moneda1')
      let moneda2 = document.getElementById('moneda2')

      for (let [key, value] of Object.entries(data.symbols)) {
        // create an option for every symbol
        let option = document.createElement('option')
        option.textContent = key
        if (key === 'EUR') option.toggleAttribute('selected')

        // append options, for moneda2 remove selected attribute
        moneda1.append(option.cloneNode(true))
        moneda2.append(option.cloneNode(true))
      }

      // remove loading text and show form
      let loading = document.getElementById('loading-text')
      let form = document.getElementById('form')

      loading.style.display = 'none'
      form.style.display = 'block'
    })
    .catch((error) => console.log(error))

  // add evet listener to the button
  let button = document.getElementById('convertButton')
  button.addEventListener('click', (event) => {
    event.preventDefault()

    // get data
    let amount = document.getElementById('amount').value
    let moneda1 = document.getElementById('moneda1').value
    let moneda2 = document.getElementById('moneda2').value

    fetch(
      `https://api.apilayer.com/exchangerates_data/convert?from=${moneda1}&to=${moneda2}&amount=${amount}`,
      {
        method: 'GET',
        headers: { apikey },
      }
    )
      .then((response) => response.json())
      .then((data) => {
        if (data.success) {
          // show result
          let result = document.getElementById('result')
          result.textContent = data.result
        } else console.log('Something went wrong with the conversion... :(')
      })
      .catch((error) => console.log({ error }))
  })
}

// Código principal dentro del evento load
// para asegurar la carga de los componentes
document.addEventListener('DOMContentLoaded', (ev) => {
  procesarFetch()
})
