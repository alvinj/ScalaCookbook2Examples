import scala.annotation.switch

// Version 2 - leads to a compiler warning
class SwitchDemo:
    val i = 1
    val one = 1               // added
    val x = (i: @switch) match
        case one  => "One"    // replaced the '1'
        case 2    => "Two"
        case 3    => "Three"
        case _    => "Other"

