import scala.annotation.switch

class SwitchDemo:
    val i = 1
    val x = (i: @switch) match
        case 1 => "One"
        case 2 => "Two"
        case 3 => "Three"
        case _ => "Other"


