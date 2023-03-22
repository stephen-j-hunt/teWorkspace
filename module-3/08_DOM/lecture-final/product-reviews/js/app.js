const bookName = 'Cigar Parties for Dummies';
const description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
const reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  },
  {
    reviewer: 'Tim Ferriss',
    title: 'Had a cigar party started in less than 4 hours.',
    review:
      "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
    rating: 4
  },
  {
    reviewer: 'Ramit Sethi',
    title: 'What every new entrepreneurs needs. A door stop.',
    review:
      "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
    rating: 1
  },
  {
    reviewer: 'Gary Vaynerchuk',
    title: 'And I thought I could write',
    review:
      "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
    rating: 3
  }
];

/**
 * Add the product name to the page title
 * Get the page title by the id and the query the .name selector
 * once you have the element you can add the product name to the span.
 */
function setPageTitle() {
  const pageTitleElement = document.getElementById('page-title');
  const span = pageTitleElement.querySelector('.name');
  span.innerText = bookName;

}

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  const pageDescElement = document.querySelector('p.description');
  pageDescElement.innerText = description;
}

/**
 * Display all of the reviews on the page.
 * Loop over the array of reviews and use some helper functions
 * to create the elements needed for the markup and add them to the DOM.
 */
function displayReviews() {

  const main = document.getElementById('main');

  reviews.forEach(review => {

    const reviewContainer = document.createElement('div');
    reviewContainer.classList.add('review');
    addReviewer(reviewContainer, review.reviewer);
    addRating(reviewContainer, review.rating);
    addTitle(reviewContainer, review.title);
    addReview(reviewContainer, review.review);

    main.insertAdjacentElement('beforeend', reviewContainer);

  });
}

/**
 * Create a new h2 element with the name of the reviewer and append it to
 * the parent element that is passed to me.
 *
 * @param {HTMLElement} parent: The element to append the reviewer to
 * @param {string} name The name of the reviewer
 */
function addReviewer(parent, name) {
  const reviewerElement = document.createElement('h2');
  reviewerElement.innerText = name;
  parent.appendChild(reviewerElement);
}

/**
 * Add the rating div along with a star image for the number of ratings 1-5
 * @param {HTMLElement} parent
 * @param {Number} numberOfStars
 */
function addRating(parent, numberOfStars) {

  const ratingStars = document.createElement('div');
  ratingStars.classList.add('rating');
  for (let n = 0; n < numberOfStars; n++) {
    const starElement = document.createElement('img');
    starElement.src = 'img/star.png';
    starElement.classList.add('ratingStar');
    ratingStars.appendChild(starElement);
  }

  parent.appendChild(ratingStars);
}

/**
 * Add an h3 element along with the review title
 * @param {HTMLElement} parent
 * @param {string} title
 */
function addTitle(parent, title) {
  const titleElement = document.createElement('h3');
  titleElement.innerText = title;
  parent.appendChild(titleElement);
}

/**
 * Add the product review
 * @param {HTMLElement} parent
 * @param {string} review
 */
function addReview(parent, review) {
  const reviewElement = document.createElement('p');
  reviewElement.innerText = review;
  parent.appendChild(reviewElement);
}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
