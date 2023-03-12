import { timer } from "./timer.js"

// call and print result
timer(5000)
  .then((result) => (document.getElementById('response').textContent = result))
  .catch((error) => (document.getElementById('response').textContent = error))
