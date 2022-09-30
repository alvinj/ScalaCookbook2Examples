package r04_hide_on_import

package t1 {
    import java.util.{Random => _, *}
    
    // this fails to compile, as desired:
    // val r = Random()
}


package t2 {
    import java.util.{List => _, Map => _, Set => _, *}

    // these all work, as desired
    val x = ArrayList[String]()
    val a = List(1, 2, 3)
    val b = Set(1, 2, 3)
    val c = Map(1 -> 1, 2 -> 2)
}
