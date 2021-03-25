package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity 
@Table(name = "T_Comment")
public class Comment implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Comment_Id")
	private long id;
	
//	@Column(name="Like")
//	private int like;
//	
//	@Column(name="dislike")
//	private int dislike;
//	
//	@Column(name="Message_Date")
//	@Temporal(TemporalType.DATE)
//	private Date date;
//	
//	@Column(name="Text")
//	private String text;
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public int getLike() {
//		return like;
//	}
//
//	public void setLike(int like) {
//		this.like = like;
//	}
//
//	public int getDislike() {
//		return dislike;
//	}
//
//	public void setDislike(int dislike) {
//		this.dislike = dislike;
//	}
//
//	public Date getDate() {
//		return date;
//	}
//
//	public void setDate(Date date) {
//		this.date = date;
//	}
//
//	public String getText() {
//		return text;
//	}
//
//	public void setText(String text) {
//		this.text = text;
//	}

}
