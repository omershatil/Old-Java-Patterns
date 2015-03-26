import fundemental.delegation.*;
import fundemental.markerinterface.*;
import fundemental.proxy.*;

import behavioral.command.*;
import behavioral.chainofresponsibility.Greenhouse;
import behavioral.chainofresponsibility.SubSection;
import behavioral.mediator.*;
import behavioral.snapshot.*;
import behavioral.state.*;
import behavioral.nullobject.*;
import behavioral.strategy.*;
import behavioral.templatemethod.ClientHouseBuilder;
import behavioral.visitor.ideal.Character;
import behavioral.visitor.ideal.ConcreteVisitor1;
import behavioral.visitor.ideal.ConcreteVisitor2;
import behavioral.visitor.ideal.ObjectStructureIdeal;
import behavioral.visitor.ideal.VisitorIF;

import creational.factorymethod.*;
import creational.abstractfactory.*;
import creational.builder.*;
import creational.objectpool.soft.*;
import creational.objectpool.hard.*;

import partitioning.filter.push.*;
import partitioning.filter.pull.*;
import partitioning.composite.*;
import partitioning.readonlyinterface.*;

import structural.adapter.*;
import structural.iterator.*;
import structural.decorator.*;
import structural.bridge.*;
import structural.dynamiclinkage.*;
import structural.virtualproxy.*;
import structural.cachemanagement.*;
import structural.facade.*;

import java.util.*;
import java.lang.reflect.*;

import concurrency.balking.Focet;
import concurrency.lockobject.differentclasses.NodeType1;
import concurrency.lockobject.differentclasses.NodeType2;
import concurrency.readwritelock.TestJumpersHuntersCourse;
import concurrency.scheduler.Processor;
import concurrency.threadlocal.Transaction;

