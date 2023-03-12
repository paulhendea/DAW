// const api_key = 'eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXVsaGVuZGVhMjJAZ21haWwuY29tIiwianRpIjoiYTg5YzJmMDAtYTM1Zi00Y2M4LWI0MDctOGVmYzIzOTJmZmZjIiwiaXNzIjoiQUVNRVQiLCJpYXQiOjE2NzM4OTQ2MjYsInVzZXJJZCI6ImE4OWMyZjAwLWEzNWYtNGNjOC1iNDA3LThlZmMyMzkyZmZmYyIsInJvbGUiOiIifQ.kZerPjOsX0c7EV-PW4ThQGfRsCE7OtpqPPf-HaU0vxo'

function getMap() {
  const api_key = document.getElementById('apikey').value

  fetch('https://opendata.aemet.es/opendata/api/mapasygraficos/analisis?api_key=' + api_key, {
    method: 'GET',
    mode: 'cors',
    headers: { accept: 'application/json' },
  })
    .then((result) => result.json())
    .then((content) => {
      fetch(content.datos)
        .then((result) => result.blob())
        .then((content) => {
          // remove form
          let form = document.getElementById('form')
          form.parentNode.removeChild(form)

          // add image
          let img = document.createElement('img')
          img.setAttribute('src', URL.createObjectURL(content))
          let main = document.getElementById('main')
          main.append(img)
        })
        .catch((error) => console.log(error))
    })
    .catch((error) => console.log(error))
}

// add event listener to button
let button = document.getElementById('button')
button.addEventListener('click', (event) => {
  getMap()
})
