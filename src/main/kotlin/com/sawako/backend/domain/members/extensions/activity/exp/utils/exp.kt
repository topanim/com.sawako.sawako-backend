package com.sawako.backend.domain.members.extensions.activity.exp.utils

import kotlin.math.pow

fun calculateUpExp(lvl: Int): Int {
    return (10 * lvl.toDouble().pow(10)).toInt()
}

//fun calculateLvl(exp: Int): NewActivity {
//    var lvl = 1
//    while (true) {
//        val upExp = calculateUpExp(lvl)
//        if (upExp > exp) {
//            return NewActivity(lvl - 1, upExp)
//        }
//        lvl++
//    }
//}