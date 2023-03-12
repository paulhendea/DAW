import { counter } from './timer.js'

let p1 = document.getElementById('p1')
let p2 = document.getElementById('p2')

counter(6, p1)
counter(60, p2, 100, () => (p2.textContent = 'End'))
