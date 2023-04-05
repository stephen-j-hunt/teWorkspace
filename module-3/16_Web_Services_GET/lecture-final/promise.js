

console.log("==== sync ====");
console.log('first');
console.log('second');
console.log('third');

console.log("==== async ====");
console.log('first');
// doDelay(1500).then(() => {
//     console.log('*** second ***');
// });
console.log('third');

console.log("==== error handling ====");
doDelay(1500, true)
    .then(() => { console.log('second'); })
    .catch(() => { console.log('an error occurred'); });

console.log("==== data handling ====");
doDelay(1500)
    .then((t) => { console.log('the current date/time is ' + t); })
    .catch(() => { console.log('an error occurred'); });

console.log("==== delayed handling ====");
const promiseObj = doDelay(150000);

promiseObj
    .then((t) => { console.log('the current date/time is ' + t); })
    .catch(() => { console.log('an error occurred'); });



/**
 * factory function to produce a promise that 
 * resolves or rejects after a given number of 
 * milliseconds
 * @param {Number} waitInMS - delay in milliseconds
 * @param {Boolean} shouldErr - TRUE if the promise should reject; 
 *                              otherwise the promise will resolve. defaults to FALSE
 */
function doDelay(waitInMS, shouldErr = false) {
    return new Promise(
        (resolveFn, rejectFn) => setTimeout(shouldErr ? rejectFn() : resolveFn(new Date()), waitInMS)
    );
}
