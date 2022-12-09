package ru.spbstu.utils

fun String.isInt(): Boolean =
    try {
        this.toInt()
        true
    }catch (e: Exception){
        false
    }

fun String.isDouble(): Boolean =
    try {
        this.toDouble()
        true
    }catch (e: Exception){
        false
    }
