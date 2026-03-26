@FunctionalInterface
public interface Operation<T> {
    T operate(T a, T b);
}