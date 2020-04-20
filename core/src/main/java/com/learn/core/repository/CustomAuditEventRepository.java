package com.learn.core.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of Spring Boot's {@link AuditEventRepository}.
 */
@Slf4j
@Repository
public class CustomAuditEventRepository implements AuditEventRepository {

    private static final String AUTHORIZATION_FAILURE = "AUTHORIZATION_FAILURE";

    /**
     * Should be the same as in Liquibase migration.
     */
    protected static final int EVENT_DATA_COLUMN_MAX_LENGTH = 255;

    public CustomAuditEventRepository() {
    }

    @Override
    public List<AuditEvent> find(String principal, Instant after, String type) {

        return new ArrayList<>();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void add(AuditEvent event) {
//        if (!AUTHORIZATION_FAILURE.equals(event.getType()) &&
//            !Constants.ANONYMOUS_USER.equals(event.getPrincipal())) {
//
//        }
    }

}
