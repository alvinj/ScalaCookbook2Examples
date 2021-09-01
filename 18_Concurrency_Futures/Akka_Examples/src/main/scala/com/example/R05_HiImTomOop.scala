package r05_hi_im_tom_oop

import akka.actor.typed.Behavior
import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.ActorContext
import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.scaladsl.AbstractBehavior


// p. 539
object Tom {
    // “messages” that Tom can handle
    sealed trait Message
    case object Hello extends Message

    // the factory/constructor method
    def apply(): Behavior[Message] =
        Behaviors.setup(context => new Tom(context))
}


// pp. 539-540
import Tom.{Message, Hello}
private class Tom(context: ActorContext[Message])
extends AbstractBehavior[Message](context) {
    override def onMessage(message: Message): Behavior[Message] = {
        message match {
            case Hello => 
                println("Hi, I’m Tom.")
                this  // return the current behavior
                // Behaviors.same
        }
    }
}


object HiImTomOop extends App {
    val actorSystem: ActorSystem[Tom.Message] =
        ActorSystem.create(Tom(), "50FirstDatesSystem")

    actorSystem ! Tom.Hello
    actorSystem ! Tom.Hello
    actorSystem ! Tom.Hello

    Thread.sleep(500)
    actorSystem.terminate()
}


/* p. 542, THE OOP-STYLE TEMPLATE
object OopActor {
    // “messages” that OopActor can handle
    sealed trait Message
    final case object Message1 extends Message
    final case class Message2(param: SomeType) extends Message

    // the factory/constructor method
    def apply(): Behavior[Message] =
        Behaviors.setup(context => new OopActor(context))
}

private class OopActor(context: ActorContext[OopActor.Message])
extends AbstractBehavior[OopActor.Message](context) {
    override def onMessage(msg: OopActor.Message): Behavior[OopActor.Message] =
        msg match
            case Message1 =>
                // handle this message here
                Behaviors.same
            case Message2(param) =>
                // handle this message here
                Behaviors.same
}

*/




