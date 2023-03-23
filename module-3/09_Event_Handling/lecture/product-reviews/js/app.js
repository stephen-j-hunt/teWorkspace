const bookName = 'Cigar Parties for Dummies';
let description = 'Host and plan the perfect cigar party for all of your squirrelly friends.';
let reviews = [
  {
    reviewer: 'Malcolm Madwell',
    title: 'What a book!',
    review:
      "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language. Yes indeed, it is a book!",
    rating: 3
  }
];

/**
 * Add product name to the page title.
 */
function setPageTitle() {
  const pageTitle = document.getElementById('page-title');
  pageTitle.querySelector('.name').innerText = bookName;
}

/**
 * Add product description to the page.
 */
function setPageDescription() {
  document.querySelector('.description').innerText = description;
}

/**
 * Display all of the reviews in the reviews array.
 */
function displayReviews() {
  if ('content' in document.createElement('template')) {
    reviews.forEach((review) => {
      displayReview(review);
    });
  } else {
    console.error('Your browser does not support templates');
  }
}

/**
 * Add single review to the page.
 *
 * @param {Object} review The review to display
 */
function displayReview(review) {
  const main = document.getElementById('main');
  const tmpl = document.getElementById('review-template').content.cloneNode(true);
  tmpl.querySelector('h4').innerText = review.reviewer;
  tmpl.querySelector('h3').innerText = review.title;
  tmpl.querySelector('p').innerText = review.review;
  // there will always be 1 star because it is a part of the template
  for (let i = 1; i < review.rating; ++i) {
    const img = tmpl.querySelector('img').cloneNode();
    tmpl.querySelector('.rating').appendChild(img);
  }
  main.appendChild(tmpl);
}

// LECTURE STARTS HERE ---------------------------------------------------------------
document.addEventListener('DOMContentLoaded', () => {
  // Set the product reviews page title.
  setPageTitle();
  // Set the product reviews page description.
  setPageDescription();
  // Display all of the product reviews on our page.
  displayReviews();

  setupDescEdit();
  //give the ability to hit enter and save whats in the textbox or escape to undp changes to the box
  const addReviewButton = document.getElementById('btnToggleForm');
  addReviewButton.addEventListener('click', showHideForm);

  const form = document.querySelector('form');
  form.addEventListener('submit', (event) => {
    event.preventDefault();//this stops the page from auto reloading by default 
    saveReview();
    showHideForm();
  })

});
//this made the add reveiew button have function open and add review and save it



function setupDescEdit() {
  const descElement = document.querySelector('p.description');
  descElement.addEventListener('click', (event) => toggleDescriptionEdit(event.target));

  const descInput = document.getElementById('inputDesc');
  descInput.addEventListener('keyup', (event) => {
    if (event.key === 'Enter') {
      exitDescriptionEdit(event.target, true);//event.target is a reference to the textbox
    }
    if (event.key === 'Escape') {
      exitDescriptionEdit(event.target, false);
    }
  });

}
// above code add listener for the input box 



/**
 * Hide the description and show the text box.
 *
 * @param {Element} desc the element containing the description
 */
function toggleDescriptionEdit(desc) {
  const textBox = desc.nextElementSibling;
  textBox.value = desc.innerText;
  textBox.classList.remove('d-none');
  desc.classList.add('d-none');
  textBox.focus();//focus is used to move the cursor
}

/**
 * Hide the text box and show the description.
 * If save is true, also set the description to the contents of the text box.
 *
 * @param {Element} textBox the input element containing the edited description
 * @param {Boolean} save should we save the description text
 */
function exitDescriptionEdit(textBox, save) {
  let desc = textBox.previousElementSibling;
  if (save) {
    desc.innerText = textBox.value;
  }
  textBox.classList.add('d-none');
  desc.classList.remove('d-none');
}

/**
 * Toggle visibility of the add review form.
 */
function showHideForm() {
  const form = document.querySelector('form');
  const btn = document.getElementById('btnToggleForm');

  if (form.classList.contains('d-none')) {
    form.classList.remove('d-none');
    btn.innerText = 'Hide Form';
    document.getElementById('name').focus();
  } else {
    resetFormValues();
    form.classList.add('d-none');
    btn.innerText = 'Add Review';
  }
}

/**
 * Reset all of the values in the form.
 */
function resetFormValues() {
  const form = document.querySelector('form');
  const inputs = form.querySelectorAll('input');
  inputs.forEach((input) => {
    input.value = '';
  });
  document.getElementById('rating').value = 1;
  document.getElementById('review').value = '';
}
//this clears out all elements on the form
/**
 * Save the review that was added using the add review form.
 */
function saveReview() {


  const name = document.getElementById('name').value;
  const title = document.getElementById('title').value;
  const rating = document.getElementById('rating').value;
  const review = document.getElementById('review').value;

  const reviewObj = {
    reviewer: name,
    title: title,
    review: review,
    rating: rating
  }

  displayReview(reviewObj);
  reviews.push(reviewObj);
  resetFormValues();

}
