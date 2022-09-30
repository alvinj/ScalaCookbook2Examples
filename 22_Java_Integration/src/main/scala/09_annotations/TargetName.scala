package r09_annotations

package t4_targetName {
    // define a '++' method with the target name
    // (for use in Java code) of 'plus1'.
    object TargetNameDemo:
        import scala.annotation.targetName
        @targetName("plus1")
        def ++(i: Int): Int = i + 1

    // use '++' in scala code
    @main def usePlusPlus =
        import TargetNameDemo.++
        println(++(1))        
}


