package org.materials.io.kafkaproducerconsumer.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private String department;
    private long salary;
}
