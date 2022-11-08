package minesweeper

@main def run = {
    val a = new visualBoard(50, 35)
    a.drawGrid()
    a.continuePlay()
}