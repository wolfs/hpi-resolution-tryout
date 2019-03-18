import org.gradle.internal.component.external.model.JavaEcosystemVariantDerivationStrategy;
import org.gradle.internal.component.external.model.ModuleComponentResolveMetadata;
import org.gradle.internal.component.model.ConfigurationMetadata;
import org.gradle.internal.impldep.com.google.common.collect.ImmutableList;

public class JenkinsEcosystemVariantDerivationStrategy extends JavaEcosystemVariantDerivationStrategy {
    @Override
    public ImmutableList<? extends ConfigurationMetadata> derive(ModuleComponentResolveMetadata metadata) {
        System.out.println("Resolving Jenkins variants");
        ImmutableList<? extends ConfigurationMetadata> javaVariants = super.derive(metadata);
        if (javaVariants == null) {
            return null;
        }
        return javaVariants;
    }
}
