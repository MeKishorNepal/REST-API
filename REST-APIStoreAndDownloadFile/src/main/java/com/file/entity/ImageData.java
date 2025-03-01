package com.file.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ImageDate")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Builder 
public class ImageData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String name;
	private String type;
	
	@Lob
	@Column(name="imagedata")
	private byte[] imageData;


	

	

	
	
	


	
	
	
	
	

}
