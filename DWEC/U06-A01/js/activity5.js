Date.prototype.getDaysDifferenceFrom = function(date) {
  // validation
  if (date instanceof Date === false) return null
  if (this.getTime() === date.getTime()) return 0
 
  // determine start and end date
  let startDate = Math.min(this.getTime(), date.getTime())
  let endDate = Math.max(this.getTime(), date.getTime())
  
  // calculate time difference
  let timeDifference = endDate - startDate
  // divide by the ms of one day to get total days
  return timeDifference / (1000 * 3600 * 24)
}

// get dates, calculate difference, and return response
function calculateTime() {
  // get data
  let startDateInput = document.getElementById('startDate').value
  let endDateInput = document.getElementById('endDate').value
  
  // validate
  if (!isValidDate(startDateInput) || !isValidDate(endDateInput)) {
    print('Select a valid date >:(')
    return
  }

  // convert to dates
  let date1 = new Date(startDateInput)
  let date2 = new Date(endDateInput)
  let daysOfDifference = date1.getDaysDifferenceFrom(date2)

  // print response
  if (daysOfDifference) print(`${daysOfDifference} days of difference.`) 
  else if (isNaN(daysOfDifference)) print('Select a valid date >:(')
  else print('Something went wrong')
}

function print(message) {
  let response = document.getElementById('response')
  response.innerHTML = `<p>${message}</p>`
}

function isValidDate(dateString) {
  return /[0-9]{4}\-[0-9]{2}\-[0-9]{2}/.test(dateString)
}