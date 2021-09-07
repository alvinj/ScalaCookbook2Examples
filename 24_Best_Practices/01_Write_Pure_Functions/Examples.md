# Recipe 24.1, Writing Pure Functions


The “fixed” code:

```scala
case class Stock(symbol: String, company: String)

case class StockInstance(
    symbol: String,
    datetime: String,
    price: BigDecimal,
    volume: Long
)

object NetworkUtils:
    def getUrlContent(url: String): String = ???

object StockUtils:
    def buildUrl(stockSymbol: String): String = ???
    def getPrice(symbol: String, html: String): String = ???
    def getVolume(symbol: String, html: String): String = ???
    def getHigh(symbol: String, html: String): String = ???
    def getLow(symbol: String, html: String): String = ???

object DateUtils:
    def currentDate: String = ???
    def currentTime: String = ???
```

Now use that code:

```scala
val stock = Stock("AAPL", "Apple")
val url = StockUtils.buildUrl(stock.symbol)

val html = NetworkUtils.getUrlContent(url)
val stockInstance = StockInstance(
    symbol,
    DateUtils.currentDate,
    StockUtils.getPrice(html),
    StockUtils.getVolume(html),
    StockUtils.getHigh(html),
    StockUtils.getLow(html)
)
```





