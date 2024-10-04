// Get the number of digits in a natural number:

function getNumberOfDigits(num) {
    if (num < 10) {
        return 1;
    } else {
        return 1 + getNumberOfDigits(Math.floor(num / 10));
    }
}

console.log(getNumberOfDigits(-45558));