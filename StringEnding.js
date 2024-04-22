/*
Given 2 strings: `string` and `ending`, return a Boolean value indicating whether `string` ends with `ending`.

For example:
endsWith("hello", "o") should return true
endsWith("hello", "oo") should return false

*/

/*

===========================

STRATEGY 1

If ending.length === 0:
  Return true

If string.length === 0:
  Return false

x = ending.length

For each character in `string`, starting from the last, to position `string.length - x` (inclusive):
  If character === character at same position in `ending`, counting from the last character of `ending`:
    continue
  Else:
    Return false

Return true

===========================

TRACE

Example 1:
string = hello, ending = oo

x = 2
string.length - x = 3
---x
hello
   *
oo
*

EDGE CASES
string = ""
ending = ""



===========================

*/

