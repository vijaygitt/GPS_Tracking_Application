package com.GPS_Tracking.Application.controllers;

        import com.GPS_Tracking.Application.payloads.OwnerDto;
        import com.GPS_Tracking.Application.services.OwnerService;
        import jakarta.validation.Valid;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.PostMapping;
        import org.springframework.web.bind.annotation.RequestBody;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for managing owner-related operations.
 */
@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    /**
     * Creates a new owner.
     *
     * @param ownerDto The owner's data to create.
     * @return ResponseEntity containing the created owner data.
     */
    @PostMapping("/")
    public ResponseEntity<OwnerDto> createOwner(@Valid @RequestBody OwnerDto ownerDto){
        OwnerDto createdOwnerDto = this.ownerService.createOwner(ownerDto);
        return new ResponseEntity<>(ownerDto, HttpStatus.CREATED);
    }
}
