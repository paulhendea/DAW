let input = prompt('Type a number: ')
let num = parseInt(input);
let message = isNaN(num) ? `'${input}' is NOT a number :(` : `${input} is a number :)`;
alert(message);