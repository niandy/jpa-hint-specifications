package io.gihub.niandy.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public interface HintAwareSpecification<T> extends Specification<T> {
    Map<String, Object> hints();
}
