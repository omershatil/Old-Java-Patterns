package concurrency.asynchprocessing;

public class Client {
	private String name;
	public Client(String name) {
		this.name = name;
	}
	public void doIt() {
		boolean done = false;
		Server server = new Server();
		Future future = new Future();
		System.out.println(this.name + " asking server to do something for it and return result");
		server.doSomethingForMe(future);
		while (done == false) {
			System.out.println("server is not done. " + this.name + 
					" is doing something else in the mean time...");
			done = future.checkDone();
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ie) {
				
			}
			System.out.println(this.name + " checking if server is done...");
			done = future.checkDone();
		}
		System.out.println(this.name + " got result!!! Doing something with it...");
	}
}
