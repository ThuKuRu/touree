package com.example.nhom2mock2303.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TourDTO {
	
	private Integer id;
	
	private String tourName;
	
	private float price;
	
	private int rate;
	
	private String information;
	
	private String image;
	
	private String departurePoint;
	
	private String pointOfDepature;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	
	private String dateTour;
	
	private String tourLocationId;

	private String odersId;

	private String favoriteToursId;
}
