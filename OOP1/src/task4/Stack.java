package task4;

public interface Stack {
	public void push(Object element);
	
	//return element and delete it
	public Object pop();
	
	//return element and do not delete it
	public Object getElement();
	
	public int size();
	
	public boolean isEmpty();
	
	public void clean();
	
	public void printElements(Object stack);
}
