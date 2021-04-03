package com.nitc.hibernate.onetomany.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student 
{
	
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private Long id;
		
		@Column(name="enrollment_id", nullable=false)
		private String enrollmentId;	
		
		private String name;
		
		@ManyToOne(cascade={CascadeType.PERSIST})
		@JoinColumn(name="guide_id")
		private Guide guide;
		
		public Student() {}
		public Student(String enrollmentId, String name, Guide guide) {
			this.enrollmentId = enrollmentId;
			this.name = name;
			this.guide = guide;
		}
		
		public String getName() {
			return name;
		}
		
		public Guide getGuide() {
			return guide;
		}
		public void setGuide(Guide guide) {
			this.guide = guide;
		}
		
}
