let triangle;
let number = prompt("Type a positive number :)");

// Check if its a positive number
if(isNaN(number) || number < 0) {
    let errorMessage = document.createElement('h1');
    errorMessage.innerHTML = '>:(';
    document.body.appendChild(errorMessage);
}
else {
    // build triangle 1
    triangle = buildTriangle1(number);
    document.getElementById('title1').innerHTML = 'Triangle 1';
    document.getElementById('triangle1').innerHTML = triangle;

    // build triangle 2
    triangle = buildTriangle2(number);
    document.getElementById('title2').innerHTML = 'Triangle 2';
    document.getElementById('triangle2').innerHTML = triangle;

    // build triangle 3
    triangle = buildTriangle3(number);
    document.getElementById('title3').innerHTML = 'Triangle 3';
    document.getElementById('triangle3').innerHTML = triangle;
}

function buildTriangle1(num) {
    // build the triangle 1
    let triangle = '';
    for(let i = num; i > 0; i--) {
        for(let j = 0; j < i; j++) {
            triangle += '*';
        }
        triangle += '<br>';
    }
    return triangle;
}

function buildTriangle2(num) {
    // build the triangle 2
    let triangle = '';
    for(let i = num -1, j = 1; i >= 0; i--, j+=2) {
        // blank space loop
        triangle += getChar(i, '&nbsp;');
        // star loop
        triangle += getChar(j, '*');
        // append break
        triangle += '<br>';
    }
    return triangle;
}

function buildTriangle3(num) {
        // build the triangle 3
        let triangle = '';

        // Math to determine the number of chars of the first row
        let numCharsFirstRow = (num * 2) -1;
        for(let i = 0, j = numCharsFirstRow; i < num; i++, j-=2) {
            // blank space loop
            triangle += getChar(i, '&nbsp;');
            // star loop
            triangle += getChar(j, '*');
            // append break
            triangle += '<br>';
        }
        return triangle;
}

function getChar(num, char) {
    // print (char), (num) number of times
    let chars = '';
    for(let i = 0; i < num; i++) {
        chars += char;
    }
    return chars;
}