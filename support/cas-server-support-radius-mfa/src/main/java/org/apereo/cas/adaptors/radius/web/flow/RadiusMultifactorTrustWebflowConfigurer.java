package org.apereo.cas.adaptors.radius.web.flow;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.configurer.AbstractMultifactorTrustedDeviceWebflowConfigurer;
import org.apereo.cas.web.flow.configurer.CasMultifactorWebflowCustomizer;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

import java.util.List;
import java.util.Optional;

/**
 * This is {@link RadiusMultifactorTrustWebflowConfigurer}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
public class RadiusMultifactorTrustWebflowConfigurer extends AbstractMultifactorTrustedDeviceWebflowConfigurer {

    public RadiusMultifactorTrustWebflowConfigurer(final FlowBuilderServices flowBuilderServices, final FlowDefinitionRegistry loginFlowDefinitionRegistry,
                                                   final boolean enableDeviceRegistration, final FlowDefinitionRegistry flowDefinitionRegistry,
                                                   final ConfigurableApplicationContext applicationContext,
                                                   final CasConfigurationProperties casProperties,
                                                   final List<CasMultifactorWebflowCustomizer> mfaFlowCustomizers) {
        super(flowBuilderServices, loginFlowDefinitionRegistry, enableDeviceRegistration,
            applicationContext, casProperties, Optional.of(flowDefinitionRegistry),
            mfaFlowCustomizers);
    }

    @Override
    protected void doInitialize() {
        registerMultifactorTrustedAuthentication();
    }

}
