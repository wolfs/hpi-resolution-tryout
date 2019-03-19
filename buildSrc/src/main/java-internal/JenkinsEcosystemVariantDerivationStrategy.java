import org.gradle.internal.component.external.model.JavaEcosystemVariantDerivationStrategy;
import org.gradle.internal.component.external.model.ModuleComponentResolveMetadata;
import org.gradle.internal.component.external.model.VariantDerivationStrategy;
import org.gradle.internal.component.model.ConfigurationMetadata;
import com.google.common.collect.ImmutableList;

public class JenkinsEcosystemVariantDerivationStrategy implements VariantDerivationStrategy {
    private final VariantDerivationStrategy delegate = new JavaEcosystemVariantDerivationStrategy();

    @Override
    public boolean derivesVariants() {
        return true;
    }

    @Override
    public ImmutableList<? extends ConfigurationMetadata> derive(ModuleComponentResolveMetadata metadata) {
        System.out.println("Resolving Jenkins variants");
        ImmutableList<? extends ConfigurationMetadata> javaVariants = delegate.derive(metadata);
        if (javaVariants == null) {
            return null;
        }
        return javaVariants;
    }
}
