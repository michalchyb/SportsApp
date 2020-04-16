package pl.project.exception;

import org.slf4j.Logger;

public abstract class BaseExceptionHandler {
    private final Logger log;

    protected BaseExceptionHandler(final Logger log) {
        this.log = log;
    }
}
