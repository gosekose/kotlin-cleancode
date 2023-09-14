package clazz

interface StockExchange {
    fun currentPrice(symbol: String): Money
}

class TokyoStockExchange(
    private val tokyoStockPort: TokyoStockPort,
) : StockExchange {
    override fun currentPrice(symbol: String): Money {
        return tokyoStockPort.getCurrentPrice(symbol)
    }

}

interface TokyoStockPort {
    fun getCurrentPrice(symbol: String): Money
}


class Portfolio(
    private val stockExchange: StockExchange,
) {
    fun currentPrice(symbol: String): Money {
        return stockExchange.currentPrice(symbol)
    }
}

class Money