package minesweeper

import java.awt.Color as JColor
import introprog.PixelWindow
import introprog.PixelWindow.Event

class visualBoard(rows: Int, cols: Int) {
    import visualBoard.*

    var hasHitBomb: Boolean = false
    val window: PixelWindow = new PixelWindow(rows * blockSize, cols*blockSize, "Minesweeper")

    def drawGrid(): Unit = {
        for(x <- 0 to cols) {
            window.line(0, x*blockSize, rows*blockSize, x*blockSize, gridColor)
        }
        for(y <- 0 to rows) {
            window.line(y*blockSize, 0, y*blockSize, cols*blockSize, gridColor)
        } 
    }

    def drawBlock(row: Int, col: Int, color: JColor = hasGuessed): Unit = {
        window.fill(row + 1, col + 1, blockSize - 1, blockSize - 1, color)
    }

    def writeNumber(row: Int, col: Int, number: Int): Unit = {
        if(number != 0) {
            window.drawText(number.toString, col + 7, row + 3, JColor.red, 13)
        }
    }

    def handleKey(key: String) = {
        key match {
            case " " => //Draw bomb, change value in matrix
            case _ => {}
        }
    }

    def handleClick(pos: (Int, Int)): Unit = {
        val xCoord = ((pos._1) - (pos._1 % blockSize)) / blockSize
        val yCoord = ((pos._2) - (pos._2 % blockSize)) / blockSize
        drawBlock(yCoord, xCoord)
    }

    def continuePlay(): Unit = {
        println("A")
        while(!hasHitBomb) {
            window.awaitEvent(maxWait)
            while (window.lastEventType != Event.Undefined) {
                window.lastEventType match {
                    case Event.KeyPressed  =>  handleKey(window.lastKey)
                    case Event.MousePressed => handleClick(window.lastMousePos)
                    case Event.WindowClosed => hasHitBomb = true
                    case _ =>
                }
            }
        }
        println("B")
    }
}

object visualBoard {
    val blockSize: Int = 20
    val gridColor = JColor.white
    val hiddenColor = JColor.darkGray
    val hasGuessed = JColor.lightGray
    val maxWait = 200
}