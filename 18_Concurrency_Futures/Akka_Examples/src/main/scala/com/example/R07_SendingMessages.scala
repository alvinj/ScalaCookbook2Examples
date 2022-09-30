package r07_sending_messages

import akka.actor.typed.{ ActorRef, ActorSystem, Behavior }
import akka.actor.typed.scaladsl.{ AbstractBehavior, ActorContext, Behaviors }

// pp. 547-548
object ThermostatActor {

  // our API, i.e., the messages we can respond to are
  // enumerated here ...
  import ThermostatSupervisor.{ StringMessage, SystemMessage }

  // our API, i.e., the messages we can respond to
  sealed trait MessageToThermostat {
    def sender: ActorRef[SystemMessage]
  }
  final case class CurrentTemperature(sender: ActorRef[SystemMessage]) extends MessageToThermostat

  final case class IncreaseTemperature(
    sender: ActorRef[SystemMessage],
    amount: Int
  ) extends MessageToThermostat

  final case class DecreaseTemperature(
    sender: ActorRef[SystemMessage],
    amount: Int
  ) extends MessageToThermostat

  var currentTemp = 72

  // we respond to `MessageToThermostat` queries
  def apply(): Behavior[MessageToThermostat] = Behaviors.setup { context: ActorContext[MessageToThermostat] =>
    Behaviors.receiveMessage { message =>
      message match {
        case CurrentTemperature(sender) =>
          sendReply(sender)
          Behaviors.same
        case IncreaseTemperature(sender, amount) =>
          currentTemp += amount
          sendReply(sender)
          Behaviors.same
        case DecreaseTemperature(sender, amount) =>
          currentTemp -= amount
          sendReply(sender)
          Behaviors.same
      }
    }
  } // Behaviors.setup/apply

  private def sendReply(sender: ActorRef[SystemMessage]) = {
    val msg = s"Thermostat: Temperature is $currentTemp degrees"
    println(msg)
    sender ! StringMessage(msg)
  }
}

// pp. 548-549
// import the “messages” from the ThermostatActor
import ThermostatActor._

object ThermostatSupervisor {

  // these are the messages we can receive. some will be sent to us from the
  // App, which you’ll see shortly. others are sent to us by the
  // ThermostatActor.
  sealed trait SystemMessage
  case object StartSendingMessages      extends SystemMessage
  case object StopSendingMessages       extends SystemMessage
  case class StringMessage(msg: String) extends SystemMessage

  // this is the usual `apply` template.
  def apply(): Behavior[SystemMessage] = Behaviors.setup[SystemMessage] { actorContext =>

    // when we’re created, the first thing we do is create a
    // ThermostatActor. technically, it is a “child” to us.
    val thermostat = actorContext.spawn(
      ThermostatActor(),
      "ThermostatActor"
    )

    // this is where we set up the handling of messages that can be
    // sent to us.
    Behaviors.receiveMessage {
      // when we receive the message StartSendingMessages,
      // send three messages to the ThermostatActor.
      case StartSendingMessages =>
        thermostat ! CurrentTemperature(actorContext.self)
        thermostat ! IncreaseTemperature(actorContext.self, 1)
        thermostat ! DecreaseTemperature(actorContext.self, 2)
        Behaviors.same
      case StopSendingMessages =>
        Behaviors.stopped
      case StringMessage(msg) =>
        println(s"MSG: $msg")
        Behaviors.same
    }
  }
}

// pp. 549-550
object ThermostatApp extends App {
  import ThermostatSupervisor.{ StartSendingMessages, StopSendingMessages, SystemMessage }
  val actorSystem: ActorSystem[SystemMessage] = ActorSystem(
    ThermostatSupervisor(),
    "ThermostatSupervisor"
  )
  actorSystem ! StartSendingMessages
  Thread.sleep(1000)
  actorSystem ! StopSendingMessages

  Thread.sleep(500)
  actorSystem.terminate()
}
