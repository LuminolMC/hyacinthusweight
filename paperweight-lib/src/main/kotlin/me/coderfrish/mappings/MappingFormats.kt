package me.coderfrish.mappings

import org.cadixdev.lorenz.io.MappingFormat
import org.cadixdev.lorenz.io.proguard.ProGuardFormat
import org.cadixdev.lorenz.io.srg.csrg.CSrgMappingFormat
import org.cadixdev.lorenz.util.Registry

class MappingFormats {
    companion object {
        @JvmStatic
        val mappingFormats: MappingFormats = MappingFormats()
    }

    val registry: Registry<MappingFormat> = Registry()

    init {
        registry.register("csrg", CSrgMappingFormat())
        registry.register("proguard", ProGuardFormat())
    }

    private fun byId(id: String): MappingFormat = registry.byId(id)

    fun CSRG(): MappingFormat = byId("csrg")

    fun PROGUARD(): MappingFormat = byId("proguard")
}
