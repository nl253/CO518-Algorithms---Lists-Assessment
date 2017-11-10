
# CO518 Algorithms - Lists Assessment

The purpose of this assessment is to realize a Java library extension for
collections, providing a mixture of bespoke and inherited methods. The
bespoke methods are needed partially to realize the extension at all,
and partially to override the slow default implementation with one that
exploits the specifics of the data structure. 

The particular data structure you are meant to provide are singly-linked
lists. Note that the `LinkedList` class provided by the Java library are
doubly linked lists.

You are given a basic implementation which is to be extended in
`List.zip`. 

Generally you will have to write two generic classes for this assessment. As
a general reminder, in a class header where you implement an interface or
extend a class by writing something possibly complicated like:

```java
class Rupert<A,B> extends Smith<Bingo<A> Bongo<B,A>> {}
```

the type parameters (here: for Rupert) that occur before the extends (or
implements) are viewed as type variables, and these occurrences actually
declare those variables.

The type parameters (here: for Smith) that occur after the extends (or
implements) are type expressions which can make use of the type variables
that have been declared earlier.

The simpler looking and most common case of class `Rupert<A>` extends `Smith<A>` is really just a
special case of this principle. In `List.zip` you find the Node class defined
with the header class `Node<A>` extends Pair`<A,Node<A>>` which you can read as:
as Node with component type A is just a Pair whose first component type is
A and whode second component type is a Node with component type A.
linked list with access to last cell
The above picture shows how we will be representing our linked lists,
here the list `[2,5,7,3,6]`.

The boxes with the sharp corners stand for objects of class `Node<Integer>`.

The Node class is already provided and **need not (and should not) be modified**.
The box with the rounded corners would be an object of our new
`SinglyLinkedList` class, which is yet to be written.
This has fields pointing to both the first and last Node cell of the
linked list (if the list is empty these references should be both null),
and possibly further fields.

Note that it would principally suffice to have access to the first cell
only, but some operations of the API for Collection operate at the end of
a collection, so the presence of that direct link permits us to implement
these operations more effectively.

---------------------------------------------------------------------

* Write the generic class `SinglyLinkedList<E>`. This should extend
`AbstractSequentialList` (from java.util).  We want two constructors for
the class; a parameterless one to produce an empty list, and one whose
parameter is a `Collection` - in which case the resulting new list should
contain all the objects of that collection.

[...]

* Write the method `ListIterator<E> listIterator(int pos)`, for details see
the description in `AbstractSequentialList`. This method will typically just
create s suitable object and return it.

* Write a `int size()` method that returns the size of the collection. The
method should just lookup a field - marks for this question will indicate
the extend to which you have maintained that field correctly in other parts
of the implementation.

* Write the method `boolean add(E elem)` in which you add an element to the end
of a list; the method will always return true. Note that we would inherit a
fully functioning add method from the superclass (as long as we implement
`listIterator`), but this method is inefficient. Your implementation should
instead operate in O(1) time.

* Write the generic class `SinglyListIterator<E>`. This should be an instance of
the interface `ListIterator<E>` (from java.util) and provide us with the objects
we need to produce to iterate through a singly linked lists.  These are the
kind of objects the `listIterator` method of class `SinglyLinkedList` should
return. The interface `ListIterator` has **9 methods, 3 of which are optional**;
**the 2 optional methods remove and set you should leave unimplemented**. 

For the specification of these methods look at the API for `ListIterator`.
design the class - which fields you will need you may have to figure out
from putting the rest of the code together, so do not expect to get it
completely right in advance. 

For the constructor of the class though you can take some inspiration from
the `listIterator` method of `SinglyLinkedList` class, because this is
point at which these objects need to be created.

Write the required methods: 

- `hasNext`, 
- `hasPrevious`, 
- `next`, 
- `nextIndex`, 
- `previousIndex`. 

* All of these methods should operate in O(1) time.  write the (optional) `void add(E elem)` 
method - this should also operate in O(1) time.  

* Write the required method: `previous`. This method can operate in O(n) time,
where n is the length of the list. 

In essence, singly linked lists are good for going forwards and bad for
going backwards.
Normally, we should avoid using this method because of its inefficiency,
but it needs to be provided because the interface demands it.

----------------------------------------------------------------

Marks: 10% each for 1a, 1b, 2a, 2b. 15% each for 1c, 1d, 2c, 2d.
