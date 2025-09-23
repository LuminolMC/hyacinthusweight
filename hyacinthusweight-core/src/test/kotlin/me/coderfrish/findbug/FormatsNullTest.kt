package me.coderfrish.findbug

import org.cadixdev.lorenz.io.MappingFormats as Formats
import kotlin.test.Test

class FormatsNullTest {
    @Test
    fun test() {
        println(Formats.byId("proguard"))
    }
}
