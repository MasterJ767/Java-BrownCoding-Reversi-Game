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

* v1.1.2 [2020-04-14]: Bug Fixes
    - Logic Error: modified the conditions of the second if statement in the `islegal`
    in the `Cell.java` file on line 133. Added a comparison to ensure that the 
    variable `d_row` was less than the width of the board and combined the conditions of
    third if statement into the second one as having them separate was redundant. Following
    these changes the game window now appears.
    - Syntax Error: added brackets around the condition in the Stream if statement in the
    `isLegal` method on line 115 of the `Cell.java` file.
    