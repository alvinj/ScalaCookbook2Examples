package r03_rename_on_import

import java.util.{Date as JDate, HashMap as JHashMap, *}

@main def renameOnImport =
    // val map = HashMap[String, String]()   // this won’t compile (as desired)
    val map = JHashMap[String, String]()
    val xs = ArrayList[String]()
    