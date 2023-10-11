package org.example.model;

import lombok.Data;

@Data
public class CancellationReason {
    private int reasonId;
    private String reasonText;
}