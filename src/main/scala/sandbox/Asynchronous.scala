package sandbox

import cats.effect.IO
import java.util.concurrent.{Executors, TimeUnit}

object Asynchronous {
  val scheduler = Executors.newScheduledThreadPool(1)

  IO.async_[Unit] { cb =>
    scheduler.schedule(new Runnable {
      def run = cb(Right(()))
    }, 500, TimeUnit.MILLISECONDS)
  }

  ()
}
