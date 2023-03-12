const LOWER_ALPHABET = ['a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z',];
const UPPER_ALPHABET = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z',];
const NUMBER_LIST = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0'];
const NUM_RANGE = [0x30, 0x39];
const LOWER_CHAR_RANGE = [0x61, 0x7a];
const LOWER_Ñ = [0xf1];

function checkCredentials() {
  // get the data
  let username = document.getElementById('username').value;
  let password = document.getElementById('password').value;

  // validate
  if (!isValidUsername(username)) {
    document.getElementById('response').innerHTML = 'Wrong username >:(';
  } 
  else if (!isValidPassword(password)) {
    document.getElementById('response').innerHTML = 'Wrong password >:(';
  } 
  else {
    document.getElementById('response').innerHTML = 'Ok :)';
  }
}

function isValidUsername(username) {
  // unicode math approach

  // if its empty return false
  if (!username) return false;
  // else validate
  for (let i in username) {
    let unicodeValue = username.charCodeAt(i);
    if (!isLowerChar(unicodeValue)) {
      if (!isNumber(unicodeValue)) return false;
    }
  }
  return true;
}

function isValidPassword(password) {
  // function per requirement approach
  if (
    hasUpperLetter(password) &&
    hasLowerLetter(password) &&
    hasNumber(password) &&
    hasSpecialChar(password)
  ) {
    return true;
  }
  // other ways
  return false;
}

function hasUpperLetter(text) {
  // check for upper letters
  for (let char of text) {
    if (UPPER_ALPHABET.includes(char)) return true;
  }
  console.log('No uppercase letter');
  return false;
}

function hasLowerLetter(text) {
  // check for lower letters
  for (let char of text) {
    if (LOWER_ALPHABET.includes(char)) return true;
  }
  console.log('No lowercase letter');
  return false;
}

function hasNumber(text) {
  // check for numbers
  for (let char of text) {
    if (NUMBER_LIST.includes(char)) return true;
  }
  console.log('No number');
  return false;
}

function hasSpecialChar(text) {
  // check for chars that are not letters or numbers
  for (let char of text) {
    if (
      !NUMBER_LIST.includes(char) &&
      !UPPER_ALPHABET.includes(char) &&
      !LOWER_ALPHABET.includes(char)
    ) {
      return true;
    }
  }
  console.log('No special char');
  return false;
}

function isLowerChar(unicodeValue) {
  // check if the char is in the correct range
  // check for lower letters
  if (
    unicodeValue < LOWER_CHAR_RANGE[0] ||
    unicodeValue > LOWER_CHAR_RANGE[1]
  ) {
    // check for ñ
    if (unicodeValue != LOWER_Ñ) {
      return false;
    }
  }
  return true;
}

function isNumber(unicodeValue) {
  // check if the char is in the correct range
  if (unicodeValue < NUM_RANGE[0] || unicodeValue > NUM_RANGE[1]) {
    return false;
  }
  return true;
}