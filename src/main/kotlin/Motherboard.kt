class Motherboard(
    override val inventoryNumber: String,
    override val name: String,
    override val price: Double,
    val socketType: String,
    val processorCount: Int,
    val memoryType: String
) : IComputerComponent
