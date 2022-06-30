package sandbox

import cats.effect.IO
import cats.effect._

object HelloWorld {

  def say(): IO[String] = IO.delay("Hello Cats!")

  def print(): IO[Unit] = {
    IO.println("Hello") flatMap { _ =>
      IO.println("World")
    }
  }
  /*
  scala> import cats.effect.unsafe.implicits.global
  import cats.effect.unsafe.implicits.global

  scala> sandbox.HelloWorld.print().unsafeRunSync
  Hello
  World
  */

  def printForComprehensions(): IO[Unit] = {
    for {
      _ <- IO.println("Hello")
      _ <- IO.println("World")
    } yield ()
  }
  /*
  scala> import cats.effect.unsafe.implicits.global
  import cats.effect.unsafe.implicits.global

  scala> sandbox.HelloWorld.printForComprehensions().unsafeRunSync()
  Hello
  World
  */
}
