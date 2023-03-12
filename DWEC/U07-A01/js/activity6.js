function scrollToBottom() {
  // get body height
  let height = document.body.offsetHeight
  
  // scroll to bottom using body height as coordinate and smooth behavior
  window.scrollTo({
    top: height,
    left: 0,
    behavior: 'smooth'
  });
}