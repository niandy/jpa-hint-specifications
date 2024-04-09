package io.gihub.niandy.repository;

import io.gihub.niandy.specification.HintAwareSpecification;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;



public class HintAwareRepository<T, ID> extends SimpleJpaRepository<T, ID> {
    public HintAwareRepository(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
    }

    @Override
    protected <S extends T> TypedQuery<S> getQuery(Specification<S> spec, Class<S> domainClass, Pageable pageable) {
        var query = super.getQuery(spec, domainClass, pageable);
        if (spec instanceof HintAwareSpecification<S> hintSpec) {
            var hints = hintSpec.hints();
            if (hints!=null && !hints.isEmpty()) {
                for (var entry : hints.entrySet()) {
                    query.setHint(entry.getKey(), entry.getValue());
                }
            }
        }
        return query;
    }
}
