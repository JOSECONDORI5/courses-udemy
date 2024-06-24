# Curso expresiones Lambda y Stream en Java

## Interfaces

> - It is a contract between two entities (interface e implementation)
> - The interface provides a service for the consumer class
> - All methods are abstract and public, as well as default and static methods (8+) and private methods (9+)

### Use

```Java
public interface Printer {
    void print(String data);
}

public class ReportExcel implements Printer {
    @Override
    public void print(String data) { ... }
}

public static void main(String[] args) {
    Printer excel = new ReportExcel();
    excel.print( ... );
}
```

## Anonymous classes

> - It is an instance of the interface or abstract class
> - can only be used once
> - It is an internal class

### Use Anonymous classes

```Java
public interface Printer {
    void print(String data);
}

public static void main(String[] args) {
    Printer reportPdf = new Printer() {
        @Override
        public void print(String data) { ... }
    }

    System.out.println(reportPdf.print( ... ))
}
```

## Generic programming

> - The data type is specified at the the time of execution
> - Is declared in abstract class or interfaces
> - Accept inheritance T extends MyInterface
> - Nomenclature E for element, K for key, N for number, T for type, V for value

### Use Generic programming

```Java
public Interface Repository<T> {
    T findById(Long id);
    List<T> findAll();
}

public class EmployeeRepository implements Repository<Employee> {
    @Override
    public Employee findById(Long id) { ... }
    
    @Override
    public List<Employee> findAll() { ... }
}

public class CustomerRepository implements Repository<Customer> {
    @Override
    public Customer findById(Long id) { ... }
    
    @Override
    public List<Customer> findAll() { ... }
}

public static void main(String[] args) {
    EmployeeRepository employeeRepository= new EmployeeRepository();
    CustomerRepository customerRepository= new CustomerRepository();

    System.out.println(employeeRepository.findById(1L));
    System.out.println(customerRepository.findById(1L));
}
```

## Functional interfaces

> - a single abstract method
> - can have private and default methods
> - Is noted with @FunctionalInterface

| Functional interface |                        Definition                         |                                     Declaration                                      |                  Use                   |                                           variants                                            |
| :------------------: | :-------------------------------------------------------: | :----------------------------------------------------------------------------------: | :------------------------------------: | :-------------------------------------------------------------------------------------------: |
|       Consumer       |        It has a parameter and doesn't return value        |       ```Consumer<String> consumer = (value) -> System.out.println(value);```        |     ```consumer.accept("Jose")```      |                           IntConsumer, DoubleConsumer, LongConsumer                           |
|      BiConsumer      |       It has two parameter and doesn't return value       | ```BiConsumer<Integer, Integer> biConsumer = (a, b) -> System.out.println(a * b);``` |     ```biConsumer.accept(5, 10)```     |                                                                                               |
|      Predicate       |  It has a parameter and return a boolean (true or false)  |            ```Predicate<String> predicate = (s) -> s.startsWith("G");```             |      ```predicate.test("Gool")```      |                         IntPredicate, DoublePredicate, LongPredicate                          |
|     BiPredicate      | It has two parameter and return a boolean (true or false) |       ```BiPredicate<String, String> predicate = (t1, t2) -> t1.equals(t2);```       | ```predicate.test("hello", "hello")``` |                                                                                               |
|       Supplier       |  Does not accept parameters and returns a specific value  |           ```Supplier<Integer> supplier = () -> new Random().nextInt();```           |          ```supplier.get()```          | IntSupplier, BooleanSupplier, DoubleSupplier, LongSupplier. the type reference the type value |
|       Function       |           It has a parameter and return a value           |                ```Function<Double, Double> function = l -> l * l;```                 |        ```function.apply(5);```        |                                                                                               |

### Use functional interface

