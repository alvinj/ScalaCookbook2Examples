package r07_structural_types


// p. 196
package t1 {

    trait WarpCore:
        this: { def ejectWarpCore(password: String): Boolean } =>
        // more trait code here ...

    class Starship

    class Enterprise extends Starship with WarpCore:
        def ejectWarpCore(password: String): Boolean =
            if password == "password" then
                println("ejecting core!")
                true
            else
                false
            end if
    end Enterprise
}


// p. 197
package t2 {
    trait WarpCore:
        this: {
            // an implementing class must have methods with
            // these names and input parameters
            def ejectWarpCore(password: String): Boolean
            def startWarpCore: Unit
        } =>
        // more trait code here ...
    
    class Starship
    
    class Enterprise extends Starship, WarpCore:
        def ejectWarpCore(password: String): Boolean =
            if password == "password" then
                println("core ejected")
                true
            else
                false
            end if
        end ejectWarpCore
        def startWarpCore = println("core started")
    end Enterprise
}




