package com.kh.cafe.vo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name="cafe")
public class cafe {
	@GeneratedValue(strategy=GenerationType.SEQUENCE , generator="sequence_name")
	@SequenceGenerator(name="cafe_sequence",sequenceName="cafe_seq",allocationSize=1)
	
	@Id
	private Long cafe_id;
	private String name;
	private String location;
	private String openhours;
	

}
