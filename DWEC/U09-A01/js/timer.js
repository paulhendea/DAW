function timer(timeout) {
  // return the promise
  return new Promise((resolve, reject) => {
    // set timeout for reject (double time)
    let timer2 = setTimeout(() => {
      reject('Something went wrong :(')
    }, timeout * 2)

    // set timeout for resolve
    setTimeout(() => {
      // if the shorter timeout ends we can clear the longer one too before resolving
      clearTimeout(timer2)
      resolve(`${timeout / 1000} seconds have passed :)`)
    }, timeout)
  })
}

async function counter(
  start,
  element = document.body,
  interval = 1000,
  callback = function() {}
) {
  try {
    // validate the start number
    if (isNaN(start) || start <= 0)
      throw new Error('Start must be a positive number >:(')
    let count = start

    // print the first number to avoid first delay
    element.textContent = count--
    
    // start the countdown
    new Promise((resolve, reject) => {
      let countdown = setInterval(() => {
        // when counter is 0 stop countdown and resolve
        if (count === 0) {
          clearInterval(countdown)
          resolve()
        }
        element.textContent = count--
      }, interval)
    }).then(() => callback() /* after resolving invoke the callback */)

  } catch(e) {
    console.error(e)
  }
}

export { timer, counter }
