class Processor(
    override val inventoryNumber: String,
    override val name: String,
    override val price: Double,
    val socketType: String,
    val coreCount: Int,
    val clockSpeed: Double
) : IComputerComponent
