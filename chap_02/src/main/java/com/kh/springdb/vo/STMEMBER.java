package com.kh.springdb.vo;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table
public class STMEMBER {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="st_Seq")
	@SequenceGenerator(name="st_Seq", sequenceName="st_Seq", allocationSize=1)
	private Long STNumber;
	private String memberName;
	private int KoreanScore;
	private int englishScore;
	private int mathScore;
	
	
	
}
