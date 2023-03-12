function startEncrypt() {
  // get data
  let text = document.getElementById("text").value;
  let key = document.getElementById("key").value;

  // quick validation
  if ([text, key].includes("") || isNaN(key)) {
    document.getElementById("result").innerHTML = ">:(";
    return;
  }

  // encrypt
  let encrypted = encrypt(text, +key);
  document.getElementById("result").innerHTML = encrypted;
}

function encrypt(text, key) {
  // encrypt the text using the key
  let encrypted = "";
  for (const char of text) {
    encrypted += toChar(+toUnicode(char) + key);
  }
  return encrypted;
}

function toUnicode(char) {
  // convert char to decimal code
  return char.charCodeAt(0);
}

function toChar(unicode) {
  // convert to char from decimal code
  return String.fromCharCode(unicode);
}
