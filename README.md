Sample Application - Text Content Indexer
------------

Installation
------------

**Dependencies**
- Java 8
- Maven
- make sure that both are added to your PATH environment variable

**Build and run:**
- to compile new version of the .jar go to the root project directory and run maven command:
 ```
 mvn clean compile assembly:single
 ```
 - to run: 
 ```
 java -jar target/text-indexer.jar 
 ```

Description
------------

**What actually does the script do?**

It will index each letter in a text to words. 
List of words in which particular letter occurs, should be sorted alphabetically.

**Assumptions:**
- word: comprised of latin alphabet characters [a-z]|[A-z]| separated by whitespace character (so characters
like '-', ':' etc. are going to be skipped)
- does not have to take letter case into consideration
- words that occur many times in a text must be presented only once in output 

**Solution:**

We do not have any restrictions about what matters for us regarding the algorithm design, so the simpliest 
implementation has been chosen.

We are iterating over a list of extracted, valid words from input. Word is split up to an array of characters 
and now we are ready to create a proper structure. Character is a key, Word is an element of a list which in turn is 
a value. Depending if list is empty we create a list or just update their rows. Every update of the list runs sorting 
algorithm to make everything in order.


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