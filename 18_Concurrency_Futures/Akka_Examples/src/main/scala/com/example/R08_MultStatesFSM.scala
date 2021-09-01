package r08_fsm_superman

import akka.actor.typed.{ActorRef, ActorSystem, Behavior}
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}

// pp. 552-554

sealed trait BaseBehaviors

// clark kent actions
sealed trait ClarkKentBehaviors extends BaseBehaviors
final case object WorkAtNewspaper extends ClarkKentBehaviors
final case object PutOnGlasses extends ClarkKentBehaviors
final case object BecomeSuperman extends ClarkKentBehaviors

// superman actions
sealed trait SupermanBehaviors extends BaseBehaviors
final case object Fly extends SupermanBehaviors
final case object SavePeople extends SupermanBehaviors
final case object BecomeClarkKent extends SupermanBehaviors


object ClarkKent {

    // initial state
    def apply(): Behavior[BaseBehaviors] = clarkKentState()

    private def clarkKentState(): Behavior[BaseBehaviors] =
    Behaviors.receiveMessagePartial[BaseBehaviors] { message: BaseBehaviors =>
        message match {
            case WorkAtNewspaper =>
                println("normalState: WorkAtNewspaper")
                Behaviors.same
            case PutOnGlasses =>
                println("normalState: PutOnGlasses")
                Behaviors.same
            case BecomeSuperman =>
                println("normalState: BecomeSuperman")
                supermanState()
        }
    }

    /**
     * `Behaviors.receiveMessagePartial`: Construct an actor `Behavior` from a 
     * partial message handler which treats undefined messages as unhandled.
     */
    private def supermanState(): Behavior[BaseBehaviors] =
    Behaviors.receiveMessagePartial[BaseBehaviors] { message: BaseBehaviors =>
        message match {
            case Fly =>
                println("angryState: Fly")
                // supermanState()
                Behaviors.same
            case SavePeople =>
                println("angryState: SavePeople")
                // supermanState()
                Behaviors.same
            case BecomeClarkKent =>
                println("normalState: BecomeClarkKent")
                clarkKentState()
        }
    }

}


object ClarkKentApp extends App {

    val actorSystem: ActorSystem[BaseBehaviors] = ActorSystem(
        ClarkKent(),
        "SupermanSystem"
    )
    actorSystem ! WorkAtNewspaper

    // these will fail because the system is in the wrong state
    actorSystem ! Fly
    actorSystem ! SavePeople
    actorSystem ! BecomeClarkKent

    // this will work
    actorSystem ! WorkAtNewspaper

    // now these will work
    actorSystem ! BecomeSuperman
    actorSystem ! Fly
    actorSystem ! SavePeople
    actorSystem ! BecomeClarkKent
    
    Thread.sleep(500)
    actorSystem.terminate()

}





