let number = prompt('Type a positive number :)');

// Validate the input
if (isNaN(number) || number < 0) {
    let errorMessage = document.createElement('h1');
    errorMessage.innerHTML = '>:(';
    document.body.appendChild(errorMessage);
}
else {
    // Get and show the factorial
    number = parseInt(number);
    let message = document.createElement('h1');
    message.innerHTML = `${number}! is ${factorial(number)}`;
    document.body.appendChild(message);
}

// recursive aproach of factorial
function factorial(num) {
    if (num === 0) return 1;
    else return num * factorial(num -1);
}