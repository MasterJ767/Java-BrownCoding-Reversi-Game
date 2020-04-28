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

* v1.1.3 [2020-04-21]: Bug Fixes
    - Logic Error: corrected the first test condition in the `generateOpponentDark` and 
    `generateOpponentLight` methods in the `MoveCheckerTest.java`.
    - Logic Error: changed `d_col += dir[0];` to `d_col += dir[1];` so that the correct cells
    are checked in the `isLegal` method of the `Cell.java` file.
    - Logic Error: added a condition to the `flipPieces` method in the `MoveChecker.java`
    in order to prevent the program from attempting to flip pieces off the board or flip
    pieces infinitely.
    - Logic Error: swapped the variables `colour` and `CellStatus.EMPTY` in the if conditions
    present in the `isLegal` method of the `MoveChecker.java` file. This has made the is legal method
    correctly identify  legal moves.
    
* v1.1.4 [2020-04-22]: Bug Fixes
    - Logic Error: corrected the `getRow` method in the `Cell.java` file by correctly returning the 
    row and not the column.
    - Logic Error: changed the `flipPieces` method in the `MoveChecker.java` file so that the empty cell at the start of the move is
    coloured before the while loop starts which colours all the pieces between. 
    
* v1.1.5 [2020-04-22]: Test Fixes
    - Logic Error: reversed the changes made to the first test condition in the 
    `generateOpponentDark` and `generateOpponentLight` methods in the `MoveCheckerTest.java` in v1.1.3 and then
    changed the logical operator from `&&` to `||` in order to correctly compare the conditions.
    - Assertion Error: corrected the checking condition in the `findPotentialMoves` test method in the 
    `MoveCheckerTest.java` as it wrongly asserted that there should be 5 potential moves when there should 
    only be 4.
    
* v1.1.6 [2020-04-22]: Bug Fixes
    - Logic Error: changed the logical operator in the condition of the while loop in the
    `flipPieces method` in the `MoveChecker.java` file from `&&` to `||`. Now pieces are correctly flipped.  
    
* v1.1.7 [2020-04-23]: Bug Fixes
    - Logic Error: changed `this.cells[column][row].getValue()` to `this.cells[row][column].getValue()` in the
    `getFinalScore` method of the `MoveChecker.java` file so that cells on the board were correctly searched for the final
    score count.
    - Logic Error: corrected the test condition in the `getFinalScore` test in the `MoveCheckerTest.java` file.
    
* v1.1.8 [2020-04-27]: Bug Fixes
    - Logic Error: added a code block to the `movePlayer` method in the `MainPanel.java` file so that when the opponent 
    is unable to move the game ends correctly.
    
* v1.1.9 [2020-04-28]: Bug Fixes
    - Logic Error: made some minor tweaks to the fix in v.1.1.8