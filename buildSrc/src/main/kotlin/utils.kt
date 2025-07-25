import org.gradle.api.Action
import org.gradle.api.artifacts.Configuration
import org.gradle.api.attributes.java.TargetJvmVersion
import org.gradle.api.attributes.plugin.GradlePluginApiVersion
import org.gradle.api.model.ObjectFactory
import org.gradle.kotlin.dsl.*
import org.gradle.plugin.devel.GradlePluginDevelopmentExtension
import org.gradle.plugin.devel.PluginDeclaration

fun Configuration.compatibilityAttributes(objects: ObjectFactory) {
    attributes {
        attribute(TargetJvmVersion.TARGET_JVM_VERSION_ATTRIBUTE, 17)
        attribute(GradlePluginApiVersion.GRADLE_PLUGIN_API_VERSION_ATTRIBUTE, objects.named("8.14"))
    }
}

fun GradlePluginDevelopmentExtension.setupPlugin(prefix: String, op: Action<PluginDeclaration>) {
    plugins.register("hyacinthusweight-$prefix") {
        id = "moe.luminolmc.hyacinthusweight.$prefix"
        displayName = "hyacinthusweight $prefix"
        tags.set(listOf("paper", "minecraft", "hyacinthus"))
        op.execute(this)
    }
}
