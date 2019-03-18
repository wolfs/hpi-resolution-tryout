
import org.gradle.api.internal.artifacts.dsl.ComponentMetadataHandlerInternal

val metadataHandler = project.dependencies.components as ComponentMetadataHandlerInternal

println("Setting strategy")
metadataHandler.setVariantDerivationStrategy(JenkinsEcosystemVariantDerivationStrategy())

//open class JenkinsEcosystemVariantDerivationStrategy : VariantDerivationStrategy {
//    override fun derivesVariants(): Boolean {
//        return true
//    }
//
//    override fun derive(metadata: ModuleComponentResolveMetadata?): ImmutableList<out ConfigurationMetadata> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun derive(metadata: ModuleComponentResolveMetadata?): ImmutableList<out ConfigurationMetadata>? {
//        println("Determining metadata for module ${metadata.toString()}")
//        return ImmutableList.of()
//        val javaVariants: ImmutableList<out ConfigurationMetadata>? = super.derive(metadata)
//        return javaVariants?.let { variants ->
//            val mavenMetadata: DefaultMavenModuleResolveMetadata = metadata as DefaultMavenModuleResolveMetadata
//            println("Determining metadata")
//            if (listOf("hpi", "jpi").contains(mavenMetadata.packaging)) {
//                ImmutableList.copyOf(variants.map { configMetadata ->
//                    val conf = configMetadata as DefaultConfigurationMetadata
//                    object : ConfigurationMetadata by configMetadata {
//                        override fun getArtifacts(): List<out ComponentArtifactMetadata> {
//                            return configMetadata.artifacts.flatMap { listOf(it, configMetadata.artifact(DefaultIvyArtifactName(it.name.name, "jar", "jar"))) }
//                        }
//                    }
//                })
//            } else {
//                variants
//            }
//        }
//    }
//}