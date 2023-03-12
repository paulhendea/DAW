var number, input, attempts, isFinished = false;

// load the game
resetGame();

function resetGame() {
    // Reset the variables, get a random number between 1 and 100, and write the title
    isFinished = false;
    attempts = 0;
    number = Math.round((Math.random() * 99) + 1);
    document.getElementById('response').innerHTML = 'Try to guess the number';
    document.getElementById('secondResponse').innerHTML = 'between 1 and 100';
    console.log(number);
}

function guessNum() {
    // Check if the game is in progress or not
    if(isFinished) return;
    attempts++;

    // Get the data from the form and check the data type to be a number
    let data = document.getElementById("input").value;
    if (isNaN(data)) {
        document.getElementById('response').innerHTML = 'That is not a number! >:(';
        return;
    }
    input = parseInt(data);

    // compare the values
    if(input === number) {
        document.getElementById('response').innerHTML = 'YOU WON! :D';
        document.getElementById('secondResponse').innerHTML = `in only ${attempts} attempt/s`;
        isFinished = true;
    }
    else if (input < number) {
        document.getElementById('response').innerHTML = 'Try higher ;)';
    }
    else {
        document.getElementById('response').innerHTML = 'Try lower ;)';
    }

}