package mx.unam.ib.ibdata.api.model.collection;

public class IbdAwards {
	
	private Integer wins;
	
	private Integer nominations;

	public Integer getWins() {
		return wins;
	}

	public void setWins(Integer wins) {
		this.wins = wins;
	}

	public Integer getNominations() {
		return nominations;
	}

	public void setNominations(Integer nominations) {
		this.nominations = nominations;
	}

	@Override
	public String toString() {
		return "IbdAwards [wins=" + wins + ", nominations=" + nominations + "]";
	}


	
}
