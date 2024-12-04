package com.fyiernzy.simplegrep.handler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.fyiernzy.simplegrep.constant.CommonConstant.LINE_SEPARATOR;

public abstract class HandlerComposer {
    private final List<Handler> handlers;

    public HandlerComposer(List<Handler> initialHandlers) {
        this.handlers = new ArrayList<>(Objects.nonNull(initialHandlers) ? initialHandlers : Collections.emptyList());
    }

    public HandlerComposer() {
        this.handlers = new ArrayList<>();
    }

    public void addHandler(Handler handler) {
        handlers.add(handler);
    }

    public void removeHandler(Handler handler) {
        handlers.remove(handler);
    }

    public String process(String content) {
        return handlers.stream()
                .reduce(
                        Stream.of(content.split(LINE_SEPARATOR)),
                        (stream, handler) -> handler.handle(stream),
                        (stream1, stream2) -> stream1 // Combine is not used here, so just return stream1
                )
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    public List<Handler> getHandlers() {
        return Collections.unmodifiableList(handlers);
    }
}