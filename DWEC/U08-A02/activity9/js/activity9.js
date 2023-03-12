const moveTaskToTop = (task) => {
  let list = document.getElementById('list')
  list.insertBefore(task, list.firstChild)
}
const removeTask = (task) => {
  let list = document.getElementById('list')
  list.removeChild(task)
}
const addTask = (event) => {
  let taskText = document.getElementById('task').value
  let list = document.getElementById('list')

  if (taskText) {
    // create list item
    let listItem = document.createElement('li')
    listItem.textContent = taskText
    listItem.addEventListener('click', (event) => moveTaskToTop(listItem), true)

    // create deleteButton
    let deleteButton = document.createElement('a')
    deleteButton.textContent = 'remove'
    deleteButton.addEventListener('click', (event) => removeTask(listItem))

    // append elements
    listItem.appendChild(deleteButton)
    list.appendChild(listItem)
  }
}

let plusButton = document.getElementById('plus')
plusButton.addEventListener('click', addTask)

let taskInput = document.getElementById('task')
taskInput.addEventListener('keydown', (event) => {
  if (event.key == 'Enter') addTask()
})
