package com.example.diagonalprogram.common.extension

infix fun Int.cDiv(other: Int) = this.div(other).plus(if (this.rem(other) > 0) 1 else 0)