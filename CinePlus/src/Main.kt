// se deben de iportar. usualmente por primera vez se necesita "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3" en
// una libreria. Debe ser de la version correcta para que funcione bien
import kotlinx.coroutines.*
import java.lang.IllegalArgumentException

// Seleaed para proceso de la compra, no es necesario usar when ni else
sealed class EstadoCompra {
    object Procesando : EstadoCompra()
    data class Exito(val mensaje: String) : EstadoCompra()
    data class Error(val detalle: String) : EstadoCompra()
}

//es una FUNCIÓN ASÍNCRONA que es para procesar el estado de compra
suspend fun procesarCompra(entrada: Entrada): EstadoCompra {
    println("Procesando compra de entrada ${entrada.codigo}...")
    delay(5000) // Simulación del proceso, para que demore un poco
    return EstadoCompra.Exito("La entrada ${entrada.codigo} fue comprada con exito :)")
}


// Sirve para crear una lista de entradas de pruebas. usando "MutableList<>"
fun crearEntradasDePrueba(): MutableList<Entrada> {
    val listaEntradas = mutableListOf<Entrada>()
    try {
        listaEntradas.addAll(listOf(
            EntradaVip("CINE-001", 5000.0, "Sala 1", "Matrix", incluyeSnack = false),
            Entrada("CINE-000", 10000.0, "Sala 0", "Mi pobre angelito"),
            EntradaNormal("CINE-002", 4000.0, "Sala 2", "Avengers"),
            EntradaVip("CINE-003", 5500.0, "Sala 1", "Minion3", incluyeSnack = false),
            EntradaNormal("CINE-004", 4000.0, "Sala 3", "Star Wars"),
            EntradaVip("CINE-005", 6000.0, "Sala 2", "Matrix", incluyeSnack = true),
            EntradaNormal("CINE-006", 3000.0, "Sala 4", "Matrix")
        ))
    } catch (e: IllegalArgumentException) {
        println(" Error al crear entrada: ${e.message}")
    }// solo un mensaje de error para poder verificar si algo sale mal (opcional)
    return listaEntradas
}

// aqui mostrara los resultados finales
fun mostrarResultados(listaEntradas: List<Entrada>) {
    println("Lista completa de entradas creada (${listaEntradas.size} entradas)\n")

    // filtro para pelicula matrix unicamente. "FILTER"
    val entradasMatrix = listaEntradas.filter { it.pelicula == "Matrix" }
    println("Entradas para Matrix:")
    if (entradasMatrix.isNotEmpty()) {
        entradasMatrix.forEach { entrada ->
            val tipo = if (entrada is EntradaVip) "VIP" else "Normal"
            val snackInfo = if (entrada is EntradaVip) {
                if (entrada.incluyeSnack) " (con snack)" else " (sin snack)"
            } else ""
            println("• ${entrada.codigo} - $tipo$snackInfo")
            println("  Sala: ${entrada.sala}, Precio: $${entrada.calcularPrecio()}")
        }
    } else {
        println("No hay entradas para la pelicula 'Matrix'")
    }

    // "MAP"
// codigo de todas las entradas usando el "codigosEntradas"
    println("\nCodigos de todas las entradas: ")
    val codigosEntradas = listaEntradas.map { it.codigo }
    println(codigosEntradas)

    val precioTotal = listaEntradas.sumOf { it.calcularPrecio() }
    println("\n=== PRECIO TOTAL DE TODAS LAS ENTRADAS (SUMOF) ===")
    println("Precio total: $${"%.2f".format(precioTotal)}")
    println("Numero de entradas: ${listaEntradas.size}")
}

//  CORRUTINAS
// funciona para hacer prueba con corrutinas? usando el runBlocking. se necesita la dependencia en la libreria
    fun simularCompra(listaEntradas: List<Entrada>) = runBlocking {
    println("\n SIMULACION DE COMPRA CON CORRUTINAS ")
    val resultado = try {
        procesarCompra(entrada = listaEntradas.first())
    } catch (e: Exception) {
        EstadoCompra.Error(detalle = "Error durante la compra: ${e.message}") //opcional
    }

    when (resultado) {
        is EstadoCompra.Procesando -> println("Compra en proceso, espere...")
        is EstadoCompra.Exito -> println(" ${resultado.mensaje}")
        is EstadoCompra.Error -> println(" ${resultado.detalle}")
    }
}

fun main() {
    println(" Cine de Guti ")
    val listaEntradas = crearEntradasDePrueba()
    mostrarResultados(listaEntradas)
    simularCompra(listaEntradas)
    println("\n PROCESO COMPLETADO ")
}
