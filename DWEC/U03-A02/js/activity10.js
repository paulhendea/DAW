let table = document.getElementById('table');
printTableHeaders(table);
printTableData(table, 10000);


function charFromUnicode(unicode) {
    // returns an unicode character from a decimal code
    return String.fromCharCode(unicode);
}

function printTableHeaders(table) {
    // writes the header of the table (first row)
    let row = document.createElement('tr');
    // first one will be empty
    let emptyCell = document.createElement('th');
    row.appendChild(emptyCell);

    for (let i = 0; i < 16; i++) {
        let cell = document.createElement('th');
        // print the numbers from 0 to 16 in hexadecimal
        cell.innerHTML = i.toString(16).toUpperCase();
        row.appendChild(cell);
    }
    table.appendChild(row);
}

function printTableData(table, numberOfChars) {
    // create the first row
    let row = document.createElement('tr');
    let firstCell = document.createElement('th');
    firstCell.innerHTML = '0000';
    row.appendChild(firstCell);

    // i is for character, j is a counter for rows
    for (let i = 0, j = 0; i < numberOfChars; i++, j++) {
        // when the row is at the end
        if (j === 16) {
            // reset counter
            j = 0;
            // change row
            table.appendChild(row);
            row = document.createElement('tr');
            // print row heading
            let rowHeading = document.createElement('th');
            rowHeading.innerHTML = i.toString(16).toUpperCase().padStart(4, '0');
            row.appendChild(rowHeading);
        }

        // then fill the data
        let cell = document.createElement('td');
        cell.innerHTML = charFromUnicode(i);
        row.appendChild(cell);
    }

    // in the case the las row was not appended, append it
    if (numberOfChars % 16 != 0) {
        table.appendChild(row);
    }
}