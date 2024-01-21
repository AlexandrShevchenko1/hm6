class HardDrive(
    override val inventoryNumber: String,
    override val name: String,
    override val price: Double,
    val capacity: Int,
    val rotationSpeed: Int
) : IComputerComponent
