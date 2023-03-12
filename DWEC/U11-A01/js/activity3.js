function getTaskSet() {
  // get Set from local storage
  let taskList = localStorage.getItem('taskList')
  if (taskList === null) taskList = []
  else taskList = JSON.parse(taskList)

  // sort alphabetically
  taskList.sort((a, b) => a.localeCompare(b))

  return new Set(taskList)
}
function setTaskSet(taskList) {
  // set task list in local storage
  localStorage.setItem('taskList', JSON.stringify(taskList))
}

function refreshTaskList() {
  // get data
  let taskSet = getTaskSet()

  // clear list
  let list = document.getElementById('task-list')
  list.innerHTML = ''

  // print items
  for (let task of taskSet) {
    let article = document.createElement('article')
    let text = document.createElement('p')
    text.textContent = task
    let deleteButton = document.createElement('button')
    deleteButton.textContent = '🗑️'
    deleteButton.addEventListener('click', (event) => {
      // get data
      let taskSet = getTaskSet()

      // remove item
      taskSet.delete(task)

      // update
      setTaskSet([...taskSet])
      refreshTaskList()
    })
    article.append(text, deleteButton)
    list.appendChild(article)
  }
}

// Add task event listener
let addTaskButton = document.getElementById('add-task')
addTaskButton.addEventListener('click', (event) => {
  event.preventDefault()

  // get data
  let taskSet = getTaskSet()

  // add task to the Set
  let task = document.getElementById('new-task')
  taskSet.add(task.value)

  // clear input
  task.value = ''

  // save in local storage and refresh task list
  setTaskSet([...taskSet])
  refreshTaskList()
})

// show the list items at start
refreshTaskList()
