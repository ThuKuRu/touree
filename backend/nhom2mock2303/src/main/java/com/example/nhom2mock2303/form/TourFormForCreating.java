package com.example.nhom2mock2303.form;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class TourFormForCreating {
	
	private Integer id;
	
	private String tourName;
	
	private float price;
	
	private int rate;
	
	private String information;
	
	private String image;
	
	private String departurePoint;
	
	private String pointOfDepature;
	
	private String dateTour;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date createDate;
	
	private Integer tourLocationID;

	private Integer oderID;

	private Integer favoriteTourID;

}
