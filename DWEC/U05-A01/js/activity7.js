/* 
Here you have an example of a huge palindrome so you can test with it :)

LA MAR. Ah! El anís es azul al ocaso. Claro, la canícula hará mal. Alejábase bello sol. 
¡Sumerge la usada roda! A remar. ¡A La Habana, bucanero Morgan! Oleaje de la mar… 
¡Al remo! ¡Corre! Playas… Ay, al perro comer la rama le deja el onagro, morena cubana. 
¡Bah! A la ramera adorada su alegre muslo Sol le besa. ¡Bajel a la mar! ¡Ah! 
Alucina calor al cosaco. La luz asesina le hará mal. 
[de Darío Lancini. El final de su hiperpalíndrico poema en prosa]

*/

function isPalindrome(text) {
  // uniformize the text
  text = text
    .trim()
    .toLowerCase()
    .normalize('NFD')
    .replaceAll(/[^a-zñ]/g, '')
  console.log('sample: ' + text)
  // reverse the character by convert to array
  let reverseText = [...text].reverse().join('')
  // compare both strings, if it is palindrome should return true
  return text === reverseText
}

function checkText() {
  // get the data
  let text = document.getElementById('text').value
  let response = isPalindrome(text)
    ? 'Is a palindrome! :D'
    : 'Is not a palindrome... :c'
  document.getElementById('response').innerHTML = response
}
