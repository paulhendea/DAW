function process() {
    // Get the data from the form
    let form = document.forms[0];
    let data = [
        form.elements["name"].value, 
        form.elements["surname"].value, 
        form.elements["age"].value, 
        form.elements["salary"].value
    ];

    // Quick validation, no void params
    if(data.includes("")) {
        document.getElementById("result").innerHTML = "Fill the form! >:(";
        return;
    }

    // Asign data to variables
    let [name, surname, age, salary] = [...data];
    
    // Check the conditions
    let finalSalary = 0;
    if (salary < 1000) {
        console.log("I have less than 1000");
        if (age < 30) finalSalary = 11000;
        else if (age < 45) finalSalary = salary * 1.03; // increase 3%
        else finalSalary = salary * 1.15; // increase 15%
    }
    else if (salary < 2000) {
        console.log("I have less than 2000");
        if(age > 45) finalSalary = salary * 1.03; // increase 3%
        else finalSalary = salary * 1.10; // increase 10%
    }
    else {
        console.log("I have more than 2000");
        finalSalary = salary;
    }

    // Write the result
    document.getElementById("result").innerHTML = `${name} ${surname}, ${age} years old, with a final salary of ${finalSalary.toFixed(2)}$`;
}