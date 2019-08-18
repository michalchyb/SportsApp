package pl.project.commons.mapper;

public interface Mapper<F, T> {

    T map(F from);

    F reverseMap(T to);
}