package sandbox

import cats.effect.IOApp
import cats.effect.IO
import cats.effect._

object Hi extends IOApp.Simple {
  // メインファイバー（IOAppを継承した run ）
  val run: IO[Unit] = IO.println("Hello") >> IO.println("World")
}
