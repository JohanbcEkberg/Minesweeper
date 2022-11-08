package minesweeper

import introprog.PixelWindow
import introprog.PixelWindow.Event
import scala.collection.mutable.ArrayBuffer

case class Matrix[T](cells: ArrayBuffer[ArrayBuffer[T]]) {
    require(cells.forall(row => row.isInstanceOf[Vector[Int]]))

    def apply(row: Int, col: Int) = {
        cells(row)(col)
    }

    def xlength: Int = {
        cells(0).length
    }

    def ylength: Int = {
        cells.length
    }

    def indices: Range = {
        cells.indices
    }
}