public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// concurrency
		testThreadLocal();
		testDoubleBuffering();
		testReadWriteLock();
		testScheduler();
		testBalking();
		testLockObject();
		// behavioral
		testVisitor();
		testTemplateMethod();
		testStrategy();
		testNullObject();
		testState();
		testObserver();
		testSnapshot();
		testMediator();
		testChainOfResponsibility();
		testCommand();
		// structural
		testCacheManagement();
		testDecorator();
		testVirtualProxy();
		testDynamicLinkage();
		testBridge();
		testFacade();
		testAdapter();
		testIterator();
		// fundemental
		testDelegator();
		testMarkerInterface();
		testProxy();
		// creational
		testFactoryMethod();
		testAbstractFactory();
		testBuilder();
		testPrototype();
		testObjectPool();
		// partitioning
		testFilter();
		testComposite();
		testReadOnly();
	}
	// concurrency patterns
	private static void testThreadLocal()
	{
		List<Thread> threads = new ArrayList<Thread>();
		Thread t = new Thread(new concurrency.threadlocal.Transaction());
		threads.add(t);
		t.start();
		t = new Thread(new concurrency.threadlocal.Transaction());
		threads.add(t);
		t.start();
		t = new Thread(new concurrency.threadlocal.Transaction());
		threads.add(t);
		t.start();
		for (int i = 0; i < threads.size(); i++) {
			try {
				threads.get(i).join();
			}
			catch (InterruptedException ie) {
				
			}
		}
	}
	private static void testDoubleBuffering()
	{
	}
	private static void testReadWriteLock()
	{
		TestJumpersHuntersCourse test = new TestJumpersHuntersCourse();
		test.doIt();	
	}
	private static void testScheduler()
	{
		Processor p = new Processor();
		List<Thread> threads = new ArrayList<Thread>();
		Thread t = new Thread(new concurrency.scheduler.SomeThread(p));
		threads.add(t);
		t.start();
		t = new Thread(new concurrency.scheduler.SomeThread(p));
		threads.add(t);
		t.start();
		t = new Thread(new concurrency.scheduler.SomeThread(p));
		threads.add(t);
		t.start();
		for (int i = 0; i < threads.size(); i++) {
			try {
				threads.get(i).join();
			}
			catch (InterruptedException ie) {
				
			}
		}
	}
	private static void testBalking()
	{
		concurrency.balking.Focet focet = new Focet(); 
		List<Thread> threads = new ArrayList<Thread>();
		Thread t = new Thread(new concurrency.balking.SomeThread(focet));
		threads.add(t);
		t.start();
		t = new Thread(new concurrency.balking.SomeThread(focet));
		threads.add(t);
		t.start();
		// this method should block till both threads are done (assuming you put break
		// points and that it is called after both threads have called runWater()
		// after threads have called
		focet.sprayChemicals();
		for (int i = 0; i < threads.size(); i++) {
			try {
				threads.get(i).join();
			}
			catch (InterruptedException ie) {
				
			}
		}
	}
	private static void testLockObject()
	{
		// a tree of objects of different classes
		concurrency.lockobject.differentclasses.NodeType1 root = new NodeType1("Root"); 
		concurrency.lockobject.differentclasses.NodeType2 childOfRoot = new NodeType2("Child of Root"); 
		concurrency.lockobject.differentclasses.NodeType1 grandchildOfRoot = new NodeType1("Grandchild of Root");
		grandchildOfRoot.setParent(childOfRoot);
		childOfRoot.setParent(root);
		List<Thread> threads = new ArrayList<Thread>();
		Thread t = new Thread(new concurrency.lockobject.differentclasses.SomeThread(root));
		threads.add(t);
		t.start();
		t = new Thread(new concurrency.lockobject.differentclasses.SomeThread(childOfRoot));
		threads.add(t);
		t.start();
		t = new Thread(new concurrency.lockobject.differentclasses.SomeThread(grandchildOfRoot));
		threads.add(t);
		t.start();
		for (int i = 0; i < threads.size(); i++) {
			try {
				threads.get(i).join();
			}
			catch (InterruptedException ie) {
				
			}
		}
		// a list of objects of the same class
		List<concurrency.lockobject.sameclass.SomeClass> scList = new ArrayList<concurrency.lockobject.sameclass.SomeClass>();
		scList.add(new concurrency.lockobject.sameclass.SomeClass("Class 1"));
		scList.add(new concurrency.lockobject.sameclass.SomeClass("Class 2"));
		scList.add(new concurrency.lockobject.sameclass.SomeClass("Class 3"));
		threads = new ArrayList<Thread>();
		for (int i = 0; i < scList.size(); i++) {
			t = new Thread(new concurrency.lockobject.sameclass.SomeThread(scList.get(i)));
			threads.add(t);
			t.start();
		}
		for (int i = 0; i < scList.size(); i++) {
			try {
				threads.get(i).join();
			}
			catch (InterruptedException ie) {
				
			}
		}
	}
	// behavioral patterns
	private static void testVisitor()
	{
		// non-ideal visitor
		Document doc = new Document();
		partitioning.composite.Character char1 = partitioning.composite.Character.getCharacter(1, 'a');
		doc.addComponent(char1);
		doc.addComponent(partitioning.composite.Character.getCharacter(2, 'b'));
		doc.addComponent(partitioning.composite.Character.getCharacter(2, 'b'));
		doc.addComponent(partitioning.composite.Character.getCharacter(3, 'b'));
		doc.addComponent(partitioning.composite.Character.getCharacter(3, 'c'));
		LineOfText line1 = new LineOfText();
		doc.addComposite(line1);
		LineOfText line2 = new LineOfText();
		line1.addChild(char1);
		line1.addChild(partitioning.composite.Character.getCharacter(4, 'd'));
		line1.addChild(partitioning.composite.Character.getCharacter(4, 'e'));
		line1.addChild(line2);
		line2.addChild(partitioning.composite.Character.getCharacter(4, 'f'));
		Image image1 = new Image(3, CompositeConstants.ImageType.jpeg);
		line2.addChild(image1);
		behavioral.visitor.nonideal.ConcreteVisitor1 vis1 = new behavioral.visitor.nonideal.ConcreteVisitor1(doc);
		vis1.listFonts();
		behavioral.visitor.nonideal.ConcreteVisitor2 vis2 = new behavioral.visitor.nonideal.ConcreteVisitor2(doc);
		LineOfText lot = vis2.getALine();
		System.out.println("got next line of font: " + lot.getFont());
		// ideal visitor
		ObjectStructureIdeal doc2 = new ObjectStructureIdeal();
		Character char2 = Character.getCharacter(1, 'a');
		doc2.addComponent(char2);
		doc2.addComponent(Character.getCharacter(2, 'b'));
		doc2.addComponent(Character.getCharacter(2, 'b'));
		doc2.addComponent(Character.getCharacter(3, 'b'));
		doc2.addComponent(Character.getCharacter(3, 'c'));
		behavioral.visitor.ideal.LineOfText line3 = new behavioral.visitor.ideal.LineOfText();
		doc2.addComposite(line3);
		behavioral.visitor.ideal.LineOfText line4 = new behavioral.visitor.ideal.LineOfText();
		line3.addChild(char2);
		line3.addChild(Character.getCharacter(4, 'd'));
		line3.addChild(Character.getCharacter(4, 'e'));
		line3.addChild(line4);
		line4.addChild(Character.getCharacter(4, 'f'));
		VisitorIF visitor1 = new ConcreteVisitor1();
		doc2.accept(visitor1);
		VisitorIF visitor2 = new ConcreteVisitor2();
		doc2.accept(visitor2);
	}
	private static void testTemplateMethod()
	{
		// use a client with one template method.
		ClientHouseBuilder client = new ClientHouseBuilder();
		client.doIt();
	}
	private static void testStrategy()
	{
		// use a client with one strategy. Then, change its strategy and execute 
		// the same operation on it
		behavioral.strategy.Client client = new behavioral.strategy.Client(new ConcreteStrategy1());
		client.doOperation();
		client.setStrategy(new ConcreteStrategy2());
		client.doOperation();
	}
	private static void testNullObject()
	{
		RealOperation op1 = new RealOperation();
		NullOperation op2 = new NullOperation();
		Delegator delegator = new Delegator();
		delegator.routeMessage(op1);
		delegator.routeMessage(op2);
	}
	private static void testState()
	{
		Context ctx = Context.getContext();
		ctx.start();
	}
	private static void testObserver()
	{
		// create an Observable and 3 observers
		behavioral.observer.Observable observable = new behavioral.observer.Observable();
		behavioral.observer.Observer observer1 = new behavioral.observer.Observer("Observer 1", observable);
		behavioral.observer.Observer observer2 = new behavioral.observer.Observer("Observer 2", observable);
		behavioral.observer.Observer observer3 = new behavioral.observer.Observer("Observer 3", observable);
		// start the observer and watch the action
		observable.start();
	}
	private static void testSnapshot()
	{
		GameModel gameModel = GameModel.getGameModel();
		MilestoneMementoManager mementoManager = gameModel.getMilestoneMementoManager();
		// save a memento
		mementoManager.snapshotMilestone("1st snapshot");
		// play the game a little. Kill some aliens (three)
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		System.out.print("Number aliens killed (should be 3): " + gameModel.getNumKilledAliens() + "\n");
		// save a memento
		mementoManager.snapshotMilestone("2nd snapshot");
		// kill some more aliens
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		System.out.print("Number aliens killed (should be 6): " + gameModel.getNumKilledAliens() + "\n");
		// restore memento and verify that number of aliens killed was as when initially saved
		// that memento
		MilestoneMementoIF memento = null;
		MilestoneMementoIF []mementos = mementoManager.getMilestoneMementos();
		for (int i = 0; i < mementos.length; i++) {
			if (mementos[i].getDescription().equalsIgnoreCase("2nd snapshot") == true) {
				memento = mementos[i];
				break;
			}
		}
		if (memento == null) {
			System.out.print("ERROR - Couldn't find memento\n");
			return;
		}
		mementoManager.restoreFromMemento(memento);
		System.out.print("Number aliens killed (should be 3): " + gameModel.getNumKilledAliens() + "\n");
		// kill some more aliens
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		System.out.print("Number aliens killed (should be 6): " + gameModel.getNumKilledAliens() + "\n");
		// serialize the game to file
		Serializer ser = new Serializer(gameModel, "Snapshot.ser");
		ser.saveGame();
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		gameModel.killedAnAlien();
		System.out.print("Number aliens killed (should be 9): " + gameModel.getNumKilledAliens() + "\n");
		// restore from file and verify number of killed aliens
		Deserializer deser = new Deserializer("Snapshot.ser");
		deser.restoreGame();
		System.out.print("Number aliens killed (should be 6): " + gameModel.getNumKilledAliens() + "\n");
	}
	private static void testMediator()
	{
		DialogBox dlg = new DialogBox();
		
		// to simulate user actions we get the dialog's widgets and call methods on them.
		// First, enter text into text box 1. Should see the push buttons enabled
		dlg.getTextBox1().enterText("Text in text box 1");
		// Second, click one of the push buttons. that should enable text box 2
		dlg.getPushButton1().click();
		// Last, click the other push buttons. that should also enable text box 2
		dlg.getPushButton2().click();
	}
	private static void testCommand()
	{
		CommandFactory factory = CommandFactory.getInstance();
		factory.createCommand("dothis");
		factory.createCommand("dothis");
		factory.createCommand("dothat");
		factory.createCommand("dothat");
		factory.createCommand("undo");
		factory.createCommand("redo");
		factory.createCommand("undo");
		factory.createCommand("undo");
		factory.createCommand("undo");
		factory.createCommand("undo");
		// should fail to undo
		factory.createCommand("undo");
		factory.createCommand("redo");
		factory.createCommand("redo");
		factory.createCommand("redo");
		factory.createCommand("redo");
		// should fail to redo
		factory.createCommand("redo");
		// undo once so that there is something in the redo list, so it can be reset by
		// the undoable command
		factory.createCommand("undo");
		factory.createCommand("undoable");
		// should fail b/c previous command was undoable
		factory.createCommand("undo");
	}
	private static void testChainOfResponsibility()
	{
		 // in "real life", the composite will be built top-down while sensors
		 // send their messages bottom-up. I have to cheat here and get at the bottom
		 // of the tree in order to send sensor info
		SubSection sec1 = new SubSection("Section 1", 10);
		SubSection sec2 = new SubSection("Section 2", 11);
		Greenhouse ghouse1 = new Greenhouse("Greenhouse 1", 100);
		Greenhouse ghouse2 = new Greenhouse("Greenhouse 2", 101);
		ghouse1.addChild(sec1);
		ghouse2.addChild(sec2);
		// pass a temparture value to sec1. Value is not extreme, so nothing should happen
		sec1.notifyTemp(70);
		// pass a temparture value to sec1. Value > 100 so heater should be turned off
		// in that section. event should not propagate
		sec1.notifyTemp(110);
		// pass a humidity value to sec1. Value is not extreme, so nothing should happen
		sec2.notifyHumidity(70);
		// pass a humidity value to sec1. Value < 60 so irrigation should be turned on
		// in that section. event should not propagate
		sec2.notifyHumidity(50);
	}
	// structural patterns
	private static void testCacheManagement()
	{
		CacheClient client = new CacheClient();
		client.useCache();
	}
	private static void testDecorator()
	{
		ClientOfDecorator client = new ClientOfDecorator();
		client.useWrapperAServiceA();
		client.useWrapperBServiceB();
		client.useWrapperAServiceB();
		client.useWrapperBServiceA();
	}
	private static void testVirtualProxy()
	{
		Omer2 omer2 = new Omer2();
		omer2.run();
	}
	private static void testDynamicLinkage()
	{
		Omer omer = new Omer();
		omer.run();
	}
	private static void testBridge()
	{
		Driver driver = new Driver();
		driver.startDriving();
	}
	private static void testIterator()
	{
		MyCollection coll = new MyCollection();
		coll.add("String 1");
		coll.add("String 2");
		coll.add("String 3");
		IteratorIF iter = coll.Iterator();
		System.out.print("Printing the collection using the Iterator pattern\n");
		while (iter.hasNext()) {
			System.out.print(iter.next() + "\n");
		}
	}
	private static void testAdapter()
	{
		// adaptee is passed as a parameter to the Adapter
		structural.adapter.Client client = 
			new structural.adapter.Client(new Adapter(new structural.adapter.Customer()));
		client.doYourThing();
		// use inner class
		structural.adapter.Client innerClient = 
			new structural.adapter.Client(new CustomerInfoIF() {
				structural.adapter.Customer customer = new structural.adapter.Customer();
				public void setCustomerName(String name) {
					customer.setName(name);
				}
				public String getCustomerName() {
					return customer.getName();
				}
			});
		innerClient.doYourThing();
	}
	private static void testFacade()
	{
		SatelliteFileSenderFacade satFacade = new SatelliteFileSenderFacade();
		try {
			satFacade.start();
		}
		catch (Exception e) {
			System.out.print("testFacade Failed");
		}
		DslFileSenderFacade dslFacade = new DslFileSenderFacade();
		try {
			dslFacade.start();
		}
		catch (Exception e) {
			System.out.print("testFacade Failed");
		}
	}
	// partitioning patterns
	private static void testReadOnly()
	{
		// read only client can only read
		ReadOnlyClient readOnlyClient = new ReadOnlyClient();
		readOnlyClient.readString();
		// read/write client can modify object
		ReadWriteClient readWriteClient = new ReadWriteClient();
		readWriteClient.writeString("Writing some string using read/write client\n");
	}
	private static void testComposite()
	{
		Document doc = new Document();
		partitioning.composite.Character a = partitioning.composite.Character.getCharacter(1, 'a');
		doc.addComponent(a);
		doc.addComponent(partitioning.composite.Character.getCharacter(2, 'b'));
		doc.addComponent(partitioning.composite.Character.getCharacter(2, 'b'));
		doc.addComponent(partitioning.composite.Character.getCharacter(3, 'b'));
		doc.addComponent(partitioning.composite.Character.getCharacter(3, 'c'));
		LineOfText line1 = new LineOfText();
		doc.addComposite(line1);
		LineOfText line2 = new LineOfText();
		line1.addChild(a);
		line1.addChild(partitioning.composite.Character.getCharacter(4, 'd'));
		line1.addChild(partitioning.composite.Character.getCharacter(4, 'e'));
		line1.addChild(line2);
		line2.addChild(partitioning.composite.Character.getCharacter(4, 'f'));
		Image image1 = new Image(3, CompositeConstants.ImageType.jpeg);
		line2.addChild(image1);
		doc.print();
	}
	private static void testFilter()
	{
		ContentAcquisitionManager cam = new ContentAcquisitionManager();
		cam.pushContent();
		PackagingServiceSink packagingServiceSink = new PackagingServiceSink();
		packagingServiceSink.pullContent();
	}
	// creational patterns
	private static void testObjectPool()
	{
		SoftPoolClient softClient = new SoftPoolClient();
		softClient.createSomeObjects();
		HardPoolClient hardClient = new HardPoolClient();
		hardClient.createSomeObjects();
	}
	private static void testPrototype()
	{
		creational.prototype.Customer customer = new creational.prototype.Customer();
		customer.buyAnimals();
		customer.outputAnimalsYouOwn();
	}
	private static void testFactoryMethod()
	{
		AnimalFarm animalFarm = new AnimalFarm();
		try {
			creational.factorymethod.Animal cat = animalFarm.createAnimal(FactoryMethodsConstants.ANIMAL_TYPE.CAT.toString(), "Johnny");
			creational.factorymethod.Animal fish = animalFarm.createAnimal(FactoryMethodsConstants.ANIMAL_TYPE.FISH.toString(), "Fishy");
			creational.factorymethod.Animal dog = animalFarm.createAnimal(FactoryMethodsConstants.ANIMAL_TYPE.DOG.toString(), "Bob");
			System.out.print("Here are my animals: \n");
			System.out.print("Name: " + fish.getName() + ". Sound: " + fish.getSound() + "\n");
			System.out.print("Name: " + dog.getName() + ". Sound: " + dog.getSound() + "\n");
			System.out.print("Name: " + cat.getName() + ". Sound: " + cat.getSound() + "\n");
		}
		catch (Exception e) {
			System.out.print("testFactoryMethod Failed");
		}
	}
	private static void testAbstractFactory()
	{
		ToolKitFactory toolKitFactory = ToolKitFactory.getInstance();
		try {
			FactoryIF windowsFactory = toolKitFactory.getFactory(AbstractFactoryConstants.ToolkitType.WINDOWS.toString());
			ButtonIF winButton = windowsFactory.createButton();
			CheckBoxIF winCheckBox = windowsFactory.createCheckBox();
			FactoryIF linuxFactory = toolKitFactory.getFactory(AbstractFactoryConstants.ToolkitType.LINUX.toString());
			ButtonIF linuxButton = linuxFactory.createButton();
			CheckBoxIF linuxCheckBox = linuxFactory.createCheckBox();	
			
			winButton.Click();
			winCheckBox.Check();
			linuxButton.Click();
			linuxCheckBox.Check();
		}
		catch (Exception e) {
			System.out.print("testAbstractFactory Failed");
		}
	}
	private static void testBuilder()
	{
		SleazyContractor contractor = new SleazyContractor();
		contractor.init();
	}
	// fundemental patterns
	private static void testDelegator()
	{
		// create 5 passengers, 2 crew members and collect the passengers' orders
		Person crewMember1 = new Person("Lisa", 1000);
		CrewMember cm = new CrewMember();
		crewMember1.setCrewMemberRole(cm);
		Person crewMember2 = new Person("James", 1001);
		cm = new CrewMember();
		crewMember2.setCrewMemberRole(cm);
		Person passenger1 = new Person("Painin Debut", 1002);
		Passenger p = new Passenger("I demand medium-rare Prime Rib with mashed potatos and chocolate moose for desert!");
		passenger1.setPassengerRole(p);
		Person passenger2 = new Person("Bigr Painin Debut", 1003);
		p = new Passenger("I beg for vegies");
		passenger2.setPassengerRole(p);
		Person passenger3 = new Person("Ann Noying", 1004);
		p = new Passenger("I want a burger. NOW!");
		passenger3.setPassengerRole(p);
		Person passenger4 = new Person("Ann Evn Moor Noying", 1005);
		p = new Passenger("Food, foooooood please");
		passenger4.setPassengerRole(p);
		Person passenger5 = new Person("Big Painin DaNeck", 1006);
		p = new Passenger("Water please");
		passenger5.setPassengerRole(p);
		List <Person>crewMembers = new ArrayList<Person>();
		crewMembers.add(crewMember1);
		crewMembers.add(crewMember2);
		List <Person>passengersGroup1 = new ArrayList<Person>();
		passengersGroup1.add(passenger1);
		passengersGroup1.add(passenger2);
		List <Person>passengersGroup2 = new ArrayList<Person>();
		passengersGroup2.add(passenger3);
		passengersGroup2.add(passenger4);
		passengersGroup2.add(passenger5);
		// assign passengers to crew members and have crew members get passengers orders
		String orders = "";
		orders = orders + crewMember1.takeFoodOrders(passengersGroup1);
		orders = orders + crewMember2.takeFoodOrders(passengersGroup2);
		System.out.print(orders + "\n");
	}
	private static void testMarkerInterface()
	{
		MyUtilityClass util = new MyUtilityClass();
		util.doSomething(new MarkedClass());
		util.doSomething(new UnmarkedClass());
	}
	private static void testProxy()
	{
		try {
			Map<String, String> myHashMap = new HashMap<String, String>();
			myHashMap.put("item1", "item1");
			LazyCloneMap myLazyCloneMap = new LazyCloneMap(myHashMap);
			myLazyCloneMap.put("item2", "item2");
			LazyCloneMap myLazyCloneMap2 = myLazyCloneMap.clone();
			myLazyCloneMap2.put("item3", "item3");
			myLazyCloneMap.remove("item1");
			myHashMap.put("item1", "item1 was changed");
			System.out.print(myHashMap.toString() + "\n");
			System.out.print(myLazyCloneMap.toString() + "\n");
			System.out.print(myLazyCloneMap2.toString() + "\n");
		}
		catch (NoSuchMethodException nsme)
		{
			System.out.print("testProxy Failed");
		}
		catch (InvocationTargetException ite)
		{
			System.out.print("testProxy Failed");
		}
	}
}
