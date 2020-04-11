# CHANGELOG

* v1.1.0 [2020-04-11]: First major release. This version is known to contain some bugs.

* v1.1.1 [2020-04-11]: Bug Fixes
    - Syntax Error: added the missing semi-colon to the `import uk.ac.ncl.entity.Cell` 
    statement at the top of the `MoveCheckerTest.java` file.
    - Syntax Error: added the missing parentheses around the condition on an `else if`
    statement in the `getFinalScore()` method in the `MoveChecker.java` file.
    - Logic Error: fixed the `NullPointerException` on line 78 of the `MoveChecker.java`
    file by assigning values to the `cells` parameter in the class constructor.
    - Logic Error: changed the `<=` symbols to `<` in the `MoveChecker.java` file as the
    comparison was causing the program to search indexes in the array that didn't exist
    