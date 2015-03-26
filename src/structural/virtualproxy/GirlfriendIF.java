package structural.virtualproxy;

/**
 * This girlfriend (unlike the one implemented in teh dynamiclinkage pattern)
 * cannot talk back. No back pointer is implemented. Omer can operate on her
 * w/o consequences
 * @author מרים
 *
 */
public interface GirlfriendIF {
	public void doSomethingForMe();
	public void doSomethingElseForMe();
	public String getName();
}
