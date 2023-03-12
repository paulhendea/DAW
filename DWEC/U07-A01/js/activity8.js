// get the paragraphs node
let paragraphs = document.getElementById('paragraphs')

// create new section and fill with the paragraphs in reverse order
let reversedParagraphs = document.createElement('section')
reversedParagraphs.id = 'paragraphs'
;[...paragraphs.children].reverse().forEach(child => reversedParagraphs.appendChild(child))

// replace paragraphs
paragraphs.parentNode.replaceChild(reversedParagraphs, paragraphs)