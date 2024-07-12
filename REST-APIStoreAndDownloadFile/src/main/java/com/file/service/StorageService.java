package com.file.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.file.entity.ImageData;
import com.file.repository.StorageRepo;
import com.file.util.ImageUtils;

@Service
public class StorageService {
	
	@Autowired
	private StorageRepo sRepo;
	
	public String uploadImage(MultipartFile file) throws IOException{
		
	ImageData imageData=sRepo.save(ImageData.builder()
		.name(file.getOriginalFilename())
		.type(file.getContentType())
		.imageData(ImageUtils.compressImage(file.getBytes())).build());
	
		if(imageData != null) {
			return "file uploaded success: " +file.getOriginalFilename();
		}
		return null;
	}
	
	public byte[] downloadImage(String fileName) {
		
		Optional<ImageData>dbImageData=sRepo.findByName(fileName);
		
		byte[] images=ImageUtils.decompressImage(dbImageData.get().getImageData());
	
	     return images;
	}

}
