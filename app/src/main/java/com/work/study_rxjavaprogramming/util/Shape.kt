package com.work.study_rxjavaprogramming.util

object Shape {
    const val HEXAGON = "HEXAGON"
    const val OCTAGON = "OCTAGON"
    const val RECTANGLE = "RECTANGLE"
    const val TRIANGLE = "TRIANGLE"
    const val DIAMOND = "DIAMOND"
    const val PENTAGON = "PENTAGON"
    const val BALL = "BALL"
    const val STAR = "STAR"
    const val NO_SHAPE = "NO_SHAPE"
    const val FLIPPED = "(flipped)"

    //Colors for shape
    const val RED = "1"
    const val YELLOW = "2"
    const val GREEN = "3"
    const val SKY = "4"
    const val BLUE = "5"
    const val PUPPLE = "6"
    const val ORANGE = "7"
    fun getColor(shape: String): String {
        if (shape.endsWith("<>")) //diamond
            return shape.replace("<>", "").trim { it <= ' ' }
        val hyphen = shape.indexOf("-")
        return if (hyphen > 0) {
            shape.substring(0, hyphen)
        } else shape
        //for ball
    }

    fun getSuffix(shape: String): String {
        if (HEXAGON == shape) return "-H"
        if (OCTAGON == shape) return "-O"
        if (RECTANGLE == shape) return "-R"
        if (TRIANGLE == shape) return "-T"
        if (DIAMOND == shape) return "<>"
        if (PENTAGON == shape) return "-P"
        return if (STAR == shape) "-S" else ""
        //for BALL
    }

    fun getShape(obj: String?): String {
        if (obj == null || obj == "") return NO_SHAPE
        if (obj.endsWith("-H")) return HEXAGON
        if (obj.endsWith("-O")) return OCTAGON
        if (obj.endsWith("-R")) return RECTANGLE
        if (obj.endsWith("-T")) return TRIANGLE
        if (obj.endsWith("<>")) return DIAMOND
        if (obj.endsWith("-P")) return PENTAGON
        return if (obj.endsWith("-S")) STAR else "BALL"
    }

    fun getString(color: String, shape: String): String {
        return color + getSuffix(shape)
    }

    fun triangle(color: String): String {
        return "$color-T"
    }

    fun rectangle(color: String): String {
        return "$color-R"
    }

    fun star(color: String): String {
        return "$color-S"
    }

    fun pentagon(color: String): String {
        return "$color-P"
    }
}