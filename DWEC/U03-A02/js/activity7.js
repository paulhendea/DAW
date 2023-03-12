var triangle = '';
let number = prompt("Type a positive number :)");

// Check if its a positive number
if(isNaN(number) || number < 0) {
    document.getElementById('result').innerHTML = '>:(';
}
else {
    // build the triangle and write it into the document
    for(let i = 1; i <= number; i++) {
        for(let j = 0; j < i; j++) {
            triangle += '*';
        }
        triangle += '<br>';
    }
    document.getElementById('result').innerHTML = triangle;
}
