package partitioning.composite;

import java.util.*;

public class Document {
	private List <AbstractHtmlpageComposite>composites;
	private List <ComponentIF>components;
	
	public Document()
	{
		this.components = new ArrayList<ComponentIF>();
		this.composites = new ArrayList<AbstractHtmlpageComposite>();
	}
	public List<ComponentIF> getComponents() {
		return components;
	}
	public void addComponent(ComponentIF component) {
		this.components.add(component);
	}
	public void setComponents(List<ComponentIF> components) {
		this.components = components;
	}
	public List<AbstractHtmlpageComposite> getComposites() {
		return composites;
	}
	public void setComposites(List<AbstractHtmlpageComposite> composites) {
		this.composites = composites;
	}
	public void addComposite(AbstractHtmlpageComposite composite) {
		this.composites.add(composite);
	}
	public void print() {
		// go down the tree and ask each item to return a string
		String str = new String();
		str = str + "Components are:\n";
		Iterator <ComponentIF>componentIter = this.components.iterator();
		while (componentIter.hasNext()) {
			ComponentIF component = componentIter.next();
			component.print();
		}
		str = str + "Composites are:\n";
		Iterator <AbstractHtmlpageComposite>compositeIter = this.composites.iterator();
		while (compositeIter.hasNext()) {
			AbstractHtmlpageComposite composite = compositeIter.next();
			composite.print();
		}
	}
}
