## scalaJS helloWorld

## abstract

it contains only DOM/jQUery

## usage

./activator helloWOrld/fastOptJS
open index.html

## test

I use scalaTest.(not uTest)

currently, intellij don't support scalajs test may be.
(it cause RuntimeException when use DOM)

so, should use sbt(activator)

```
$ ./activator
> projest helloWOrld

# test only contains <str> at test name
# ex). testOnly * -- -z <str>
> testOnly * -- -z <str>

# test only tag
> testOnly * -- -n <tagName>

# test only class
> testOnly com.github.uryyyyyyy.scalajs.helloworld.TutorialTest
> testOnly com.github.uryyyyyyy.scalajs.helloworld.*
```