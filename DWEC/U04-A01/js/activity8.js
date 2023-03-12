var numberList = [];

function add() {
    // get the data
    let number = document.getElementById('number').value;
    // quick check
    if(number == "" || isNaN(number)) {
        document.getElementById("response").innerHTML = "Not a number! >:(";
        return;
    }

    // in case the number is zero
    if(+number === 0) {
        // show stats
        document.getElementById("response").innerHTML = getStats();
        // disable buttons
        document.getElementById('cancel').setAttribute('disabled', '');
        document.getElementById('add').setAttribute('disabled', '');
        // show restart button
        showRestartBtn();
        return;
    }
    
    // add the number to the list (make sure its number type with + operator)
    numberList.push(+number);
    // ask for another
    document.getElementById('response').innerHTML = `You typed ${number} :)`;
}

function cancel() {
    // clean the list of numbers
    numberList = [];

    // print message
    document.getElementById('response').innerHTML = 'The game is canceled.';
}

function showRestartBtn() {
    // create element and append
    let restartBtn = document.createElement('button');
    restartBtn.setAttribute('id', 'restart');
    restartBtn.setAttribute('onclick', 'restart()');
    restartBtn.innerHTML = 'Restart';
    document.getElementById('input').appendChild(restartBtn);
}

function restart() {
    // remove disable attributes
    document.getElementById('cancel').removeAttribute('disabled');
    document.getElementById('add').removeAttribute('disabled');
    // remove show button
    document.getElementById('restart').remove();
    // print message
    document.getElementById('response').innerHTML = 'Game restarted.';
}

function getStats() {
    return `
        <b>Total numbers</b>: ${numberList.length}<br>
        <b>Average</b>: ${getAverage()}
    `;
}

function getAverage() {
    // returns the average from numberList
    let total = 0;
    for (let number of numberList) {
        total += number;
    }
    return total / numberList.length;
}