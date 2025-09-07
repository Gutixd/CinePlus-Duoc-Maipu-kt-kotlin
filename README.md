📋 Descripción
Sistema de consola en Kotlin para la gestión de entradas de cine, desarrollado para la empresa CinePlus. Permite registrar diferentes tipos de entradas, calcular precios, filtrar información y simular procesos de compra.

🚀 Características
🏗️ Programación Orientada a Objetos
Clase Base Entrada: Propiedades básicas y validación de precios

EntradaVip: Hereda de Entrada con snack opcional (+20% de precio)

EntradaNormal: Implementación básica sin modificaciones de precio

📊 Funciones de Orden Superior
filter: Filtra entradas por película específica

map: Genera lista de códigos de entradas

sumOf: Calcula precio total de todas las entradas

⚡ Corrutinas y Manejo de Estados
sealed class EstadoCompra: Manejo de estados de compra

Procesamiento asíncrono con delay() para simular compras

Manejo de errores con excepciones personalizadas

🛡️ Manejo de Errores
Validación de precios mayores a 0

Try-catch para capturar excepciones de entrada inválida

🎯 Funcionalidades
Creación de entradas con validación de precios

Cálculo automático de precios (VIP con snack +20%)

Filtrado de entradas por película

Listado de códigos de entradas

Cálculo de totales de ventas

Simulación de compras con corrutinas

Manejo de estados de compra (Procesando, Éxito, Error)

🏗️ Estructura del Proyecto
text
src/
├── Main.kt           # Función principal y lógica de negocio
├── Entrada.kt        # Clase base Entrada
├── EntradaVip.kt     # Clase EntradaVIP con snack
└── EntradaNormal.kt  # Clase EntradaNormal
🛠️ Tecnologías Utilizadas
Kotlin 1.9.0+

Kotlin Coroutines para operaciones asíncronas

Programación funcional con filter, map, sumOf

Manejo de excepciones con try-catch

Sealed classes para manejo de estados

📦 Dependencias
kotlin
dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}
🚀 Cómo Ejecutar
Clona el repositorio

Abre en IntelliJ IDEA

Asegúrate de tener las corrutinas configuradas

Ejecuta Main.kt

bash
./gradlew run
📝 Ejemplo de Uso
kotlin
// Crear entradas
val entradaVip = EntradaVip("CINE-001", 5000.0, "Sala 1", "Matrix", true)
val entradaNormal = EntradaNormal("CINE-002", 4000.0, "Sala 2", "Avengers")

// Calcular precios
val precioVip = entradaVip.calcularPrecio() // 6000.0 (20% extra)
val precioNormal = entradaNormal.calcularPrecio() // 4000.0
🎮 Ejemplo de Salida
text
 Cine de Guti 
Lista completa de entradas creada (7 entradas)

Entradas para Matrix:
• CINE-001 - VIP (sin snack)
  Sala: Sala 1, Precio: $5000.0
• CINE-005 - VIP (con snack)
  Sala: Sala 2, Precio: $7200.0
• CINE-006 - Normal
  Sala: Sala 4, Precio: $3000.0

Codigos de todas las entradas: 
[CINE-001, CINE-000, CINE-002, CINE-003, CINE-004, CINE-005, CINE-006]

=== PRECIO TOTAL DE TODAS LAS ENTRADAS (SUMOF) ===
Precio total: $38700.00
Numero de entradas: 7

 SIMULACION DE COMPRA CON CORRUTINAS 
Procesando compra de entrada CINE-001...
 La entrada CINE-001 fue comprada con exito :)

 PROCESO COMPLETADO 
👨‍💻 Autor
Cine de Guti - Sistema desarrollado para fines educativos y de evaluación

📄 Licencia
Este proyecto es de uso educativo como parte de una evaluación de programación en Kotlin.

