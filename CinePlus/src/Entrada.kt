open class Entrada(
    val codigo: String,
    val precioBase: Double,
    val sala: String,
    val pelicula: String
) {
    init {
        if (precioBase <= 0) {
            throw IllegalArgumentException("El precio debe ser mayor que 0")
        }
    }

    open fun calcularPrecio(): Double { //tiene override
        return precioBase
    }
}
