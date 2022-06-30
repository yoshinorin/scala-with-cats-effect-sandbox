package sandbox

import cats.effect.IO
import cats.effect._
import cats.effect.testing.specs2.CatsEffect
import org.specs2.mutable.Specification
import cats.effect.unsafe.implicits.global

// testOnly sandbox.ExampleSpec
class ExampleSpec extends Specification with CatsEffect {
  "examples" should {
    "say hello" in {
      HelloWorld.say().map(_ === "Hello Cats!")
    }
  }
}
