package com.sunny.firstjobapp.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getAllCompanies());
    }

    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyService.createCompany(company);
        return new ResponseEntity<>("Company added successfully!", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.getCompanyById(id);
        if (company != null) {
            return new ResponseEntity<>(company, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompanyById(@PathVariable Long id, @RequestBody Company company) {
        boolean updated = companyService.updateCompanyById(id, company);
        if (updated)
            return  ResponseEntity.ok("Company updated successfully");
        return new ResponseEntity<>("Company not found", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        boolean deleted = companyService.deleteCompanyById(id);
        System.out.println(deleted);
        if (deleted)
            return ResponseEntity.ok("Company deleted successfully");
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
