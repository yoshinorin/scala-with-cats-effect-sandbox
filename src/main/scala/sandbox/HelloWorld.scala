package sandbox

import cats.effect.IO
import cats.effect._
import cats.effect.cps._

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

  def ignoreFirstEffect(): IO[Unit] = {
    IO.println("Hello") >> IO.println("World")
    // ほぼおなじ IO.println("Hello") *> IO.println("World")
  }
  /*
  scala> import cats.effect.unsafe.implicits.global
  import cats.effect.unsafe.implicits.global

  scala> sandbox.HelloWorld.ignoreFirstEffect().unsafeRunSync()
  Hello
  World
  */

  def asyncPrint(): Unit = async[IO] {
    IO.println("Hello").await
    IO.println("World").await
  }
}
