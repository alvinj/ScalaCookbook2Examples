# Recipe 24.3, Writing Expressions (Instead of Statements)


```scala
// an intentionally poor design
class Stock(
    var symbol: String,
    var company: String,
    var price: String,
    var volume: String,
    var high: String,
    var low: String
):
    var html: String = _
    def buildUrl(stockSymbol: String): String = ???
    def getUrlContent(url: String): String = ???
    def setPriceUsingHtml(): Unit = this.price = ???
    def setVolumeUsingHtml(): Unit = this.volume = ???
    def setHighUsingHtml(): Unit = this.high = ???
    def setLowUsingHtml(): Unit = this.low = ???
```

Using this class results in code like this:

```scala
val stock = Stock("GOOG", "Google", "", "", "", "")
val url = stock.buildUrl(stock.symbol)
stock.html = stock.getUrlContent(url)

// a series of calls on an object (i.e, “statements”)
stock.setPriceUsingHtml()
stock.setVolumeUsingHtml()
stock.setHighUsingHtml()
stock.setLowUsingHtml()
```




## Discussion

Expressions:

```scala
val x = 2 + 2                            // 4
val xs = List(1,2,3,4,5).filter(_ > 2)   // List(3, 4, 5)
```

These are also expressions:

```scala
val max = if a > b then a else b

val evenOrOdd = i match
    case 1 | 3 | 5 | 7 | 9 => "odd"
    case 2 | 4 | 6 | 8 | 10 => "even"

val result = try
    "1".toInt
catch
    case _ => 0
```





