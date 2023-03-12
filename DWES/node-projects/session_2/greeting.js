import { userInfo } from 'os'

let { username } = userInfo()
console.log(`Hello, ${username} :)`)