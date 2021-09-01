package r06_hi_im_tom_fp

import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.{ActorContext, Behaviors}


// p. 543
object Tom {

    // the “messages” this actor can respond to
    sealed trait Message
    final case object Hello extends Message

    // the factory method
    def apply(): Behavior[Message] = Behaviors.setup {
        context: ActorContext[Message] =>
            Behaviors.receiveMessage { message: Message =>
                message match {
                    case Hello =>
                        println("Hi, I’m Tom.")
                        Behaviors.same
                }
            }
    }
}


// p. 544
object HiImTomFp extends App {
    import Tom.{Message, Hello}
    val actorSystem: ActorSystem[Message] = ActorSystem(
        Tom(),
        "50FirstDatesSystem"
    )
    actorSystem ! Hello
    actorSystem ! Hello
    actorSystem ! Hello

    Thread.sleep(500)
    actorSystem.terminate()
}





