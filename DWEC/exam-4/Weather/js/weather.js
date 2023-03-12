const API_KEY = '82005d27a116c2880c8f0fcb866998a0'

// get location data
navigator.geolocation.getCurrentPosition(
  (position) => {
    let { latitude, longitude } = position.coords
    fetch(
      `https://api.openweathermap.org/data/2.5/weather?lat=${latitude}&lon=${longitude}&appid=${API_KEY}`
    )
      .then((response) => response.json())
      .then((result) => {
        // check for error
        if (result.cod != 200) throw new Error(result.message)
        
        // retrieve desired data from result
        let {
          weather: [{ description, icon }],
          name,
          sys: { country },
          main: { temp },
        } = result

        // print data
        let weatherIcon = document.getElementById('icon')
        weatherIcon.setAttribute('src', `icons/${icon}.png`)

        // for the temperature value, save the raw temperature (kelvin) as an attribute
        // Use of Intl.NumberFormat to format the temperature with 2 fraction digits
        let formatter = Intl.NumberFormat('en', { maximumFractionDigits: 2 })
        let weatherTemp = document.getElementById('temperature')
        weatherTemp.setAttribute('kelvin', temp)
        weatherTemp.textContent = `${formatter.format(temp - 273.15)}°C`
        // Add event listener to change units
        weatherTemp.addEventListener('click', (event) => {
          // get the actual unit and the raw temp value from the attribute
          let tempString = weatherTemp.textContent
          let tempValue = weatherTemp.getAttribute('kelvin')
          let tempUnit = tempString.substring(tempString.length - 1)
          // calculate Celsius of Fahrenheit
          if (tempUnit === 'C') {
            weatherTemp.textContent = `${formatter.format(
              (+tempValue - 273.15) * 1.8 + 32 
            )}°F`
          } else if (tempUnit === 'F') {
            weatherTemp.textContent = `${formatter.format(
              +tempValue - 273.15
            )}°C`
          }
        })

        let weatherDescription = document.getElementById(
          'temperature-description'
        )
        weatherDescription.textContent = description

        let weatherLocation = document.getElementById('location')
        weatherLocation.textContent = `${name}, ${country}`
      })
      .catch((error) => {
        // print error message if some
        let notification = document.getElementById('notification')
        notification.innerHTML = `<p>${error.message}</p>`
        notification.style.display = 'block'
      })
  },
  (error) => {
    // print error message
    let notification = document.getElementById('notification')
    notification.innerHTML = `<p>${error.message}</p>`
    notification.style.display = 'block'
  }
)
