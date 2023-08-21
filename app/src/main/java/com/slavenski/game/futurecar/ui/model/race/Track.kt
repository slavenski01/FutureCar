package com.slavenski.game.futurecar.ui.model.race

import com.slavenski.game.futurecar.ui.model.block.Block

abstract class Track {
    abstract var startPolygon: Polygon
    abstract var gamePolygon: GamePolygon
}

abstract class GamePolygon {
    abstract var border: Polygon

    private var blocks: List<Block>? = null

    open fun setBlocks(newBlocks: List<Block>) {
        blocks = newBlocks
    }
}