package concurrency.threadlocal;

/** 
 * Return a unique transaction ID for each thread that accesses this class
 * 
 * @author Omer Shatil
 *
 */
public class TransactionID {
	private static int tID = 1;
	
	private static ThreadLocal<Integer> transactionID = new ThreadLocal<Integer>() {
		protected synchronized Integer initialValue() {
			return new Integer(tID++);
		}
	};
	public static int get() {
		return ((Integer) transactionID.get());
	}
}
