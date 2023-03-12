import moment from 'moment'

let now = moment()
let before = moment('09/09/1999', 'DD/MM/YYYY')
let after = moment('2023-09-09')
let fromBeforeToNow = moment.duration(now.diff(before)).years()
let fromNowToAfter = moment.duration(after.diff(now))

console.log('Is 09/09/1999 before now?', before.isBefore(now))
console.log(fromBeforeToNow, 'years from 09/09/1999 to now')
console.log('Is 09/09/2023 after from now?', after.isAfter(now))
console.log(fromNowToAfter.years(), 'years and', fromNowToAfter.months(), 'months from now to 09/09/2023')
console.log('In 1 month from now will be', moment().add(1, 'month').format('DD/MM/YYYY'))