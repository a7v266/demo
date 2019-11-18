package com.example.demo.model.search;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class Search {

    private static final Logger LOGGER = LoggerFactory.getLogger(Search.class);

    private static final String LIMIT = "limit";
    private static final String OFFSET = "offset";

    private Long limit = 10L;
    private Long offset = 0L;

    public Search(Map<String, String> parameters) {
        setLimit(getLong(LIMIT, parameters));
        setOffset(getLong(OFFSET, parameters));
    }

    protected final Long getLong(String parameter, Map<String, String> parameters) {
        if (parameters.containsKey(parameter)) {
            try {
                return Long.valueOf(parameters.get(parameter));

            } catch (NumberFormatException exception) {
                LOGGER.error(exception.getMessage(), exception);
            }
        }
        return null;
    }

    public Long getLimit() {
        return limit;
    }

    public final void setLimit(Long limit) {
        if (limit != null) {
            this.limit = limit;
        }
    }

    public Long getOffset() {
        return offset;
    }

    public final void setOffset(Long offset) {
        if (offset != null) {
            this.offset = offset;
        }
    }
}
