package com.github.ajalt.mordant

data class BoxStyle(
        val top: HorizontalDivider,
        val head: VerticalDivider,
        val headBottom: HorizontalDivider,
        val body: VerticalDivider,
        val bodyMid: HorizontalDivider,
        val footerTop: HorizontalDivider,
        val footer: VerticalDivider,
        val bottom: HorizontalDivider
) {
    data class VerticalDivider(val left: Char, val mid: Char, val right: Char)
    data class HorizontalDivider(val left: Char, val mid: Char, val column: Char, val right: Char) {
        /**
         * Render this divider for a table with columns of the given [widths].
         *
         * @param edge If true, render with the [left] and [right] edge characters
         */
        fun getRow(widths: Iterable<Int>, edge: Boolean = true): String = buildString {
            if (edge) append(left)
            widths.withIndex().forEach { (i, w) ->
                if (i > 0) append(column)
                repeat(w) { append(mid) }
            }
            if (edge) append(right)
        }
    }

    companion object {
        fun fromString(string: String): BoxStyle {
            val lines = string.trimIndent().lines()
            require(lines.size == 8)
            require(lines.all { it.length == 4 })
            fun h(i: Int) = HorizontalDivider(lines[i][0], lines[i][1], lines[i][2], lines[i][3])
            fun v(i: Int) = VerticalDivider(lines[i][0], lines[i][2], lines[i][3])
            return BoxStyle(
                    top = h(0),
                    head = v(1),
                    headBottom = h(2),
                    body = v(3),
                    bodyMid = h(4),
                    footerTop = h(5),
                    footer = v(6),
                    bottom = h(7)
            )
        }

        // TODO: add more styles
        val ASCII: BoxStyle = fromString("""
            +--+
            | ||
            |-+|
            | ||
            |-+|
            |-+|
            | ||
            +--+
            """)

        val SQUARE: BoxStyle = fromString("""
            ┌─┬┐
            │ ││
            ├─┼┤
            │ ││
            ├─┼┤
            ├─┼┤
            │ ││
            └─┴┘
            """)
    }
}