```Java
@FunctionalInterface
public interface Math {
    Double execute(Double a, Double b);

    default Double addition(Double a, Double b) {
        return a + b;
    }
}

public class Test {
    public static void main(String[] args) {
        Math substract = new Math() {
            @Override
            public Double execute(Double a, Double b) {
                return a - b;
            }
        };

        Math multiply = (a, b) -> a * b;

        System.out.println(substract.execute(4.0, 3.0));
        System.out.println(multiply.execute(4.0, 3.0));
    }
}
```

## Lambda Expresion

> - It is an implementation of a functional interface
> - has the shape: (x, y) -> { return x + y } or () -> x + y ;
> - x, y: parameters
> - ->: arrow operator
> - {}: body of the expression, in braces if there is more than one line

## Parameter inference

> BiFunction<String, String, String> function = (String a, String b) -> {}
> BiFunction<String, String, String> function = (Var a, Var b) -> {}
> BiFunction<String, String, String> function = (a, b) -> {}

## Scope in stream

```Java
public static void main(String[] args) {
    int n = 10;
    IntStream.range(1, 10).forEach(i -> n = n + i); // does not compile

    AtomicInteger num = new AtomicInteger(10);
    IntStream.range(1, 10).forEach(i -> num = num + i); // compile

    AtomicReference<Integer> x = new AtomicReference<Integer>(10);
    IntStream.range(1, 10).forEach(i -> x = x + i); // compile
}
```

## Foreach

```Java
public static void main(String[] args) {
    List<String> countries = List.of("Peru", "Mexico", "Holland");
    countries.forEach(c -> System.out.println(c));
}
```

## Suplier

```Java
public static void main(String[] args) {
    // Create a Supplier to generate random numbers
    Supplier<Integer> randomSupplier = () -> new Random().nextInt(100);

    // Get a random number from the Supplier
    int randomNumber = randomSupplier.get();
    System.out.println("Random Number: " + randomNumber);
}
```

## Reference to method (Java 8+)

```Java
> MyClassOrObject::methodName
```

|     reference type     |             method reference             |              lambda expression               |
| :--------------------: | :--------------------------------------: | :------------------------------------------: |
|     static method      |          ```String::valueof```           |         ```s -> string.valueof(s)```         |
| object specific method | ``` var r = new random(); r::nextint ``` | ```var r = new random(); n = r.nextint(n)``` |
|    arbritary method    |           ```String::equals```           |        ```(s1, s2) -> s1.equals(2)```        |
|   constructor method   |            ```person::new```             |           ```a = new person(a)```            |

## Interfaces Function<T, V> and BiFunction<T, V, R>

> - Function<T, V>: one input(T), one return (V) → ```Function<Integer, Integer> multiply = v -> v * 2;```
> - BiFunction<T, V, R>: first input(T), second input(V) and one return (R) → ```BiFunction<Integer, Integer, Double> pow = (a, b) -> Math.pow(a, b);```

|                           Method                           |                                  Definition                                   |                                                                                       Use                                                                                        |
| :--------------------------------------------------------: | :---------------------------------------------------------------------------: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
|                     ```R apply(T t)```                     |                      apply the function with an argument                      |                                                ```System.out.println(squareNumber.apply(3)); System.out.println(pow.apply(3));```                                                |
| ```compose(Function<? super V, ? extends T> before)```[^1] |     first apply the function passed as an argument then the apply method      |  ```Function<Integer, Integer> add = (value) -> value + 3; Function<Integer, Integer> addThenMultiply = multiply.compose(add); System.out.println(addThenMultiply.apply(3));```  |
|   ```andThen(Function<? super R, ? extends V> after)```    | first execute the apply method then apply the function passed as an parameter | ```Function<Double, String> asString = t -> String.valueOf(t); BiFunction<Integer, Integer, String> execute = pow.andThen(asString); System.out.println(execute.apply(2, 3));``` |

## Inerfaces Predicate< T > and BiPredicate<T, U>

>- Predicate< T >: first argument(T) → ```Predicate<String> startsWithA = (text) -> text.startsWith("A");```
>- BiPredicate<T, U>: first argument(T), second argument(U) →

