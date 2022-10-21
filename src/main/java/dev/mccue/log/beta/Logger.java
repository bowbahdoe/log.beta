package dev.mccue.log.beta;

import java.util.List;
import java.util.function.Supplier;

/**
 * A logger.
 */
public interface Logger {
    void event(Level level, String name, List<LogEntry> entries);

    default void event(Level level, String name, LogEntry... entries) {
        event(level, name, List.of(entries));
    }

    default void trace(String name, List<LogEntry> entries) {
        event(Level.TRACE, name, entries);
    }

    default void trace(String name, LogEntry... entries) {
        event(Level.TRACE, name, entries);
    }

    default void debug(String name, List<LogEntry> entries) {
        event(Level.DEBUG, name, entries);
    }

    default void debug(String name, LogEntry... entries) {
        event(Level.DEBUG, name, entries);
    }

    default void info(String name, List<LogEntry> entries) {
        event(Level.INFO, name, entries);
    }

    default void info(String name, LogEntry... entries) {
        event(Level.INFO, name, entries);
    }

    default void warn(String name, List<LogEntry> entries) {
        event(Level.WARN, name, entries);
    }

    default void warn(String name, LogEntry... entries) {
        event(Level.WARN, name, entries);
    }

    default void error(String name, List<LogEntry> entries) {
        event(Level.ERROR, name, entries);
    }

    default void error(String name, LogEntry... entries) {
        event(Level.ERROR, name, entries);
    }

    <T> T span(Level level, String name, List<LogEntry> entries, Supplier<T> code);

    default void span(
            Level level,
            String name,
            List<LogEntry> entries,
            Runnable code
    ) {
        span(level, name, entries, () -> {
            code.run();
            return null;
        });
    }

    default <T> T traceSpan(
            String name,
            List<LogEntry> entries,
            Supplier<T> code
    ) {
        return span(Level.TRACE, name, entries, code);
    }

    default void traceSpan(
            String name,
            List<LogEntry> entries,
            Runnable code
    ) {
        span(Level.TRACE, name, entries, code);
    }

    default <T> T debugSpan(
            String name,
            List<LogEntry> entries,
            Supplier<T> code
    ) {
        return span(Level.DEBUG, name, entries, code);
    }

    default void debugSpan(
            String name,
            List<LogEntry> entries,
            Runnable code
    ) {
        span(Level.DEBUG, name, entries, code);
    }

    default <T> T infoSpan(
            String name,
            List<LogEntry> entries,
            Supplier<T> code
    ) {
        return span(Level.INFO, name, entries, code);
    }

    default void infoSpan(
            String name,
            List<LogEntry> entries,
            Runnable code
    ) {
        span(Level.INFO, name, entries, code);
    }

    default <T> T warnSpan(
            String name,
            List<LogEntry> entries,
            Supplier<T> code
    ) {
        return span(Level.WARN, name, entries, code);
    }

    default void warnSpan(
            String name,
            List<LogEntry> entries,
            Runnable code
    ) {
        span(Level.WARN, name, entries, code);
    }

    default <T> T errorSpan(
            String name,
            List<LogEntry> entries,
            Supplier<T> code
    ) {
        return span(Level.WARN, name, entries, code);
    }

    default void errorSpan(
            String name,
            List<LogEntry> entries,
            Runnable code
    ) {
        span(Level.ERROR, name, entries, code);
    }

    <T> T withContext(List<LogEntry> entries, Supplier<T> code);

    default void withContext(List<LogEntry> entries, Runnable code) {
        withContext(entries, () -> {
            code.run();
            return null;
        });
    }
}