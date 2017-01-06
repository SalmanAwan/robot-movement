## Robot Movement

The application is a simulation of a toy robot moving on a square
tabletop, of dimensions 5 units x 5 units.

### Assumptions
* This robot is prototype only so does not have to support many terrains

### Improvements
* Add javadoc documentation notes for methods
* Add computational complexity notes
* Update Check out sources section with git repo url once pushed to Git
* Add jacoco code coverage support
 
### Build

##### Prerequisites
* [Git][]
* [JDK 8][JDK8]

> **Note:** Be sure that your `JAVA_HOME` environment variable is properly set

##### Check out sources
`git clone <URL to Git Repo>`

##### Generate jar

`gradlew clean build`

## Test

`gradlew clean check jacocoTestReport`

Coverage Report:`<PROJECT_ROOT>/build/reports/jacoco/test/html/index.html`

Tests Report:`<PROJECT_ROOT>/build/reports/tests/test/index.html`


## Run

In project root `run` batch file


## License
The Robot Movement is released under version 2.0 of the [Apache License][].


[Git]: http://help.github.com/set-up-git-redirect
[JDK8]: http://www.oracle.com/technetwork/java/javase/downloads
[Apache License]: http://www.apache.org/licenses/LICENSE-2.0