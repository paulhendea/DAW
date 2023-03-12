// get the browser window width and height
const width = window.innerWidth;
const height = window.innerHeight;

// print the boxes
for(let i = 0; i < 2000; i++) {
    printRandomBox();
}

function printRandomBox() {
    // creates a box with the css properties
    let box = document.createElement('div');
    box.style.cssText = `
        position: fixed; 
        width: 50px;
        height: 50px;
        top: ${getRandomHeight()}px;
        left: ${getRandomWidth()}px;
        background-color: ${getRandomColor()};
    `;
    document.body.appendChild(box);
}

function getRandomWidth() {
    // returns a random width from 0 to viewport width
    return Math.round(Math.random() * width);
}

function getRandomHeight() {
    // returns a random height from 0 to viewport height
    return Math.round(Math.random() * height);
}

function getRandomColor() {
    // 16777215 is the same as ffffff
    let color = Math.round(Math.random() * 16777215);
    return '#' + color.toString(16);
}