class MotherboardFactory (val inventoryNumber: String,
                          val name: String,
                          val price: Double,
                          val socketType: String,
                          val coreCount: Int,
                          val clockSpeed: String): ComputerComponentFactory() {
    override fun GetComputerComponent(): IComputerComponent = Motherboard(inventoryNumber, name, price, socketType, coreCount, clockSpeed)
}