class ProcessorFactory (val inventoryNumber: String,
                        val name: String,
                        val price: Double,
                        val socketType: String,
                        val coreCount: Int,
                        val clockSpeed: Double) : ComputerComponentFactory() {
    override fun GetComputerComponent(): IComputerComponent = Processor(inventoryNumber, name, price, socketType, coreCount, clockSpeed)
}