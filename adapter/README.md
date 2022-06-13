# Adapter Design Pattern

Intent: "Convert the interface of a class into another interface clients expect. Adapter lets classes work
together that couldn’t otherwise because of incompatible interfaces." (GoF 1994, p. 139)

The adapter pattern’s goal is to make objects work together, even if they have incompatible interfaces.
It is the diplomat of patterns. The adapter pattern can be implemented either as an object adapter that
uses composition or as a class adapter that uses inheritance.

An example of an object adapter in Java is the InputStreamReader, which adapts an InputStream into a
Reader.