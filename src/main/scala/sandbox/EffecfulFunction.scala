package sandbox

import cats.Monad
import cats.effect.std.Console
import cats.syntax.all._

object EffecfulFunction {

  def example[F[_]: Monad: Console](str: String): F[String] = {
    val printer: F[Unit] = Console[F].println(str)
    (printer >> printer).as(str)
  }

  // sandbox.EffecfulFunction.example[IO]("Hello World")
  //val res: cats.effect.IO[String] = IO(...)

}
