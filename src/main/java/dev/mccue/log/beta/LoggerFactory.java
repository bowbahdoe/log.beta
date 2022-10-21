package dev.mccue.log.beta;

import java.util.ArrayList;
import java.util.ServiceLoader;
import java.util.concurrent.ThreadLocalRandom;

@FunctionalInterface
public interface LoggerFactory {
    static LoggerFactory create() {
        var loggerFactories = ServiceLoader.load(LoggerFactory.class).iterator();
        if (!loggerFactories.hasNext()) {
            System.err.println("No logger factory supplied. Falling back to no-op logger");
            return (__) -> NoOpLogger.INSTANCE;
        } else {
            var service = loggerFactories.next();
            if (loggerFactories.hasNext()) {
                var services = new ArrayList<LoggerFactory>();
                services.add(service);
                while (loggerFactories.hasNext()) {
                    services.add(loggerFactories.next());
                }

                System.err.printf("Multiple logger factories supplied: %s. Picking one at random.%n", services);
                return services.get(ThreadLocalRandom.current().nextInt(0, services.size()));
            } else {
                return service;
            }
        }
    }

    static Logger getLogger(String namespace) {
        return create().createLogger(namespace);
    }

    static Logger getLogger(Class<?> klass) {
        return create().createLogger(klass.getCanonicalName());
    }

    /**
     * Creates a logger.
     *
     * @param namespace The "namespace" to associate with events coming into
     *                  the logger.
     * @return A logger.
     */
    Logger createLogger(String namespace);
}