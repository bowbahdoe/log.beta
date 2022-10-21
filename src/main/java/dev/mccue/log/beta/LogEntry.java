package dev.mccue.log.beta;

import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public record LogEntry(String key, Value value) {
    public LogEntry(String key, Value value) {
        Objects.requireNonNull(key, "Entry key must not be null");
        this.key = key;
        this.value = value == null ? Value.Null.INSTANCE : value;
    }

    public static LogEntry of(String key, String value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, boolean value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, byte value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, char value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, short value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, int value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, long value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, float value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, double value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Boolean value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Byte value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Character value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Short value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Integer value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Long value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Double value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, UUID value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, java.net.URI value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Instant value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, java.time.LocalDateTime value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, java.time.LocalDate value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, java.time.LocalTime value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, java.time.Duration value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Throwable value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, List<Value> value) {
        return new LogEntry(key, Value.of(value));
    }

    public static LogEntry of(String key, Map<String, Value> value) {
        return new LogEntry(key, Value.of(value));
    }

    public static <T> LogEntry of(String key, T value, Function<T, Value> toValue) {
        return new LogEntry(key, Value.of(value, toValue));
    }

    public static LogEntry of(String key, Supplier<Value> valueSupplier) {
        return new LogEntry(key, Value.of(valueSupplier));
    }

    public static LogEntry ofLazy(String key, Supplier<Value> valueSupplier) {
        return new LogEntry(key, Value.ofLazy(valueSupplier));
    }

    public static <T> LogEntry ofLazy(String key, T value, Function<T, Value> toValue) {
        return new LogEntry(key, Value.ofLazy(value, toValue));
    }

    /**
     * A loggable value.
     *
     * <p>Only supports a subset of "basic" data kinds</p>
     */
    public sealed interface Value {
        static Value of(java.lang.String value) {
            return of(value, String::new);
        }

        static Value of(boolean value) {
            return new Boolean(value);
        }

        static Value of(byte value) {
            return new Byte(value);
        }

        static Value of(char value) {
            return new Character(value);
        }

        static Value of(java.lang.String key, short value) {
            return new Short(value);
        }

        static Value of(int value) {
            return new Integer(value);
        }

        static Value of(long value) {
            return new Long(value);
        }

        static Value of(float value) {
            return new Float(value);
        }

        static Value of(double value) {
            return new Double(value);
        }

        static Value of(java.lang.Boolean value) {
            return of(value, Boolean::new);
        }

        static Value of(java.lang.Byte value) {
            return of(value, Byte::new);
        }

        static Value of(java.lang.Character value) {
            return of(value, Character::new);
        }

        static Value of(java.lang.Short value) {
            return of(value, Short::new);
        }

        static Value of(java.lang.Integer value) {
            return of(value, Integer::new);
        }

        static Value of(java.lang.Long value) {
            return of(value, Long::new);
        }

        static Value of(java.lang.Double value) {
            return of(value, Double::new);
        }

        static Value of(java.util.UUID value) {
            return of(value, UUID::new);
        }

        static Value of(java.net.URI value) {
            return of(value, URI::new);
        }

        static Value of(java.time.Instant value) {
            return of(value, Instant::new);
        }

        static Value of(java.time.LocalDateTime value) {
            return of(value, LocalDateTime::new);
        }

        static Value of(java.time.LocalDate value) {
            return of(value, LocalDate::new);
        }

        static Value of(java.time.LocalTime value) {
            return of(value, LocalTime::new);
        }

        static Value of(java.time.Duration value) {
            return of(value, Duration::new);
        }

        static Value of(java.lang.Throwable value) {
            return of(value, Throwable::new);
        }

        static Value of(java.util.List<Value> value) {
            return of(value, List::new);
        }

        static Value of(java.util.Map<java.lang.String, Value> value) {
            return of(value, Map::new);
        }

        static <T> Value of(T value, Function<T, Value> toValue) {
            return value == null ? Null.INSTANCE : toValue.apply(value);
        }

        static Value of(Supplier<Value> valueSupplier) {
            var value = valueSupplier.get();
            return value == null ? Null.INSTANCE : value;
        }

        static Value ofLazy(Supplier<Value> valueSupplier) {
            return new Lazy(valueSupplier);
        }

        static <T> Value ofLazy(T value, Function<T, Value> toValue) {
            return new Lazy(() -> {
                var v = toValue.apply(value);
                return v == null ? Null.INSTANCE : v;
            });
        }

        /**
         * null
         */
        enum Null implements Value {
            INSTANCE;

            @Override
            public java.lang.String toString() {
                return "Null";
            }
        }

        /**
         * A String.
         *
         * @param value The {@link java.lang.String} being wrapped. Must not be null.
         */
        record String(java.lang.String value) implements Value {
            public String {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A boolean.
         *
         * @param value A wrapped boolean.
         */
        record Boolean(boolean value) implements Value {
        }

        /**
         * A byte.
         *
         * @param value A wrapped byte.
         */
        record Byte(byte value) implements Value {
        }

        /**
         * A char.
         *
         * @param value A wrapped char.
         */
        record Character(char value) implements Value {
        }

        /**
         * A short.
         *
         * @param value A wrapped shirt.
         */
        record Short(short value) implements Value {
        }

        /**
         * An int.
         *
         * @param value A wrapped int.
         */
        record Integer(int value) implements Value {
        }

        /**
         * A long.
         *
         * @param value A wrapped long.
         */
        record Long(long value) implements Value {
        }

        /**
         * A float.
         *
         * @param value A wrapped float.
         */
        record Float(float value) implements Value {
        }

        /**
         * A double.
         *
         * @param value A wrapped double.
         */
        record Double(double value) implements Value {
        }

        /**
         * A UUID.
         *
         * @param value A wrapped {@link java.util.UUID}.
         */
        record UUID(java.util.UUID value) implements Value {
            /**
             * @param value The {@link java.util.UUID} being wrapped. Must not be null.
             */
            public UUID {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A URI.
         *
         * @param value A wrapped {@link java.net.URI}. Must not be null.
         */
        record URI(java.net.URI value) implements Value {
            public URI {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * An instant in time.
         *
         * @param value A wrapped {@link java.time.Instant}. Must not be null.
         */
        record Instant(java.time.Instant value) implements Value {
            public Instant {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A local date-time.
         *
         * @param value A wrapped {@link java.time.LocalDateTime}. Must not be null.
         */
        record LocalDateTime(java.time.LocalDateTime value) implements Value {
            public LocalDateTime {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A local date without a time component. Must not be null.
         *
         * @param value A wrapped {@link java.time.LocalDate}.
         */
        record LocalDate(java.time.LocalDate value) implements Value {
            public LocalDate {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A local time without a date component.
         *
         * @param value A wrapped {@link java.time.LocalTime}.
         */
        record LocalTime(java.time.LocalTime value) implements Value {
            /**
             * @param value The {@link java.time.LocalTime} being wrapped. Must not be null.
             */
            public LocalTime {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A duration of time.
         *
         * @param value A wrapped {@link java.time.Duration}.
         */
        record Duration(java.time.Duration value) implements Value {
            /**
             * @param value The {@link java.time.Duration} being wrapped. Must not be null.
             */
            public Duration {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A throwable value. Represents an error that occurred when doing some computation.
         *
         * @param value The throwable that was thrown.
         */
        record Throwable(java.lang.Throwable value) implements Value {
            /**
             * @param value The {@link java.lang.Throwable} being wrapped.  Must not be null.
             */
            public Throwable {
                Objects.requireNonNull(value, "value must not be null");
            }
        }

        /**
         * A list of values.
         *
         * @param value The underlying {@link java.util.List}. Will be unmodifiable.
         */
        record List(java.util.List<Value> value) implements Value {
            /**
             * Constructs a new List.
             *
             * @param value The list of values to use to construct the list. Will copy the list
             *              and replace stray null values. Should not be null.
             */
            public List(java.util.List<Value> value) {
                Objects.requireNonNull(value, "value must not be null");
                this.value = value.stream()
                        .map(v -> v == null ? Null.INSTANCE : v)
                        .toList();
            }
        }

        /**
         * A map of value to value.
         *
         * @param value The underlying {@link java.util.Map}. Will be unmodifiable.
         */
        record Map(java.util.Map<java.lang.String, Value> value) implements Value {
            /**
             * Constructs a new Map.
             *
             * @param value The map of values to use to construct the map. Will copy the map
             *              and replace stray null values. Should not be null.
             */
            public Map(java.util.Map<java.lang.String, Value> value) {
                Objects.requireNonNull(value, "value must not be null");
                this.value = value.entrySet()
                        .stream()
                        .collect(Collectors.toUnmodifiableMap(
                                java.util.Map.Entry::getKey,
                                entry -> entry.getValue() == null ? Null.INSTANCE : entry.getValue()
                        ));
            }
        }

        /**
         * A set of values.
         *
         * <p>This is different from a list in that it is implied that no duplicates are
         * allowed and order is not assumed.</p>
         *
         * @param value The underlying {@link java.util.Set}. Will be unmodifiable.
         */
        record Set(java.util.Set<Value> value) implements Value {
            /**
             * Constructs a new Set.
             *
             * @param value The set of values to use to construct the set. Will copy the set
             *              and replace stray null values. Should not be null.
             */
            public Set(java.util.Set<Value> value) {
                Objects.requireNonNull(value, "value must not be null");
                this.value = value.stream()
                        .map(v -> v == null ? Null.INSTANCE : v)
                        .collect(Collectors.toUnmodifiableSet());
            }
        }

        /**
         * A lazily realized value.
         *
         * <p>When its value is requested it will be computed. If any exceptions
         * occur when realizing its Value then a Value.Throwable will be returned.</p>
         *
         * <p>After a value is computed it is stable and will not be recomputed.</p>
         */
        final class Lazy implements Value {
            // Implementation based off of clojure's Delay + vavr's Lazy
            private volatile Supplier<? extends Value> supplier;
            private Value value;

            /**
             * Constructs a Lazy value from the given supplier.
             *
             * @param supplier Code which will be called later to provide a value.
             */
            public Lazy(Supplier<? extends Value> supplier) {
                Objects.requireNonNull(supplier, "supplier must not be null");
                this.supplier = supplier;
                this.value = null;
            }

            /**
             * @return The computed {@link Value}. Will return the same value on repeat calls. Safe to call from
             * multiple threads.
             */
            public Value value() {
                if (supplier != null) {
                    synchronized (this) {
                        final var s = supplier;
                        if (s != null) {
                            try {
                                this.value = Objects.requireNonNullElse(s.get(), Null.INSTANCE);
                            } catch (java.lang.Throwable throwable) {
                                this.value = new Throwable(throwable);
                            }
                            this.supplier = null;
                        }
                    }
                }

                return this.value;
            }

            @Override
            public java.lang.String toString() {
                if (supplier != null) {
                    return "Lazy[pending]";
                } else {
                    return "Lazy[realized: value=" + value() + "]";
                }
            }
        }
    }
}