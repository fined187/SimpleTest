package com.practice.simpleTest;

import com.sun.javaws.progress.Progress;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Getter
public class OnlineLecture {
    private Long id;
    private String title;
    private boolean closed;
    private Progress progress;

    public OnlineLecture(Long id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public OnlineLecture() {

    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }
}

