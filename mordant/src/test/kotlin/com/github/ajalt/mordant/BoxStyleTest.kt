package com.github.ajalt.mordant

import com.github.ajalt.mordant.BoxStyle.Companion.ASCII
import com.github.ajalt.mordant.BoxStyle.Companion.SQUARE
import io.kotlintest.data.forall
import io.kotlintest.shouldBe
import io.kotlintest.tables.row
import org.junit.Test

class BoxStyleTest {

    @Test
    fun `horizontal divider styles`() = forall(
            row("++", listOf(), ASCII.top),
            row("+-----+", listOf(2, 1, 0), ASCII.top),
            row("|--+-+|", listOf(2, 1, 0), ASCII.headBottom),
            row("|--+-+|", listOf(2, 1, 0), ASCII.bodyMid),
            row("|--+-+|", listOf(2, 1, 0), ASCII.footerTop),
            row("+-----+", listOf(2, 1, 0), ASCII.bottom),
            row("┌┐", listOf(), SQUARE.top),
            row("┌──┬─┬┐", listOf(2, 1, 0), SQUARE.top),
            row("├──┼─┼┤", listOf(2, 1, 0), SQUARE.headBottom),
            row("├──┼─┼┤", listOf(2, 1, 0), SQUARE.bodyMid),
            row("├──┼─┼┤", listOf(2, 1, 0), SQUARE.footerTop),
            row("└──┴─┴┘", listOf(2, 1, 0), SQUARE.bottom)
    ) { expected, widths, div ->
        div.getRow(widths, edge = true) shouldBe expected
        div.getRow(widths, edge = false) shouldBe expected.drop(1).dropLast(1)
    }
}
