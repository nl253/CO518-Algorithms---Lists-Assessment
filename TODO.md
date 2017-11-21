
# CO518 Algorithms - Lists Assessment

The particular data structure you are meant to provide are singly-linked
lists. 

You are given a basic implementation which is to be extended in `List.zip`. 

The above picture shows how we will be representing our linked lists,
 here the list `[2,5,7,3,6]`.

The boxes with the sharp corners stand for objects of class `Node<Integer>`.

The Node class is already provided and **need not (and should not) be modified**.
The box with the rounded corners would be an object of our new
`SinglyLinkedList` class, which is yet to be written.
This has fields pointing to both the first and last Node cell of the
linked list (if the list is empty these references should be both null),
and possibly further fields.

---------------------------------------------------------------------

* Write the generic class `SinglyLinkedList<E>`. This should extend `AbstractSequentialList` (from java.util).  
     - We want two constructors for the class;
        + a parameterless one to produce an empty list
        + one whose parameter is a `Collection` 

* Write the method `ListIterator<E> listIterator(int pos)`, for details see
the description in `AbstractSequentialList`. This method will typically just
create s suitable object and return it.

* Write a `int size()` method that returns the size of the collection. The
method should just lookup a field 

* Write the method `boolean add(E elem)` in which you add an element to the end of a list 
    - the method will always return true. 
    - Your implementation should instead operate in O(1) time.

* Write the generic class `SinglyListIterator<E>`. This should be an instance of
the interface `ListIterator<E>` (from java.util) and provide us with the objects
we need to produce to iterate through a singly linked lists.  
    - These are the kind of objects the `listIterator` method of class `SinglyLinkedList` should
return. 
    - The interface `ListIterator` has **9 methods, 3 of which are optional**; 
    - **the 2 optional methods remove and set you should leave unimplemented**. 

For the specification of these methods look at the API for `ListIterator`.
design the class - which fields you will need you may have to figure out
from putting the rest of the code together, so do not expect to get it
completely right in advance. 

For the constructor of the class though you can take some inspiration from
the `listIterator` method of `SinglyLinkedList` class, because this is
point at which these objects need to be created.

### Write: 

#### O(1) time
- `hasNext`, 
- `hasPrevious`, 
- `next`, 
- `nextIndex`, 
- `previousIndex`. 
- `void add(E elem)`

#### O(n) time
- `previous`

----------------------------------------------------------------
Marks: 10% each for 1a, 1b, 2a, 2b. 15% each for 1c, 1d, 2c, 2d.
