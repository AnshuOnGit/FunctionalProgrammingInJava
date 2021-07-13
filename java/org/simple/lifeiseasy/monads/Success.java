package org.simple.lifeiseasy.monads;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Success<T> extends Try<T> {

	private final T value;

	@Override
	public <U> Try<U> map(Function<? super T, ? extends U> f) {
		Objects.requireNonNull(f);
		try {
			return Try.successful(f.apply(this.value));
		} catch (Throwable t) {
			return Try.failure(t);
		}
	}

	public Success(T value) {
		this.value = value;
	}

	@Override
	public <U> Try<U> flatMap(Function<? super T, Try<U>> f) {
		Objects.requireNonNull(f);
		try {
			return f.apply(value);
		} catch (Throwable t) {
			return Try.failure(t);
		}
	}

	@Override
	public T orElse(T value) {
		return this.value;
	}

	@Override
	public Try<T> orElseTry(Supplier<T> f) {
		Objects.requireNonNull(f);
		return this;
	}

	@Override
	public <X extends Throwable> T orElseThrow(Supplier<? extends X> exceptionSupplier) throws X {
		Objects.requireNonNull(exceptionSupplier);
		return this.value;
	}

	@Override
	public T get() throws Throwable {
		return this.value;
	}

	@Override
	public Try<T> filter(Predicate<T> pred) {
		Objects.requireNonNull(pred);
		if (pred.test(this.value)) {
			return this;
		} else {
			return Try.failure(new NoSuchElementException("Predicate does not match for " + value));
		}
	}

	@Override
	public <E extends Throwable> Try<T> onSuccess(Consumer<T> action) throws E {
		action.accept(this.value);
		return this;
	}

	@Override
	public <E extends Throwable> Try<T> onFailure(Consumer<Throwable> action) throws E {
		return this;
	}


}
