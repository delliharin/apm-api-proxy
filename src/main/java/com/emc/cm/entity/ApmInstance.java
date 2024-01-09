package com.emc.cm.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "apminstance")
@Data
public class ApmInstance {
    @Id
    private String id;
    private String url;
    private String description;
}
