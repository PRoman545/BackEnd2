package labwork.web;

import labwork.structure.Record;
import labwork.service.Records;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/record")
@RequiredArgsConstructor
public class RecordsController {
	
    private final Records recordService;

    @GetMapping
    public ResponseEntity<List<Record>> getRecords(@RequestParam(required = false) String userId,
                                                   @RequestParam(required = false) String categoryId) {
        return ResponseEntity.ok(recordService.getRecords(userId, categoryId));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Record> getRecordId(@PathVariable UUID id) {
        return ResponseEntity.ok(recordService.getRecordId(id));
    }
    
    @PostMapping
    public ResponseEntity<Record> addRecord(@RequestBody Record record) {
        return ResponseEntity.ok(recordService.addRecord(record));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Record> deleteRecord(@PathVariable UUID id) {
        recordService.deleteRecordId(id);
        return ResponseEntity.noContent().build();
    }
    
}