// Get the fibonacci number at the nth position

// Strategy 1: Recursion, simple version
// Summary: Get the nth fibonacci number by getting the two previous fibonacci numbers.
// (redundant operations, e.g. fib(4), fib(3))

function fib(n) {
    // base cases
    if (n === 1 || n === 2) {
        return 1;
    } 

    if (n === 0) {
        return 0;
    }

    // recursive case
    return fib(n - 1) + fib(n - 2);
}

// =========================
// Strategy 2: Memoization
// Summary: Store the result of repeated operations

const fibonacciNumbers = [0, 1, 1];

function fib(n) {
    let result;

    // base cases
    if (n === 1 || n === 2) {
        return 1;
    } 

    if (n === 0) {
        return 0;
    }

    // recursive case
    // If you have not yet called fib() with the current `n`, then compute it and store it at the nth position of `fibonacciNumbers`.
    if (fibonacciNumbers[n] === undefined) {
        result = fib(n - 1) + fib(n - 2);
        fibonacciNumbers[n] = result;
    // Else, if you *have* already computed the result of fib(n) with the current `n`, get the result from `fibonacciNumbers`.
    } else {
        result = fibonacciNumbers[n];
    }

    return result;
}