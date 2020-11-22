package com.amrita.designpattern.factory;

//Car interface

public interface Car {
	
 String getDescription();
 
 //by default, this method is public abstract
  //interface method cannot be static or final. but in java 1.8, static methods are allowed.
 //final method cannot be overridden.
 
 
}

/*
 * Java 8 permits static interface methods
With Java 8, interfaces can have static methods. They can also have concrete instance methods, but not instance fields.

There are really two questions here:

Why, in the bad old days, couldn't interfaces contain static methods?
Why can't static methods be overridden?
Static methods in interfaces
There was no strong technical reason why interfaces couldn't have had static methods in previous versions. This is summed up nicely by the poster of a duplicate question. Static interface methods were initially considered as a small language change, and then there was an official proposal to add them in Java 7, but it was later dropped due to unforeseen complications.

Finally, Java 8 introduced static interface methods, as well as override-able instance methods with a default implementation. They still can't have instance fields though. These features are part of the lambda expression support, and you can read more about them in Part H of JSR 335.
-----------------------------------------------------------------
Overriding static methods
The answer to the second question is a little more complicated.

Static methods are resolvable at compile time. Dynamic dispatch makes sense for instance methods, where the compiler can't determine the concrete type of the object, and, thus, can't resolve the method to invoke. But invoking a static method requires a class, and since that class is known statically—at compile time—dynamic dispatch is unnecessary.

A little background on how instance methods work is necessary to understand what's going on here. I'm sure the actual implementation is quite different, but let me explain my notion of method dispatch, which models observed behavior accurately.

Pretend that each class has a hash table that maps method signatures (name and parameter types) to an actual chunk of code to implement the method. When the virtual machine attempts to invoke a method on an instance, it queries the object for its class and looks up the requested signature in the class's table. If a method body is found, it is invoked. Otherwise, the parent class of the class is obtained, and the lookup is repeated there. This proceeds until the method is found, or there are no more parent classes—which results in a NoSuchMethodError.

If a superclass and a subclass both have an entry in their tables for the same method signature, the sub class's version is encountered first, and the superclass's version is never used—this is an "override".

Now, suppose we skip the object instance and just start with a subclass. The resolution could proceed as above, giving you a sort of "overridable" static method. The resolution can all happen at compile-time, however, since the compiler is starting from a known class, rather than waiting until runtime to query an object of an unspecified type for its class. There is no point in "overriding" a static method since one can always specify the class that contains the desired version.

Constructor "interfaces"
Here's a little more material to address the recent edit to the question.

It sounds like you want to effectively mandate a constructor-like method for each implementation of IXMLizable. Forget about trying to enforce this with an interface for a minute, and pretend that you have some classes that meet this requirement. How would you use it?

class Foo implements IXMLizable<Foo> {
  public static Foo newInstanceFromXML(Element e) { ... }
}

Foo obj = Foo.newInstanceFromXML(e);
Since you have to explicitly name the concrete type Foo when "constructing" the new object, the compiler can verify that it does indeed have the necessary factory method. And if it doesn't, so what? If I can implement an IXMLizable that lacks the "constructor", and I create an instance and pass it to your code, it is an IXMLizable with all the necessary interface.

Construction is part of the implementation, not the interface. Any code that works successfully with the interface doesn't care about the constructor. Any code that cares about the constructor needs to know the concrete type anyway, and the interface can be ignored.
*/
