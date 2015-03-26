package concurrency.scheduler;

import java.util.Date;

public class Request implements ScheduleOrdering {
	private Date time = new Date();
	
	public Date getTime() {
		return time;
	}

	public boolean scheduleBefore(ScheduleOrdering s) {
		if (s instanceof Request) {
			return getTime().before(((Request)s).getTime());
		}
		return false;
	}
}
