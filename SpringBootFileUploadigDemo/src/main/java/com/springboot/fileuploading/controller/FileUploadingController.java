package com.springboot.fileuploading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.springboot.fileuploading.helper.FileUploadHelper;

@RestController
public class FileUploadingController {
	
	@Autowired
	private FileUploadHelper fHelper;

	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile multipartFile){
		System.out.println(multipartFile.getOriginalFilename());
		System.out.println(multipartFile.getContentType());
		System.out.println(multipartFile.getName());
		System.out.println(multipartFile.getSize());
		System.out.println(multipartFile.getResource());
		System.out.println(multipartFile.isEmpty());
		
		try 
		{
			// validation
			if(multipartFile.isEmpty()) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must be contain file...");
			}
			
			if(!multipartFile.getContentType().equals("image/jpeg")) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only Jpeg File allows to Upload...");
			}
			
			// upload filecode
			boolean f = this.fHelper.uploadFile(multipartFile);
			
			if(f==true) {
//				return ResponseEntity.ok("File is Successfully uploaded...");
				return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(multipartFile.getOriginalFilename()).toUriString());
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong try again");
	}
	
}
