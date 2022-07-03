package sandbox

import cats.effect.IO
import scala.concurrent.duration._

object Cancelation {
  lazy val loop: IO[Unit] = IO.println("Hello, World!") >> loop
  loop.timeout(5.seconds)
}
