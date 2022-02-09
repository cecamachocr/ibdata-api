package mx.unam.ib.ibdata.api.model.collection;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movies")
public class IbdMovie {
	
	@Id
	private String _id;
	
	private String plot;
	
	private List<String>genres;
	
	private Integer runtime;
	
	private  List<String> cast;
	
	private Integer num_mflix_comments;
	
	private String title;
	
	private String fullplot;
	
	private  List<String> countries;
	
	private Date released;
	
	private  List<String> directors;
	
	private String rated;
	
	private IbdAwards awards;
	
	private Date lastupdated;
	
	private Integer year;
	
	private String type;
	
	private IbdTomatoes tomatoes;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}

	public List<String> getCast() {
		return cast;
	}

	public void setCast(List<String> cast) {
		this.cast = cast;
	}

	public Integer getNum_mflix_comments() {
		return num_mflix_comments;
	}

	public void setNum_mflix_comments(Integer num_mflix_comments) {
		this.num_mflix_comments = num_mflix_comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFullplot() {
		return fullplot;
	}

	public void setFullplot(String fullplot) {
		this.fullplot = fullplot;
	}

	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	public Date getReleased() {
		return released;
	}

	public void setReleased(Date released) {
		this.released = released;
	}

	public List<String> getDirectors() {
		return directors;
	}

	public void setDirectors(List<String> directors) {
		this.directors = directors;
	}

	public String getRated() {
		return rated;
	}

	public void setRated(String rated) {
		this.rated = rated;
	}

	public IbdAwards getAwards() {
		return awards;
	}

	public void setAwards(IbdAwards awards) {
		this.awards = awards;
	}

	public Date getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(Date lastupdated) {
		this.lastupdated = lastupdated;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public IbdTomatoes getTomatoes() {
		return tomatoes;
	}

	public void setTomatoes(IbdTomatoes tomatoes) {
		this.tomatoes = tomatoes;
	}

	@Override
	public String toString() {
		return "IbdMovie [_id=" + _id + ", plot=" + plot + ", genres=" + genres + ", runtime=" + runtime + ", cast="
				+ cast + ", num_mflix_comments=" + num_mflix_comments + ", title=" + title + ", fullplot=" + fullplot
				+ ", countries=" + countries + ", released=" + released + ", directors=" + directors + ", rated="
				+ rated + ", awards=" + awards + ", lastupdated=" + lastupdated + ", year=" + year + ", type=" + type
				+ ", tomatoes=" + tomatoes + "]";
	}
	
	
}
