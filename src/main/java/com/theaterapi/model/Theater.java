package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.List;

@Data
@Document(collection = "theater")
public class Theater {
    @Id
    private int theaterId;
    private List<String> seat;
}
