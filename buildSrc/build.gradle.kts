import org.gradle.internal.component.external.model.JavaEcosystemVariantDerivationStrategy

plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

sourceSets {
    create("javaInternal") {
        java.srcDir("src/main/java-internal")
    }
}

dependencies {
    "javaInternalCompileOnly"(files(File(JavaEcosystemVariantDerivationStrategy::class.java.protectionDomain.codeSource.location.toURI())))
    "javaInternalCompileOnly"("com.google.guava:guava:26.0-android")
    compile(sourceSets.getByName("javaInternal").output)
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

plugins.withType<KotlinDslPlugin> {
    kotlinDslPluginOptions {
        experimentalWarning.set(false)
    }
}
