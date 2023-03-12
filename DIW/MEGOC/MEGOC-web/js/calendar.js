// // create the calendar
// let calendar = document.getElementById('calendar')

// let date = new Date('2023-02-01')
// console.log()
// while(date.getMonth() == 1) {
//   let day = document.createElement('div')
//   day.textContent = date.getDate()
//   day.setAttribute('date', date.toISOString().slice(0,10))
//   calendar.append(day)

//   // add one day
//   date.setDate(date.getDate() + 1)
// }

// function to fold and unfold
function foldUnfold(e) {
  // fold every event
  let events = document.body.querySelectorAll('.event')
  for (let event of events) {
    let description = event.querySelector('.description')
    description.style.display = 'none'
    let cartel = event.querySelector('.cartel')
    cartel.style.display = 'none'
  }

  // unfold clicked one
  let description = e.querySelector('.description')
  let cartel = e.querySelector('.cartel')

  description.style.display = 'block'
  cartel.style.display = 'block'

  // scroll to event
  window.scrollTo({ top: e.offsetTop, behavior: 'smooth' })
}

let events = document.body.querySelectorAll('.event')
for (let event of events) {
  event.addEventListener('click', () => foldUnfold(event))
}
