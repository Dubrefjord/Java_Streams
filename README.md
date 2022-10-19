# Java_Streams

Streams allow us to go through all elements in a collectible, and apply some operations on each element. Writing working functions takes very little time, it kind of reminds me of python programming in that sense. However, in my opinion, it is pretty hard to read the code. Below are some functions and examples of stream operations.

## Operations on streams
### Filter
`filter(function returning bool)`: Takes a stream S and produces a new stream S' where the elements E of S' are the subset of the elements of S that meet the condition specified in the function f. 	$\forall$ E : E ⊂ S' ⇔ E ⊂ S ^ f(E) 

```java
cars.stream()
    .filter(car -> car.getHorsePower() > 200)
```
produces a stream with the elements whose horsepower > 200.

### ForEach

`forEach(function)`: Takes a stream S and performes the function f on each of the elements E. The function may modify the elements.

```java
 words.stream()
    .forEach(s -> System.out.println(s.getEnglish()+"  "+s.getPrio()));
```

### Peek
`peek(function)`: Does not modify the stream at all. The function is used to extract data. For example, we can use it to print values.

```java
words.stream()
    .peek(s -> System.out.println(s.getEnglish()+"  "+s.getPrio())) 
```
### Sorted
`sorted(comparator)`: Takes a stream S and returns a new stream S' where the elements are sorted according to a comparator.

```java
words.stream()
   .sorted(Comparator.comparing(Word::getLength).reversed())
```
produces a stream where the elements are ordered according to their lenghts, with the longest first. Note that we write `Word::getLength`, which is a neat way of providing a function when we want each element to be inserted as indata to the function. In other words is equivalent to writing `s -> s.getLength()`. 
Also note that we are adding `.reversed()` at the end of the comparator. This is because we want the longest element first in the list, whereas the specified comparator will do the opposite. 

### Map
`map(function)`: Takes a stream S of element E and produces a stream S' of element E' where E' is the returned value of the function. Each E has a corresponding E'.

```java
words.stream()
   .map(s -> s.getLength())
```
produces a stream with the integers corresponding to the lengths of the words in the original stream.

We can also use flatmap, which is identical to map, but it also flattens the stream. What this means is that if the map-function returns a stream, the elements of the this stream will be added to the output stream, instead of placing a stream in a stream. Essentially, it makes sure that the outputted stream is not a stream of streams, but instead a stream of elements. As a consequence, Each E can have many (or zero) E' when we use flatmap (whereas with map there is a one-to-one mapping from E to E'). Using flatmap and returning a stream in the function can be a powerful tool.

### Collect
`collect(collector)`: Transforms the stream into a collection, like a list. This operation can only be placed at the end of a stream operation (obviously, because after the collect operation we no longer have a stream and thus can't perform any more stream operations).

```java
cars.stream()
   .filter(s -> s.getFuelType() == Fuel.ELECTRIC)
   .collect(Collectors.toList());
```
produces a _list_ containing the electric cars that were included in the original stream.