|                Method                 |                  Definition                  |                                                                                                     Use                                                                                                     |
| :-----------------------------------: | :------------------------------------------: | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
|           ```R test(T t)```           |            evaluate the parameter            |                                                                                  ```startsWithA.test("A example easy")```                                                                                   |
| ```and(Predicate<? super T> other)``` |      both predicates must be satisfied       |     ```Predicate<String> endsWithX   = (text) -> text.endsWith("x"); Predicate<String> composed = startsWithA.and(endsWithX); System.out.println(composed.test("A hardworking person must relax"));```      |
| ```or(Predicate<? super T> other)```  | one or the other predicate must be satisfied | ```Predicate<String> endsWithX   = (text) -> text.endsWith("x"); Predicate<String> composed = startsWithA.or(endsWithX); System.out.println(composed.test("A hardworking person must relax sometimes"));``` |
|            ```negate()```             |    returns the negation of the predicate     |                                                                      ```startsWithA.negate().test("Hello World") //Not start with A```                                                                      |

## Interfaces Consumer< T > and BiConsumer<T, U>

>- Consumer< T >: type argument(T), No return → ```Consumer<Integer> print = (x) -> System.out.println(x.toString());```
>- BiConsumer<T, U>: type first argument(T), type second argument(U), No return → ```BiConsumer<String, String> concat = (x, y) -> { System.out.println(x + y);};```

|                    Method                     |                        Definition                        |                                                             Use                                                             |
| :-------------------------------------------: | :------------------------------------------------------: | :-------------------------------------------------------------------------------------------------------------------------: |
|               ```accept(T t)```               |          execute the function with the argument          |                                 ```print.accept(10); concat.accept("Hello", " World!");```                                  |
| ```andThen(Consumer<? super T> after)``` [^2] | first apply the accept method  then consume the function | ```Consumer<Integer> printSquare = (x) -> System.out.println((x * x).toString()); print.andThen(printSquare).accept(25);``` |

## Interface Suplier< T >

>- Suplier< T >: No argument, return type(T) → ```Supplier<Double> randomValue = () -> Math.random();```

|    Method     |             Definition              |        Use        |
| :-----------: | :---------------------------------: | :---------------: |
| ```T get()``` | return the object the type provided | randomValue.get() |

## Interface UnaryOperator< T >

>- UnaryOperator< T >: input type(T), return type(T) → ```UnaryOperator<String> upper = x -> x.toUpperCase();```

|     Method      |                              Definition                               |            Use             |
| :-------------: | :-------------------------------------------------------------------: | :------------------------: |
| ```T apply()``` | returns an object of the same type as the type of the passed argument | ```upper.apply("test");``` |

## Interface BinaryOperator< T >

>- BinaryOperator< T >: input type(T), second input type(T), return type(T) → 

```Java
BinaryOperator<String> upper = (x, y) -> x.toUpperCase().concat(y.toUpperCase());
```

|     Method      |                              Definition                               |                 Use                  |
| :-------------: | :-------------------------------------------------------------------: | :----------------------------------: |
| ```T apply()``` | returns an object of the same type as the type of the passed argument | ```upper.apply("hello", "world");``` |

[^1]: No apply for interfaces BiFunction
[^2]: No apply for interfaces BiConsumer

## Read file with Lambdas

```Java
public static void main(String[] args) {
    Path File = Paths.get("src/main/resources/lambdas.txt");

    try(Stream<String> lines = Files.lines(file).onClose(() -> System.out.println("Closing reader"))) {
        lines.forEach(System.out::println);
    } catch(IOException e) {
        e.printStackTrace();
    }
}
```

## Runnable and Callable

