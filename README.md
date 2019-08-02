Simple Application - Text Content Indexer
------------

Installation
------------

**Dependencies**
- Java 8
- Maven
- make sure that both are added to your PATH environment variable

**Simple description what actually does the script do**

It will index each letter in a text to words. 
List of words in which particular letter occurs, should be sorted alphabetically.

**Assumptions:**
- word: comprised of latin alphabet characters [a-z]|[A-z]| separated by whitespace character (so characters
like '-', ':' etc. are going to be skipped)
- does not have to take letter case into consideration
- words that occur many times in a text must be presented only once in output 


Input text: 
```
ala ma kota, kot koduje w Javie Kota – (eng. Ala has a cat, a cat develops a cat in Java ;) )
```
Output:
```
a: ala, javie , kota, ma
d: koduje
e: javie , koduje
i: javie
j: javie, koduje
k: koduje, kot, kota
l: ala
m: ma
o: koduje, kot, kota
t: kot, kota
u: koduje
w: w
v: javie
```