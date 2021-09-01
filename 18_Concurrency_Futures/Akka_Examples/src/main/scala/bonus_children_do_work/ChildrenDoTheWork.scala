package r98_children_do_work

import akka.actor.typed.{ActorRef, ActorSystem, Behavior, PostStop}
import akka.actor.typed.scaladsl.{ActorContext, Behaviors}

/**
 * This is some code that didn’t make it into the Cookbook.
 * The recipe was going to be about how a Parent actor should
 * (always) delegate work to a Child actor. The Akka mantra is
 * "Delegate, delegate, delegate."
 */

object ChildrenDoTheWork extends App {
    val actorSystem: ActorSystem[Parent.MessageToParent] = ActorSystem(
        Parent(),
        "ParentChildSystem"
    )
    actorSystem ! Parent.HelloParent
    actorSystem ! Parent.TakeOutTheTrash
    actorSystem ! Parent.WashTheDishes
    Thread.sleep(500)

    // shut down the system
    actorSystem.terminate()
}

object Parent {

    sealed trait MessageToParent
    final case object HelloParent extends MessageToParent
    final case object TakeOutTheTrash extends MessageToParent
    final case object WashTheDishes extends MessageToParent

    // the factory method that lets other create new Parent instances
    def apply(): Behavior[MessageToParent] = Behaviors.setup { context: ActorContext[MessageToParent] =>

        // create two children
        val child1: ActorRef[Child.MessageToChild] = context.spawn(Child(), "Child_1")
        val child2: ActorRef[Child.MessageToChild] = context.spawn(Child(), "Child_2")

        // pass all the long-running work to the children
        Behaviors.receiveMessage { message: MessageToParent => 
            message match {
                case HelloParent =>
                    println("Parent: Hi, I’m the parent. I do as little work as possible.")
                    child1 ! Child.HelloChild
                    Behaviors.same
                case TakeOutTheTrash =>
                    child1 ! Child.TakeOutTheTrash
                    println("Parent: LOL, the Child is taking out the trash.")
                    Behaviors.same
                case WashTheDishes =>
                    child2 ! Child.WashTheDishes
                    println("Parent: LOL, the Child is washing the dishes.")
                    Behaviors.same
            }
        }
    }
}

object Child {

    sealed trait MessageToChild
    final case object HelloChild extends MessageToChild
    final case object TakeOutTheTrash extends MessageToChild
    final case object WashTheDishes extends MessageToChild

    // the factory method that lets other create new Child instances
    def apply(): Behavior[MessageToChild] = { Behaviors.receive[MessageToChild] { (context, message) =>
        message match {
            case HelloChild =>
                println("Child: I’m the child. I do all the work.")
                Behaviors.same
            case TakeOutTheTrash =>
                println("Child: *sigh* I’m taking out the trash.")
                takeOutTheTrash
                Behaviors.same
            case WashTheDishes =>
                println("Child: Yeah, yeah, I’m washing the dishes.")
                washTheDishes
                Behaviors.same
        }
    }}

    // simulate some long-running-tasks
    private def takeOutTheTrash(): Unit = Thread.sleep(100)
    private def washTheDishes(): Unit = Thread.sleep(200)

}


