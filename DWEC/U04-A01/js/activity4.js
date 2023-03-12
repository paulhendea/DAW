// get stats
let stats = getStats(10000);

// create elements
let list = document.createElement("ul");
for (let key in stats) {
  let item = document.createElement("li");
  item.innerHTML = `${key} - ${stats[key]} `;

  // create a progress bar with some attributes
  let progressBar = document.createElement("progress");
  progressBar.setAttribute("id", key);
  progressBar.setAttribute("max", getMaxNumber(stats));
  progressBar.setAttribute("value", stats[key]);
  item.appendChild(progressBar);

  // append items to the list
  list.appendChild(item);
}
document.getElementById("stats").appendChild(list);

function getMaxNumber(stats) {
  // gets the max value to use in the progress bar
  let max = 0;
  for (let key in stats) {
    max = Math.max(max, stats[key]);
  }
  return max;
}

function getStats(numOfSamples) {
  // return a dictionary with random numbers stats
  let stats = {};
  for (let i = 0; i < numOfSamples; i++) {
    let randomNumber = Math.ceil(Math.random() * 10);

    // check if the number exists in the dictionary, if not set it to 1
    if (stats[randomNumber] != undefined) stats[randomNumber]++;
    else stats[randomNumber] = 1;
  }
  return stats;
}
