package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@Table(name = "T_POSST")
public class Posst implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="User_Id")
	private long id;
	
//	@Column(name="Posst_Text")
//	private String text;
//	
//	@Column(name="Picture")
//	private String picture;
//	
//	@Column(name="Like")
//	private long like;
//	
//	@Column(name="dislike")
//	private long dislike;
//	
//	
//	@Column(name="Posst_Date")
//	@Temporal(TemporalType.DATE)
//	private Date date;
//	
////	@ManyToOne
////	User user;
//
//
//	public long getId() {
//		return id;
//	}
//
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//
//	public String getText() {
//		return text;
//	}
//
//
//	public void setText(String text) {
//		this.text = text;
//	}
//
//
//	public String getPicture() {
//		return picture;
//	}
//
//
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
//
//
//	public long getLike() {
//		return like;
//	}
//
//
//	public void setLike(long like) {
//		this.like = like;
//	}
//
//
//	public long getDislike() {
//		return dislike;
//	}
//
//
//	public void setDislike(long dislike) {
//		this.dislike = dislike;
//	}
//
//
//	public Date getDate() {
//		return date;
//	}
//
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//	
	
}


