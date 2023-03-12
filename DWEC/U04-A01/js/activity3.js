// get combinations
let combinationList = getDistinctCombinations(50);
for (let i in combinationList) {
  // Create elements
  let article = document.createElement("article");
  let combTitle = document.createElement("h3");
  combTitle.innerHTML = `Combination ${+i + 1}`;
  let combNumbers = document.createElement("p");
  // write the data
  let combination = combinationList[i];
  combNumbers.innerHTML = combination.join(", ");

  // append to document
  article.appendChild(combTitle);
  article.appendChild(combNumbers);
  document.getElementById("combinations").appendChild(article);
}

function getDistinctCombinations(number) {
  // get a number of distinct combinations of numbers
  let combinationList = [];
  for (let i = 0; i < number; i++) {
    // get a combination
    let combination = getCombination();

    // check for duplicates
    if (contains(combinationList, combination)) i--;
    else combinationList.push(combination);
  }
  return combinationList;
}

function contains(combinationList, combination) {
  // check if the combinationList contains combination
  for (let element of combinationList) {
    if (element.join("") === combination.join("")) return true;
  }
  return false;
}

function getCombination() {
  // returns a combination of 6 numbers between 1 and 49
  let combination = [];
  for (let i = 0; i < 6; i++) {
    // get random number between 1 and 49
    let randomNumber = getRandomNumber(1, 49);

    // check for duplicates
    if (combination.includes(randomNumber)) i--;
    else combination.push(randomNumber);
  }
  return combination;
}

function getRandomNumber(min, max) {
  // returns a random number between min and max inclusive
  return Math.round(Math.random() * (max - min) + min);
}
