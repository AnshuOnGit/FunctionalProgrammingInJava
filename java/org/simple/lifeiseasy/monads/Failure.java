package org.simple.lifeiseasy.monads;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Failure<T> extends Try<T> {

	private final Throwable value;

	@Override
	public <U> Try<U> map(Function<? super T, ? extends U> f) {
		Objects.requireNonNull(f);
		return Try.failure(this.value);
	}

	public Failure(Throwable value) {
		this.value = value;
	}

	@Override
	public <U> Try<U> flatMap(Function<? super T, Try<U>> f) {
		Objects.requireNonNull(f);
		return Try.failure(this.value);
	}

	@Override
	public T orElse(T value) {
		return value;
	}

	@Override
	public Try<T> orElseTry(Supplier<T> f) {
		Objects.requireNonNull(f);
		return Try.ofFailable(f);
	}

	@Override
	public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		throw exceptionSupplier.get();
	}

	@Override
	public T get() throws Throwable {
		throw this.value;
	}

	@Override
	public Try<T> filter(Predicate<T> pred) {
		return this;
	}

	@Override
	public <E extends Throwable> Try<T> onSuccess(Consumer<T> action) throws E {
		return this;
	}

	@Override
	public <E extends Throwable> Try<T> onFailure(Consumer<Throwable> action) throws E {
		action.accept(this.value);
		return this;
	}

}
