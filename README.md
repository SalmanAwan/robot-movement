## Robot Movement

Simulation of a toy robot moving on a terrain of dimensions 5 units x 5 units.

##### Assumptions
* Robot is terrain aware thus owns the decisions of navigating around terrain it is currently exploring.
* Robot will ignore all commands in the sequence until a valid PLACE command has been executed.
* This robot is prototype only so does not have to support many terrains, however design has flexibility to add more.
* The origin (0,0) is considered to be the SOUTH WEST most corner.

##### Design Choices
* TDD is followed which is reflected in code commit history.
* Used variant of `Command Pattern` to decouple command issuer from robot.
* For 100% code coverage, `switch` statements with `enum` are avoided.
* Java 8 `Streams` and `Optionals` api is used selectively where it made sense.

##### Performance
Time complexity is `O(n)` where `n` is number of commands in text file.
This solution is also upper bound by File I/O latency. 


### Build & Run

* Prerequisites [Git][] and [JDK 8][JDK8]
* Checkout code from [GitHub Repo][]
* Execute `run` in project root


## Test & Coverage

Execute `test` in prjoect root

Test Report:`<PROJECT_ROOT>/build/reports/tests/test/index.html`

Code Coverage: `<PROJECT_ROOT>/build/reports/jacoco/test/html/index.html`

## Docs

Execute `docs` in project root

Java Docs `<PROJECT_ROOT>/build/docs/javadoc/index.html`


## License
The Robot Movement is released under version 2.0 of the Apache License.


[Git]: http://help.github.com/set-up-git-redirect
[GitHub Repo]: https://github.com/SalmanAwan/robot-movement.git
[JDK8]: http://www.oracle.com/technetwork/java/javase/downloads
