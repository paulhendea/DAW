// if the local storage property is not set, set it
if (localStorage.getItem('scrollY') == null) localStorage.setItem('scrollY', 0)
// else go to the last scroll position
else scrollTo(0, localStorage.getItem('scrollY'))

// every half a second, check if the scroll changed and save the new value
// also log it for testing purpose
setInterval(() => {
  if (localStorage.getItem('scrollY') != scrollY) localStorage.setItem('scrollY', scrollY)
  console.log(localStorage.getItem('scrollY'))
}, 500);
