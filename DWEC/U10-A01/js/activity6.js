function createPlaceholders(num) {
  // clear main
  let main = document.getElementById('main')
  main.innerHTML = ''

  // create an img as placeholder for each profile photo
  for (let i = 0; i < num; i++) {
    let img = document.createElement('img')
    img.id = i
    main.append(img)
  }
}

function shuffleImages(people) {
  // sort people randomly
  people.sort((a, b) => Math.floor(Math.random() * 3) - 1)

  // print people photos
  for (let i = 0; i < people.length; i++) {
    let img = document.getElementById(i)
    img.setAttribute('src', people[i].picture.large)
  }
}

async function main() {
  // get people
  let people = await fetch('https://randomuser.me/api?results=50')
    .then((response) => response.json())
    .then((result) => result.results)
    .catch((error) => {
      return { error }
    })

  // main code
  createPlaceholders(people.length)
  if (people.error) main.textContent = 'Something went wrong... :('
  else {
    // set interval and clear it after 100 loops
    let count = 0
    let intervalId = setInterval(() => {
      if (count === 100) clearInterval(intervalId)
      shuffleImages(people)
      count++
    }, 2)
  }
}

main()
