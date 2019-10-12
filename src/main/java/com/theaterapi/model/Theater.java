/*
This Class is For Theater Model included
theaterId for ID
seats for all seats id of this Theater
*/
package com.theaterapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Data
@Document(collection = "theater")
public class Theater {
    @Id
    private int theaterId;
    private List<String> seats;
}
