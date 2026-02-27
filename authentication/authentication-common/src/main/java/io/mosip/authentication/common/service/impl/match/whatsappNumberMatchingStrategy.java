package io.mosip.authentication.common.service.impl.match;

import io.mosip.authentication.core.spi.indauth.match.MatchFunction;
import io.mosip.authentication.core.spi.indauth.match.MatchingStrategyType;
import io.mosip.authentication.core.spi.indauth.match.TextMatchingStrategy;
import io.mosip.authentication.core.util.DemoMatcherUtil;

import java.util.Map;

public enum whatsappNumberMatchingStrategy implements TextMatchingStrategy {

    EXACT(MatchingStrategyType.EXACT, (Object reqInfo, Object entityInfo, Map<String, Object> props) -> {
        if (reqInfo instanceof String && entityInfo instanceof String) {
            return getDemoMatcherUtilObject(props)
                    .doExactMatch((String) reqInfo, (String) entityInfo);
        } else {
            return 0;
        }
    });

    private final MatchFunction matchFunction;

    private final MatchingStrategyType matchStrategyType;


    private whatsappNumberMatchingStrategy(MatchingStrategyType matchStrategyType,
                                           MatchFunction matchFunction) {
        this.matchFunction = matchFunction;
        this.matchStrategyType = matchStrategyType;
    }

    @Override
    public MatchingStrategyType getType() {
        return matchStrategyType;
    }

    @Override
    public MatchFunction getMatchFunction() {
        return matchFunction;
    }

    public static DemoMatcherUtil getDemoMatcherUtilObject(Map<String, Object> props) {
        return (DemoMatcherUtil) props.get("demoMatcherUtil");
    }
}
