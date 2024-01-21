class HardDriveFactory (val inventoryNumber: String,
                        val name: String,
                        val price: Double,
                        val capacity: Int,
                        val rotationSpeed: Int) : ComputerComponentFactory() {
    override fun GetComputerComponent(): IComputerComponent = HardDrive(inventoryNumber, name, price, capacity, rotationSpeed)
}