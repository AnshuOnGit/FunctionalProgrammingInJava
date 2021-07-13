package org.simple.lifeiseasy.monads;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public abstract class Try<T> {

	public static <U> Try<U> ofFailable(Supplier<U> func) {
		Objects.requireNonNull(func);
		try {
			return Try.successful(func.get());
		} catch (Throwable e) {
			return Try.failure(e);
		}
	}

	public static <U> Try<U> successful(U x) {
		return new Success<>(x);
	}

	@SuppressWarnings("rawtypes")
	public static <U> Try<U> failure(Throwable e) {
		return new Failure(e);
	}

	public abstract <U> Try<U> map(Function<? super T, ? extends U> f);

	public abstract <U> Try<U> flatMap(Function<? super T, Try<U>> f);

	public abstract T orElse(T value);

	public abstract Try<T> orElseTry(Supplier<T> f);

	public abstract <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X;

	public abstract T get() throws Throwable;

	public abstract Try<T> filter(Predicate<T> pred);
	
    public abstract <E extends Throwable> Try<T> onSuccess(Consumer<T> action) throws E;
    
    public abstract <E extends Throwable> Try<T> onFailure(Consumer<Throwable> action) throws E;

}
