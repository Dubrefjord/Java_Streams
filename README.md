# Java_Streams

Streams allow us to go through all elements in a collectible, and apply some operations on each element. Writing working functions takes very little time, it kind of reminds me of python programming in that sense. However, in my opinion, it is pretty hard to read the code. When working 

### Operations on streams
- `filter(function returning bool)`: Takes a stream S and produces a new stream S' where the elements E of S' are the subset of the elements of S that meet the condition specified in the function f. 	$\forall$ E : E ⊂ S' ⇔ E ⊂ S ^ f(E) 

```java
cars.stream()
  .filter(car -> car.getHorsePower() > 200)
```
produces a stream with the elements whose horsepower > 200.

- `sorted(comparator)`: Takes a stream S and returns a new stream S' where the elements are sorted according to the comparator C.

```java
words.stream()
.sorted(Comparator.comparing(Word::getlength).reversed())
```
produces a stream where the elements are ordered according to their lenghts, with the longest first. Note that we write `Word::getlength`, which is a neat way of providing a function when we want each element to be inserted as indata to the function. In other words is equivalent to writing `s -> Word.getlength(s)`. 
Also note that we are adding `.reversed()` at the end of the comparator. This is because we want the longest element first in the list, whereas the specified comparator will do the opposite. 

- `map(function)`: r //To be continued! :)
