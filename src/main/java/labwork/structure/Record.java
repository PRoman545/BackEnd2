package labwork.structure;

import lombok.Builder;
import lombok.Value;

import java.util.UUID;
import java.time.ZonedDateTime;

@Builder
@Value

public class Record {

    UUID id;
    String userId;
    String categoryId;
    ZonedDateTime date;
    Double expense;

}