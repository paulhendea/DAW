// 16777215 is the same as #ffffff in decimal
let color = Math.round(Math.random() * 16777215);
let colorCode = '#' + color.toString(16);
document.body.style.backgroundColor = colorCode;

// change every 5 sec (5000 ms)
setInterval(() => {
    let color = Math.round(Math.random() * 16777215);
    let colorCode = '#' + color.toString(16);
    document.body.style.backgroundColor = colorCode;
}, 5000);