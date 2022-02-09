package mx.unam.ib.ibdata.api.model.collection;

import java.util.Date;

public class IbdTomatoes {
	
	private IbdViewer viewer;
	
	private Date lastUpdated;

	public IbdViewer getViewer() {
		return viewer;
	}

	public void setViewer(IbdViewer viewer) {
		this.viewer = viewer;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "IbdTomatoes [viewer=" + viewer + ", lastUpdated=" + lastUpdated + "]";
	} 
}
