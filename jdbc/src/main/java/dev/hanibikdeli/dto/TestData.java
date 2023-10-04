package dev.hanibikdeli.dto;

import dev.hanibikdeli.dao.DataTransferObject;

public class TestData implements DataTransferObject {

    private Long id;

    private String title;

    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Long getId() {
        return this.id;
    }
}
