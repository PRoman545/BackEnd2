package labwork.service;

import labwork.structure.Record;
import labwork.service.errorHandler.InvalidArguments;
import labwork.service.errorHandler.RecordNotFound;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class Records {

    private Map<UUID, Record> recordMap = new HashMap<>();

    public Record addRecord(Record record) {
        Record newRecord = Record.builder()
                .id(UUID.randomUUID())
                .userId(record.getUserId())
                .categoryId(record.getCategoryId())
                .date(record.getDate() != null ? record.getDate() : ZonedDateTime.now(ZoneId.of("Europe/Kiev")))
                .expense(record.getExpense())
                .build();
        recordMap.put(newRecord.getId(), newRecord);
        return newRecord;
    }
    
    public List<Record> getRecords(String userId, String categoryId) {
        if (userId == null && categoryId == null) {
            throw new InvalidArguments("UserId or categoryId must be provided");
        }
        return recordMap.values().stream()
                .filter(record -> (userId == null || record.getUserId().equals(userId)) &&
                        (categoryId == null || record.getCategoryId().equals(categoryId)))
                .collect(Collectors.toList());
    }
    
    public Record getRecordId(UUID id) {
        if (!recordMap.containsKey(id)) {
            throw new RecordNotFound(id);
        }
        return recordMap.get(id);
    }

    public void deleteRecordId(UUID id) {
        Record record = getRecordId(id);
        recordMap.remove(record.getId());
    }

}