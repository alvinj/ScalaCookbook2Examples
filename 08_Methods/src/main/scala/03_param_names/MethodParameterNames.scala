package r03_param_names_methods

// p. 243
enum CrustSize:
    case Small, Medium, Large

enum CrustType:
    case Regular, Thin, Thick

import CrustSize.*, CrustType.*

class Pizza:
    // default values for an OOP style, using 'var' fields
    var crustSize = Medium
    var crustType = Regular
    def update(crustSize: CrustSize, crustType: CrustType) =
        this.crustSize = crustSize
        this.crustType = crustType
    override def toString = s"A $crustSize inch, $crustType crust pizza."

@main def paramNamesWithMethod =
    val p = Pizza()
    p.update(crustSize = Large, crustType = Thick)
    p.update(crustType = Thick, crustSize = Large)
    println(p)


