package io.gihub.niandy.specification;

import jakarta.persistence.FlushModeType;

import java.util.HashMap;
import java.util.Map;

public abstract class HintAwareSpecificationImpl<T> implements HintAwareSpecification<T> {

    public static final String HINT_LOCK_TIMEOUT = "jakarta.persistence.lock.timeout";
    public static final String HINT_QUERY_TIMEOUT = "jakarta.persistence.query.timeout";
    public static final String HINT_LOAD_GRAPH = "jakarta.persistence.loadgraph";
    public static final String HINT_FETCH_GRAPH = "jakarta.persistence.fetchgraph";
    public static final String HINT_READ_ONLY = "org.hibernate.readOnly";
    public static final String HINT_FETCH_SIZE = "org.hibernate.fetchSize";
    public static final String HINT_FLUSH_MODE = "org.hibernate.flushMode";
    private final Map<String,Object> hints = new HashMap<>();

    @Override
    public Map<String, Object> hints() {
        return hints;
    }


    public void lockTimeout(Long timeout) {
        hints.put(HINT_LOCK_TIMEOUT, timeout);
    }

    public void queryTimeout(Long timeout) {
        hints.put(HINT_QUERY_TIMEOUT, timeout);
    }

    public void loadGraph(String name) {
        hints.put(HINT_LOAD_GRAPH, name);
    }

    public void fetchGraph(String name) {
        hints.put(HINT_FETCH_GRAPH, name);
    }

    public void readOnly(Boolean readOnly) {
        hints.put(HINT_READ_ONLY, readOnly);
    }

    public void fetchSize(Long size) {
        hints.put(HINT_FETCH_SIZE, size);
    }

    public void flushMode(FlushModeType flushModeType) {
        hints.put(HINT_FLUSH_MODE, flushModeType);
    }
}
