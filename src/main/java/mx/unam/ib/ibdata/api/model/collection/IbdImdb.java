package mx.unam.ib.ibdata.api.model.collection;

public class IbdImdb {
	private Double rating;
	
	private Integer votes;
	
	private Integer id;

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "IbdImdb [rating=" + rating + ", votes=" + votes + ", id=" + id + "]";
	}
	
	
}
