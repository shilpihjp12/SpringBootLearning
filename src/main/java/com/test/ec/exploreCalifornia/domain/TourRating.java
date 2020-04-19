package com.test.ec.exploreCalifornia.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="Tour_Rating")
@IdClass(TourRatingPK.class)
public class TourRating implements Serializable {
	
//	@EmbeddedId
//	private TourRatingPK pk;
	@Id
	@ManyToOne
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JoinColumn(name="tourId", referencedColumnName="id", insertable=false, updatable=false)
	private Tour tour;
	
	  public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	@Id
	 // @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name="customer_Id", nullable=false)
	  private Integer customerId;
	  
	  private int tourId;

	@Min(0)
	@Max(5)
	@Column(name="score")
	private int score;
	
	@Column(name="description", length=255)
	private String description;
	
//	
//	public TourRatingPK getRatingPK() {
//		return pk;
//	}
//
//	public void setRatingPK(TourRatingPK pk) {
//		this.pk = pk;
//	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
