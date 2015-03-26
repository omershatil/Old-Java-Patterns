package behavioral.command;

import java.util.*;

public abstract class AbstractCommand {
	// CommandManager is a Singleton
	private static CommandManager manager = null;
	
	public AbstractCommand()
	{
		if (manager == null) {
			manager = new CommandManager();
		}
		manager.executeCommand(this);
	}
	abstract protected boolean doIt();
	abstract protected boolean undoIt();
	public class CommandManager {
		private LinkedList <AbstractCommand>history = new LinkedList<AbstractCommand>();
		private LinkedList <AbstractCommand>redoList = new LinkedList<AbstractCommand>();
		private int cmdListSize = 200;
		
		public void executeCommand(AbstractCommand cmd) {
			if (cmd instanceof UndoCommandIF) {
				if (this.history.size() > 0) {
					AbstractCommand undoCmd = this.history.removeFirst();
					undoCmd.undoIt();
					this.redoList.addFirst(undoCmd);
				}
				else {
					System.out.print("Nothing to undo!!!\n");
				}
				return;
			}
			if (cmd instanceof RedoCommandIF) {
				if (this.redoList.size() > 0) {
					AbstractCommand redoCmd = this.redoList.removeFirst();
					redoCmd.doIt();
					this.history.addFirst(redoCmd);
				}
				else {
					System.out.print("Nothing to redo!!!\n");
				}
				return;
			}
			if (cmd.doIt() == true){
				addToHistory(cmd);
			}
			else {
				// it's an undoable command. clear history
				this.history.clear();
			}
			// clear redo command whenever we "do it"
			if (this.redoList.size() > 0) {
				this.redoList.clear();
			}
		}
		private void addToHistory(AbstractCommand cmd)
		{
			this.history.addFirst(cmd);
			if (this.history.size() > this.cmdListSize) {
				this.history.removeLast();
			}
		}
	}
}
