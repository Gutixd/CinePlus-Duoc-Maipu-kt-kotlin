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
