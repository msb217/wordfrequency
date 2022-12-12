## Compiling
From the root project folder
`./gradlew clean assemble`

## Running (Java 11)
* No args runs the default case
```
➜  java -jar build/libs/wordfrequency-1.0-SNAPSHOT.jar
the 2
in 1
cat 1
bag 1
is 1
```
* Custom input
```
➜  java -jar build/libs/wordfrequency-1.0-SNAPSHOT.jar --input "ugh blah blah blah I'm ugh ugh I'M YELLING blah blah ugh blah ugh boom DON'T YeLl AT me i am hungry blah"
blah 7
ugh 5
im 2
hungry 1
at 1
yell 1
boom 1
yelling 1
me 1
i 1
am 1
dont 1
```

## Assumptions
* Words are separated by whitespace
* Punctuation and capitalization are irrelevant w/ respect to equality. (Ex. I'm == im)
* Words only contain alphabetic characters. Non alphabetic characters are simply ignored.
