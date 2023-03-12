function checkText() {
  // get the data
  let text = document.getElementById("text").value;
  if (isPalindrome(text)) {
    document.getElementById("response").innerHTML = "Is a palindrome! :D";
  } else {
    document.getElementById("response").innerHTML = "Is not a palindrome... :c";
  }
}

function isPalindrome(text) {
  // uniformize the text
  let formattedText = uniformize(text);
  // convert to array and reverse
  let sample1 = [...formattedText];
  let sample2 = [...formattedText].reverse();
  console.log("sample: " + formattedText);
  // compare chars from both arrays, if it is palindrome should return true
  for (let i in sample1) {
    if (sample1[i] != sample2[i]) return false;
  }
  return true;
}

function uniformize(text) {
  // uniformize the text by removing white spaces,
  // replace everything that is not a letter by nothing,
  // and special characters to normal form
  // 'á'.normalize("NFD") -> 'a'
  const pattern = /[^a-zñ]/g;
  return text.trim().toLowerCase().normalize("NFD").replaceAll(pattern, "");
}
