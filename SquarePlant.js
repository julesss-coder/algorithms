/*
Task from URL https://www.inf-schule.de/imperative-programmierung/python/konzepte/rekursion/uebungen, exercise 3:

Aufgabe 3: Die seltsame Quadratpflanze
Betrachte die in der Abbildung gezeigte Quadratpflanze.

selbstähnliche Figur
Im Jahr 0 besteht die Quadratpflanze nur aus dem großen Basisquadrat. Jedes Jahr wachsen dann neue kleinere Quadrate an drei Quadratseiten. Die Grundseite des Basisquadrates sei m Einheiten (z. B. cm) lang. Die Funktion umfang(n, m) beschreibe den Umfang der gesamten Quadratpflanze nach n Jahren bei einer Seitenlänge m. Die Funktion flaecheninhalt(n, m) beschreibe den Flächeninhalt der gesamten Quadratpflanze nach n Jahren bei einer Seitenlänge m. Entwickle rekursive Funktionsdefinitionen für beide Funktionen. Welche Beobachtung kann man für die Entwicklung des Umfangs und der Fläche für große n machen?
*/

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
