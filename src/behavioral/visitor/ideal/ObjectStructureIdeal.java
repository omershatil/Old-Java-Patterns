package behavioral.visitor.ideal;

import java.util.ArrayList;
import java.util.List;

/** all comments relate to the Visitor. For Composite comments see the Composite pattern
 * 
 * @author oshatil
 *
 */
public class ObjectStructureIdeal {
	private List <AbstractCompositeIdeal>composites = new ArrayList<AbstractCompositeIdeal>();
	private List <ComponentIdealIF>components = new ArrayList<ComponentIdealIF>();
	public List<ComponentIdealIF> getComponents() {
		return components;
	}
	public void addComponent(ComponentIdealIF component) {
		this.components.add(component);
	}
	public void setComponents(List<ComponentIdealIF> components) {
		this.components = components;
	}
	public List<AbstractCompositeIdeal> getComposites() {
		return composites;
	}
	public void setComposites(List<AbstractCompositeIdeal> composites) {
		this.composites = composites;
	}
	public void addComposite(AbstractCompositeIdeal composite) {
		this.composites.add(composite);
	}
	public void accept(VisitorIF visitor) {
		for (AbstractCompositeIdeal compos : this.composites) {
			compos.accept(visitor);
		}
	}
}
