package com.test.ec.exploreCalifornia.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TourRatingPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	@ManyToOne
//	@JoinColumn(name="tour_Id", referencedColumnName="id", insertable=false, updatable=false)
	private int tourId;
	
	//@Column(name="customer_Id", nullable=false)
	private Integer customerId;
	
//	@Column(name ="tourId")
//	private int tourId;
//	
	public TourRatingPK(int tourId, int customerId) {
		super();
		this.tourId = tourId;
		this.customerId = customerId;
	}
	
	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public TourRatingPK() {
		
	}

//	public Tour getTour() {
//		return tour;
//	}
//
//	public void setTour(Tour tour) {
//		this.tour = tour;
//	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
}

