package mx.unam.ib.ibdata.api.model.collection;

public class IbdViewer {
	
	private Float rating;
	
	private Integer numReviews;
	
	private Integer meter;

	public Float getRating() {
		return rating;
	}

	public void setRating(Float rating) {
		this.rating = rating;
	}

	public Integer getNumReviews() {
		return numReviews;
	}

	public void setNumReviews(Integer numReviews) {
		this.numReviews = numReviews;
	}

	public Integer getMeter() {
		return meter;
	}

	public void setMeter(Integer meter) {
		this.meter = meter;
	}

	@Override
	public String toString() {
		return "IbdViewer [rating=" + rating + ", numReviews=" + numReviews + ", meter=" + meter + "]";
	}
	
	
}
