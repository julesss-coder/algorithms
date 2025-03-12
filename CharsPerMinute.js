// You are given a string and an integer, standing for the number of seconds it took someone to write the string. Return the person's CPM (characters per minute).

function getCharsPerMinute(text, time) {
    let minutes = time / 60;
    let numberOfChars = text.length;

    return numberOfChars / minutes;
}

console.log(getCharsPerMinute("The quick brown fox jumped over the lazy dog.", 60));
console.log(getCharsPerMinute("dfhfhhshhah", 220));



