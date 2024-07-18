/*
Übungen aus dem Buch "Algorithmen und Datenstrukturen - Die Grundwerkzeuge" von Dietzfelbinger, Mehlhorn, Sanders.

1.1. Addition (S. 2-3)

Add two n-digit numbers, number1 and number2. Base 10.

carryover = 0
sumDigits = "";

n times:
  sum = digit in number1[index] + digit in number2[index] + carryover

  if sum > 9:
    carryover = left digit in sum
    sumDigits = right digit in sum.toString() + sumDigits
  else: 
    carryover = 0
    sumDigits = sum.toString() + sumDigits

return sumDigits as number


============

1.2 Multiplikation: Die Schulmethode

Multiplikation
---------
multiply n-digit number a with 1-digit number b. Base 10.

carry = 0
result = ''

for each digit in a, starting from the right:
  product = digitInA * b + carry * base
  rightDigitOfProduct = product modulo 10
  carry = Math.floor(product / 10)

  add rightDigitOfProduct to beginning of result
  If you are at the first (leftmost) digit in a, add carry to beginning of result

return result

-----

Aufgabe 1.1.: Geben Sie ein Programm für die Multiplikation von a und b[j] an, das nur eine Phase hat.

Erklärung der Notation: a[n-1] ... a[0] sind die Ziffern einer n-ziffrigen Zahl. Diese Zahl wird mit der einstelligen Zahl b[j] multipliziert. 

Erklärung der Aufgabe: D.h. ein Programm, bei dem die Erzeugung der Ziffernprodukte a[i] * b[j] und die Addition von c und d in eine Phase zusammengezogen werden.



a[n-1] a[i] a[0] * b[j] =    | carry | Math.floor((a[i] * b[j]) / 10)   | 0
                             | digit |                                  | a[i] * b[j] % 10

*/