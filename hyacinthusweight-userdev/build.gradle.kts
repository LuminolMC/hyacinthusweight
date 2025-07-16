plugins {
    `config-kotlin`
    `config-publish`
}

dependencies {
    shade(projects.hyacinthusweightLib)
    implementation(libs.bundles.kotson)
    implementation(variantOf(libs.diffpatch) { classifier("all") }) {
        isTransitive = false
    }
    implementation(libs.coroutines)
    implementation(libs.bundles.asm)
}

gradlePlugin {
    setupPlugin("userdev") {
        description = "Gradle plugin for developing Paper plugins using server internals"
        implementationClass = "moe.luminolmc.hyacinthusweight.userdev.PaperweightUser"
    }
}
