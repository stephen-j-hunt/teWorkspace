


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
