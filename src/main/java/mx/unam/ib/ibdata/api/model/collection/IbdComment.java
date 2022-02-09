package mx.unam.ib.ibdata.api.model.collection;

import java.util.Date;

import org.bson.types.ObjectId;

//@Document("comments")
public class IbdComment {
	//@Id
	private String _id;
	
	private String name;
	
	private String email;
	
//	@Field("movie_id")
//	@DBRef
	private ObjectId movie_id;
	
	private String text;
	
	private Date date;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ObjectId getMovie_id() {
		return movie_id;
	}

	public void setMovie_id(ObjectId movie_id) {
		this.movie_id = movie_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
