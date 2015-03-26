package behavioral.state;

/**
 * This is the book's implementation of State pattern. I don't like it very much b/c
 * there can only be one user of this state. On one hand all substates are static, but
 * then this class cannot be an inner class of Context, which is what you'd want it to be
 * since only Context can use it. Also, you need to make context a singleton.
 * The transition from one state to another is "random" depending on which is the
 * current state and some UI condition.
 * @author oshatil
 *
 */
public class AbstractState {
	// events
    public static final int EVENT_X  = 1;
    public static final int EVENT_Y  = 2;
    public static final int EVENT_Z   = 3;
    // states 
    // This is ugly! because you can only instantiate an inner class off of an
    // existing instance of the encapsulating class, we have to create a dummy
    // instance of AbstractState and then use it to create all the different states
    private static AbstractState abstractState = new AbstractState(null);
    
    private Context context;
    
    /**
     * Make sure that no instances of AbstractState can exist
     *
     */
    private AbstractState(Context context)
    {
    	this.context = context;
    }
    /**
     * Initialize the state machine and return its initial state.
     * @param dslSender
     * @return
     */
    public static AbstractState start(Context context){
    	StateOne stateOne = abstractState.new StateOne(context);
    	stateOne.enter();
    	return stateOne;
    }

    public AbstractState processEvent(int event) {
        // This non-overridden method should never be called.
    	System.out.print("xxxxxxxxx");
        throw new IllegalAccessError();
    }

    class StateOne extends AbstractState {
    	StateOne(Context ctx)
    	{
    		super(ctx);
    	}
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public AbstractState processEvent(int event) {
              switch (event) {
              case EVENT_X:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateTwo stateTwo = abstractState.new StateTwo(this.getContext());
                	  stateTwo.enter();
                	  return stateTwo;
                  }
                  else {
                  	  StateThree stateThree = abstractState.new StateThree(this.getContext());
                	  stateThree.enter();
                	  return stateThree;
                  }
              case EVENT_Y:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateThree stateThree = abstractState.new StateThree(this.getContext());
                	  stateThree.enter();
                	  return stateThree;
                  }
                  else {
                  	  StateFour stateFour = abstractState.new StateFour(this.getContext());
                	  stateFour.enter();
                	  return stateFour;
                  }
              case EVENT_Z:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateFour stateFour = abstractState.new StateFour(this.getContext());
                	  stateFour.enter();
                	  return stateFour;
                  }
                  else {
                	  // no state change!
                	  return this;
                  }
                default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              }
        }

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
        	this.getContext().doWorkForStateOne();
        }
	}
	class StateTwo extends AbstractState {
    	StateTwo(Context ctx)
    	{
    		super(ctx);
    	}
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public AbstractState processEvent(int event) {
              switch (event) {
              case EVENT_X:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateFour stateFour = abstractState.new StateFour(this.getContext());
                	  stateFour.enter();
                	  return stateFour;
                  }
                  else {
                  	  StateOne stateOne = abstractState.new StateOne(this.getContext());
                	  stateOne.enter();
                	  return stateOne;
                  }
              case EVENT_Y:
                  if (this.getContext().checkCondition() == 0) {
                	  // no state change!
                	  return this;
                  }
                  else {
                  	  StateThree stateThree = abstractState.new StateThree(this.getContext());
                	  stateThree.enter();
                	  return stateThree;
                  }
              case EVENT_Z:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateThree stateThree = abstractState.new StateThree(this.getContext());
                	  stateThree.enter();
                	  return stateThree;
                  }
                  else {
                  	  StateFour stateFour = abstractState.new StateFour(this.getContext());
                	  stateFour.enter();
                	  return stateFour;
                  }
              default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              }
        }

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
        	this.getContext().doWorkForStateTwo();
        }
	}
	class StateThree extends AbstractState {
    	StateThree(Context ctx)
    	{
    		super(ctx);
    	}
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public AbstractState processEvent(int event) {
              switch (event) {
              case EVENT_X:
                  if (this.getContext().checkCondition() == 0) {
                	  // no state change!
                	  return this;
                  }
                  else {
                  	  StateFour stateFour = abstractState.new StateFour(this.getContext());
                	  stateFour.enter();
                	  return stateFour;
                  }
              case EVENT_Y:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateFour stateFour = abstractState.new StateFour(this.getContext());
                	  stateFour.enter();
                	  return stateFour;
                  }
                  else {
                  	  StateOne stateOne = abstractState.new StateOne(this.getContext());
                	  stateOne.enter();
                	  return stateOne;
                  }
              case EVENT_Z:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateTwo stateTwo = abstractState.new StateTwo(this.getContext());
                	  stateTwo.enter();
                	  return stateTwo;
                  }
                  else {
                	  return this;
                  }
              default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              }
        }

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
        	this.getContext().doWorkForStateThree();
        }
	}
	class StateFour extends AbstractState {
    	StateFour(Context ctx)
    	{
    		super(ctx);
    	}
        /**
         * Respond to a given event.
         * @param event An event code.
         * @return the next state.
         * @exception IllegalArgumentException if event is an unexpected value.
         */
        public AbstractState processEvent(int event) {
              switch (event) {
              case EVENT_X:
                  if (this.getContext().checkCondition() == 0) {
                	  // no state change!
                	  return this;
                  }
                  else {
                  	  StateOne stateOne = abstractState.new StateOne(this.getContext());
                	  stateOne.enter();
                	  return stateOne;
                  }
              case EVENT_Y:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateThree stateThree = abstractState.new StateThree(this.getContext());
                	  stateThree.enter();
                	  return stateThree;
                  }
                  else {
                	  return this;
                  }
              case EVENT_Z:
                  if (this.getContext().checkCondition() == 0) {
                  	  StateTwo stateTwo = abstractState.new StateTwo(this.getContext());
                	  stateTwo.enter();
                	  return stateTwo;
                  }
                  else {
                  	  StateThree stateThree = abstractState.new StateThree(this.getContext());
                	  stateThree.enter();
                	  return stateThree;
                  }
              default:
                    String msg = "unexpected event "+event;
                    throw new IllegalArgumentException(msg);
              }
        }

        /**
         * This method is called when this object is becomes the current state.
         */
        protected void enter() {
        	this.getContext().doWorkForStateFour();
        }
	}
	public Context getContext() {
		return context;
	}
}
