class EntradaVip(
    codigo: String,
    precioBase: Double,
    sala: String,
    pelicula: String,
    val incluyeSnack: Boolean //false o true
) : Entrada(codigo, precioBase, sala, pelicula) {

    override fun calcularPrecio(): Double { //funcion para calcular el precio
        return if (incluyeSnack) {
            precioBase * 1.20 //20+
        } else {
            precioBase
        }
    }
}
