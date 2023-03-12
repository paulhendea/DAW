var response = document.getElementById('response');
var groups = [];
var students = [];

function addStudent() {
    // get data
    let student = document.getElementById('student').value;

    // validation
    if (!student) 
        response.innerHTML = 'Type the name of a student.';
    else if (student === 'end') 
        printGroups();
    else if (students.includes(student))
        response.innerHTML = `${student} is already saved.`;
    else {
        response.innerHTML = `${student} is saved :)`;
        students.push(student);
    }
}

function printGroups() {
    // get groups
    fillGroups(3);

    // remove response
    document.getElementById('response').innerHTML = '';

    for (let index in groups) {
        // create an article for each group with a list inside
        let article = document.createElement('article');
        let list = document.createElement('ul');
        // create a caption and append it
        let header = document.createElement('h3');
        header.innerHTML = `Group ${+index +1}`;
        article.appendChild(header);
        // fill the list for each group
        for (let student of groups[index]) {
            let listItem = document.createElement('li');
            listItem.innerHTML = student;
            list.appendChild(listItem);
        }

        article.appendChild(list);
        document.getElementById('response').appendChild(article);
    }
    
}

function fillGroups(studentsPerGroup) {
    // how many extra students are 
    let extraStudents = students.length % studentsPerGroup;
    let numOfGroups = Math.floor(students.length / studentsPerGroup);
    
    // special case when groups number is lower than extra students (list of 5 students)
    // add a group and set extra students to 0
    if (extraStudents > numOfGroups) {
        numOfGroups++;
        extraStudents = 0;
    }

    // create empty groups
    if (numOfGroups === 0) createGroups(1);
    else createGroups(numOfGroups);

    // make groups of 3
    for (let i = 0; i < students.length - extraStudents; i++) {
        let randomGroup = getRandomGroup(3);
        groups[randomGroup].push(students[i]);
    }
    // remove grouped students
    students.splice(0, students.length - extraStudents);
    // put each extra student in a random group with under 4 students
        for (let student of students) {
            let randomGroup = getRandomGroup(4);
            groups[randomGroup].push(student);
        }

}

function createGroups(numberOfGroups) {
    // create the groups in the groups map
    for (let i = 0; i < numberOfGroups; i++) {
        groups.push([]);
    }
}

function getRandomGroup(maxNumberOfStudents) {
    // returns a random group with under 3 students
    let availableGroups = getAvailableGroups(maxNumberOfStudents);
    let randomGroup = Math.floor(Math.random() * availableGroups.length);
    return availableGroups[randomGroup];
}

function getAvailableGroups(maxNumberOfStudents) {
    // return a list with the index of the groups with maxNumberOfStudents
    let availableGroups = [];
    for (let index in groups) {
        let groupValue = groups[index];
        if (groupValue.length < maxNumberOfStudents) availableGroups.push(index);
    }
    return availableGroups;
}