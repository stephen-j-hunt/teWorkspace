const player1 = {
    id: 1,
    char: 'x',
    iconClass: 'fa-times',
    scoreClass: '#score-player-1 .score-text'
};

const player2 = {
    id: 2,
    char: 'o',
    iconClass: 'fa-circle',
    scoreClass: '#score-player-2 .score-text'
};

/* Global variable that keeps whose turn is to play */
let currentPlayer = player1;

/** Toggle between players*/
function switchPlayer() {
    currentPlayer = currentPlayer.id === 1 ? player2 : player1;

    const currentPlayerElement = document.getElementById('current-player');
    currentPlayerElement.innerText = currentPlayer.char.toUpperCase();
}

/**
 * Place the current player's icon within the tile.
 */
function selectTile(tile, player) {
    // TODO: Step 1
}

/**
 * Returns true if there is a tie. A tie occurs when the entire
 * board is full.
 * 
 * @returns {boolean} true if there is a tie, false otherwise
 */
function isATie() {
    // TODO: Step 2
    const tiles = Array.from(document.querySelectorAll('.tile'));

}

function isAWin() {
    // TODO: Step 3
    return false;
}

function recordWin() {
    window.alert("WON!");
}

function recordTie() {
    window.alert("TIE!");
}

function colorWinner(tiles) {

    tiles.forEach(t => {
        t.querySelector("i").classList.add("won");
    })
}

function executeGameLogic(clickedTile) {

    selectTile(clickedTile, currentPlayer);

    if (isAWin()) {
        recordWin();
        return;
    }

    if (isATie()) {
        recordTie();
        return;
    }

    switchPlayer();
}

document.addEventListener('DOMContentLoaded', () => {
    onGameLoaded();
});

function onGameLoaded() {

    /* Hook-up event listeners for all tiles */
    const tiles = document.querySelectorAll('.tile');

    tiles.forEach(t => {
        t.addEventListener('click', onTileClicked);
    });

    /* TODO: - Hook-up Play Again button */    
}

function onTileClicked(event) {
    let clickedTile = event.currentTarget;
    executeGameLogic(clickedTile);
}

function onPlayAgainClicked() {
    removeAllIcons();
    switchPlayer();
    onGameLoaded();
}

function removeAllIcons() {
    // 1. find all icons
    const icons = document.querySelectorAll('i');

    // 2. remove fa-times and fa-circle from each icon
    icons.forEach(icon => {
        icon.classList.remove(player1.iconClass);
        icon.classList.remove(player2.iconClass);
        icon.classList.remove("won");
    });
}
