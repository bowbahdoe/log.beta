package dev.mccue.log.beta;

import java.util.List;
import java.util.function.Supplier;

public enum NoOpLogger implements Logger {
    INSTANCE;



    @Override
    public String toString() {
        return "NoOpLogger";
    }

    @Override
    public void event(Level level, String name, List<LogEntry> entries) {

    }

    @Override
    public <T> T span(Level level, String name, List<LogEntry> entries, Supplier<T> code) {
        return code.get();
    }

    @Override
    public <T> T withContext(List<LogEntry> entries, Supplier<T> code) {
        return code.get();
    }
}
