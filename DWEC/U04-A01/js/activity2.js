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
  let encrypted = encrypt(text, key);
  document.getElementById("result").innerHTML = encrypted;
}

function encrypt(text, key) {
  // encrypt the text using the key
  let encrypted = "";
  let keyLastIndex = key.length - 1;

  // we need to counters, the index for the text and for the key
  for (let i = 0, k = 0; i < text.length; i++, k++) {
    // when the key index is bigger than the length of it, reset
    if (k > keyLastIndex) k = 0;
    // then encrypt and save
    let unicode = text.charCodeAt(i) + Number(key.charAt(k));
    encrypted += toChar(unicode);
  }
  return encrypted;
}

function toChar(unicode) {
  // convert to char from decimal code
  return String.fromCharCode(unicode);
}
