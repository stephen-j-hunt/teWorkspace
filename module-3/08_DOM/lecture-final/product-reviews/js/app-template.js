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
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = bookName;
}

/**
 * Add the product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * Use a template to display all of the reviews on the web page
 */
function displayReviews() {

  const main = document.getElementById('main');
  const template = document.getElementById('review-template');
  reviews.forEach(review => {
    const clone = template.content.cloneNode(true);
    clone.querySelector('h2').innerText = review.reviewer;
    clone.querySelector('h3').innerText = review.title;
    clone.querySelector('p').innerText = review.review;

    const starContainer = clone.querySelector('.rating');
    for (let n = 1; n < review.rating; n++) {
      const star = clone.querySelector('img').cloneNode();
      starContainer.appendChild(star);
    }

    main.appendChild(clone);
  });

}

// set the product reviews page title
setPageTitle();
// set the product reviews page description
setPageDescription();
// display all of the product reviews on the page
displayReviews();
