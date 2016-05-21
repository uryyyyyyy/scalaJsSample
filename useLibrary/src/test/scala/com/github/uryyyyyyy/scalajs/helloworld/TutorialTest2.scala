package com.github.uryyyyyyy.scalajs.helloworld

import org.scalatest._

class TutorialTest2 extends FunSpec with Matchers {

  describe("User") {
    it("should have the original name") {
      User("Joe", "Smith").name shouldEqual "Joe"
    }

    it("should throw exception if last name is empty") {
      intercept[IllegalArgumentException] {
        User("Hmm", "")
      }
    }
  }
}

case class User(name: String, lastName: String) {

  require(!name.isEmpty, "Name can't be empty")
  require(!lastName.isEmpty, "Last name can't be empty")
}
