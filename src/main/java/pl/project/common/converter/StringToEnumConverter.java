package pl.project.common.converter;

import org.springframework.core.convert.converter.Converter;
import pl.project.model.SortBy;

public class StringToEnumConverter implements Converter<String, SortBy> {
    @Override
    public SortBy convert(String source) {
        return SortBy.valueOf(source.toLowerCase());
    }
}
