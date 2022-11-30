/*
Task from URL https://www.inf-schule.de/imperative-programmierung/python/konzepte/rekursion/uebungen, exercise 3:

Aufgabe 3: Die seltsame Quadratpflanze
Betrachte die in der Abbildung gezeigte Quadratpflanze.

selbstähnliche Figur
Im Jahr 0 besteht die Quadratpflanze nur aus dem großen Basisquadrat. Jedes Jahr wachsen dann neue kleinere Quadrate an drei Quadratseiten. Die Grundseite des Basisquadrates sei m Einheiten (z. B. cm) lang. Die Funktion umfang(n, m) beschreibe den Umfang der gesamten Quadratpflanze nach n Jahren bei einer Seitenlänge m. Die Funktion flaecheninhalt(n, m) beschreibe den Flächeninhalt der gesamten Quadratpflanze nach n Jahren bei einer Seitenlänge m. Entwickle rekursive Funktionsdefinitionen für beide Funktionen. Welche Beobachtung kann man für die Entwicklung des Umfangs und der Fläche für große n machen?
*/

// Count squares of square plant, V1

let squares = 1;
let years = 4;
function countSquares(years, squares) {
		console.log(`squares: ${squares}, years: ${years}`);

		if (years === 0) {
			return 1;
		}
		
		return squares * 3 + countSquares(years - 1, squares * 3);
}		

countSquares(years, squares);

// Count squares of square plant, V2

let squares = 1;
let years = 4;
let counter = 0;

function countSquares(counter, squares) {
		// console.log(`squares: ${squares}, years: ${years}`);
		if (counter === years) {
			return 1;
		}
		
		return squares * 3 + countSquares(counter + 1, squares * 3);
}		

countSquares(counter, squares);

// ================  Get perimeter of square plant - mathematical solution =================

let side = 1;
let steps = 3;
let squares = 1;


function getSquarePlantPerimeterMathematical(side, steps) {
  // perimeter of first square = 4 * side
  return 4 * side + 2 * steps;
}


//================ Get perimeter of square plant - iterative solution ======================

let sideLength = 1;
let squares = 1;
// perimeter of first square before you start growing the square plant
let perimeter = 4 * sideLength;
let steps = 4;

function getSquarePlantPerimeterIterative(sideLength, squares, perimeter, steps) {
  while (steps > 0) {
    sideLength = sideLength / 3;
    squares = squares * 3;
    perimeter = perimeter + 2 * sideLength * squares;    
    steps--;
  }

  return perimeter;
}



