// set carousels
let carousels = document.querySelectorAll('.carousel')
for (let carousel of carousels) {
  new Glider(carousel.querySelector('.carousel__list'), {
    slidesToShow: 2,
    slidesToScroll: 2,
    draggable: true,
    dragVelocity: 1,
    arrows: {
      prev: carousel.querySelector('.carousel__previous'),
      next: carousel.querySelector('.carousel__next'),
    },
    responsive: [
      {
        // tablet screens
        breakpoint: 768,
        settings: {
          slidesToShow: 3,
          slidesToScroll: 3,
        },
      },{
        // pc screens
        breakpoint: 1024,
        settings: {
          slidesToShow: 4,
          slidesToScroll: 4,
        },
      },
    ],
  })
}
