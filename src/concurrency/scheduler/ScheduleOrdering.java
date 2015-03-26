package concurrency.scheduler;

public interface ScheduleOrdering {
	public boolean scheduleBefore(ScheduleOrdering s);
}
