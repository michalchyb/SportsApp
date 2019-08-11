package pl.project.utils.mapper;

public interface Mapper<F, T> {

    T map(F from);

    F reverseMap(T to);
}