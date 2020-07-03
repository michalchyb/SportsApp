package pl.project.exception;

import java.util.List;

public class ExtensionError extends RuntimeException {

    public ExtensionError(List<String> contentTypes) {
        super("Wrong extension! Allowed values: " + contentTypes.toString());
    }
}