```Java
static Runnable printerSum = () -> {
    long sum = 0;
    System.out.println(Thread.currentThread().getName());
    for (int i = 0; i < 100 000; i++) {
        sum += i;
    }
    System.out.println("Total: " + sum);
}

static Callable<Long> getSum = () -> {
    long sum = 0;
    System.out.println(Thread.currentThread().getName());
    for (int i = 0; i < 100 000; i++) {
        sum += i;
    }
    return sum;
}

public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println(Thread.currentThread().getName());
    
    var exec = Executors.newSingleThreadExecutor();
    exec.submit(printerSum);

    var result = exec.submit(getSum);
    System.out.println("Result " + result.get());

    exec.shutdown();
}
```

## Stream

Object for operations of search, filter and collection
> ```Stream<Integer> myStream = anyCollection.Stream()```
> ```Stream<Integer> myStream = Arrays.Stream(anyArray)```
> ```Stream<Integer> myStream = Stream.of(1, 2, 3)```
> ```IntStream myStream = IntStream.range(1, 10)```

### Intermediate and final methods

>- Intermediate methods: return other stream
>- Final methods: close and end the stream

#### Final methods

- ```count(): returns total elements```
- ```forEach(Consumer <? extends T> consumer): perform an action for aech element```
- ```reduce(BinaryOperator<? super T> accumulator): reduces all elements to a single element```
- ```max(Comparator<? super T> comparator): return the largest element based on the comparator```
- ```min(Comparator<? super T> comparator): return the smallest element based on the comparator```
- ```findFirst(): returns the first element in an optional object```
- ```findAny(): returns a random element in an optional object```
- ```anyMatch(Predicate<? super T> predicate): returns true if it finds a elemnt that matches the predicate```
- ```allMatch(Predicate<? super T> predicate): returns true if all elements match the predicate```
- ```noneMatch(Predicate<? super T> predicate): returns true if none of the elements match the predicate```

#### Intermediate methods

- ```distinct(): returns a new stream removing repeated elements```
- ```limit(long n): returns a new stream with the first n elements```
- ```skip(long n): returns a new stream with the elements skipping the first n values```
- ```peek(Consumer<? extends T> consumer): view and manipulate elements as they flow (as an intermediated forEach)```
- ```sorted(Comparator<? extends T> comparator): sorts elements based on a comparator```
- ```filter(Predicate<? super T> predicate): return the elements that satisfy the predicate```
- ```map(Function<? super T> mapper): transform each elements```
- ```flatMap(Function<T, stream<R>> mapper): From multidimesional to one-dimensional```
- ```takeWhile(Predicate<? super T> predicate): gets the elements before the element that satisfies the predicate, it is inclusive. It is recommended to first sort the stream```
- - ```dropWhile(Predicate<? super T> predicate): gets the elements after the element that satisfies the predicate, it is inclusive. It is recommended to first sort the stream```

### Pipeline

chain of connected processes such that the output of each element is the input of the next

## Collectors

It is used to collect, accumulate, reduce. It is a final operation

### Convert to mutable collection

```Java
stream.collect(Collectors.toList())
stream.collect(Collectors.toSet())
stream.distinct().collect(Collectors.toMap(Class::methodName, Class::methodName))
```

### Convert to inmutable collection

```Java
stream.collect(Collectors.toUnmodifiableList())
stream.collect(Collectors.toUnmodifiableSet())
stream.distinct().collect(Collectors.toUnmodifiableMap(Class::methodName, Class::methodName))
```

### Partitions

returns a map with 2 keys: true with the list that satisfies the predicate and false with those that do not comply

```Java
Map<Boolean, List<T>> partition = collectionName.collect(Collectors.partitioningBy(Predicate<? super T> predicate))
```

### Groupings

return a map with the grouping term as key and the elements that meet the grouping criterion as the value of the map

```Java
Map<T, List<U>> partition = collectionName.collect(Collectors.groupingBy(Predicate<? super T> predicate))
```

### Statistics

>- summarizingInt || Double || Long → returns an object with the total, maximum, minimum and sum of the values ​​passed by the function
>- averagingDouble || Int || Long → calculates the average from the values ​​passed by function
>- joining → concatenates the elements of the stream, they must first be transformed to a string stream
