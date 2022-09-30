package r04_auxiliary_constructors

import com.alvinalexander.simpletest.SimpleTest.*


// pp. 144-145
package t1 {

    enum CrustSize:
        case Small, Medium, Large

    enum CrustType:
        case Thin, Regular, Thick

    import CrustSize.*, CrustType.*

    // primary constructor
    class Pizza (var crustSize: CrustSize, var crustType: CrustType):

        // one-arg auxiliary constructor
        def this(crustSize: CrustSize) = this(crustSize, Pizza.DefaultCrustType)

        // one-arg auxiliary constructor
        def this(crustType: CrustType) = this(Pizza.DefaultCrustSize, crustType)

        // zero-arg auxiliary constructor
        def this() = this(Pizza.DefaultCrustSize, Pizza.DefaultCrustType)

        override def toString = s"A $crustSize pizza with a $crustType crust"
    end Pizza

    object Pizza:
        val DefaultCrustSize = Medium
        val DefaultCrustType = Regular
    end Pizza

    @main def testAuxiliaryConstructors =

        // import these defaults from the `object`
        import Pizza.{DefaultCrustSize, DefaultCrustType}

        // use the different constructors
        val p1 = Pizza(DefaultCrustSize, DefaultCrustType)
        val p2 = Pizza(DefaultCrustSize)
        val p3 = Pizza(DefaultCrustType)
        val p4 = Pizza()
    
        // the toString value of all four instances is the same
        True(
            p1.toString == p2.toString &&
            p2.toString == p3.toString &&
            p3.toString == p4.toString
        )
}


// p. 146 (“Don’t Forget About Default Parameter Values”)
package t2 {
    
    enum CrustSize:
        case Small, Medium, Large

    enum CrustType:
        case Thin, Regular, Thick

    import CrustSize.*, CrustType.*

    class Pizza(
        var crustSize: CrustSize = DefaultCrustSize, 
        var crustType: CrustType = DefaultCrustType
    ):
        override def toString =
            s"A $crustSize pizza with a $crustType crust"

    object Pizza:
        val DefaultCrustSize = Medium
        val DefaultCrustType = Regular

    @main def defaultParameterValues =
        // import these defaults from the `object`
        import Pizza.{DefaultCrustSize, DefaultCrustType}

        // use the different constructors
        val p1 = Pizza(DefaultCrustSize, DefaultCrustType)
        val p2 = Pizza(DefaultCrustSize)
        // 'p3' will not work because of the way default parameters work
        // val p3 = Pizza(DefaultCrustType)
        val p4 = Pizza()

        // the toString value of all four instances is the same
        True(
            p1.toString == p2.toString &&
            p2.toString == p4.toString
        )
}







