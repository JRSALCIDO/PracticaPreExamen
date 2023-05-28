package com.example.practicapreexamen

class ReciboNomina(
    val horasTrabajadasNormales: Double,
    val horasTrabajadasExtra: Double,
    var puesto: Int,
    var porcentajeImpuesto: Double = 0.16,
    var subtotal: Double = 0.0,
    var impuesto: Double = 0.0,
    var total: Double = 0.0
) {
    val pagobase = 200.0

    fun calcularPagoPorPuesto(): Double = when (puesto) {
        1 -> pagobase * 1.20
        2 -> pagobase * 1.50
        3 -> pagobase * 2.00
        else -> 0.0
    }

    fun calcularSubtotal() {
        val pagoPorHora = calcularPagoPorPuesto()
        subtotal = horasTrabajadasNormales * pagoPorHora + horasTrabajadasExtra * pagoPorHora * 2
    }

    fun calcularImpuesto() {
        impuesto = porcentajeImpuesto * subtotal
    }

    fun calcularTotal() {
        total = subtotal - impuesto
    }
}
