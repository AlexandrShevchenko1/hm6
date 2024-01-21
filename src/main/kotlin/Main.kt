val factories: List<ComputerComponentFactory> = listOf(
    MotherboardFactory("MB001", "ASUS Prime X570", 150.0, "AM4", 1, "DDR4"),
    MotherboardFactory("MB002", "Gigabyte B450M", 100.0, "AM4", 1, "DDR4"),
    MotherboardFactory("MB003", "MSI B360", 120.0, "LGA1151", 1, "DDR4"),
    ProcessorFactory("CPU001", "Intel Core i7-9700K", 300.0, "LGA1151", 8, 3.6),
    HardDriveFactory("HDD001", "Seagate Barracuda", 80.0, 2000, 7200)
)

fun main() {
    // Вывод информации о комплектующих
    for (factory in factories) {
        printInfo(factory)
    }
    print("\n\nEnter inventory number: ")
    printInfo(findFactoryByInventoryNumber(readln()))
}



fun findFactoryByInventoryNumber(inventoryNumber: String): ComputerComponentFactory? {
    for (factory in factories) {
        when (factory) {
            is MotherboardFactory -> {
                if (inventoryNumber.equals(factory.inventoryNumber)) {
                    return factory
                }
            }
            is ProcessorFactory -> {
                if (inventoryNumber.equals(factory.inventoryNumber)) {
                    return factory
                }
            }
            is HardDriveFactory -> {
                if (inventoryNumber.equals(factory.inventoryNumber)) {
                    return factory
                }
            }
        }
    }
    return null
}

fun printInfo(factory : ComputerComponentFactory?) {
    val component = factory?.GetComputerComponent() ?: return
    println("Номенклатурный номер: ${component.inventoryNumber}")
    println("Название: ${component.name}")
    println("Стоимость: ${component.price}")
    when (component) {
        is Motherboard -> {
            println("Тип сокета: ${component.socketType}")
            println("Количество процессоров: ${component.processorCount}")
            println("Тип оперативной памяти: ${component.memoryType}")
        }
        is Processor -> {
            println("Тип сокета: ${component.socketType}")
            println("Количество ядер: ${component.coreCount}")
            println("Тактовая частота: ${component.clockSpeed} GHz")
        }
        is HardDrive -> {
            println("Объем: ${component.capacity} GB")
            println("Скорость вращения: ${component.rotationSpeed} RPM")
        }
    }
    println("--------------")
}