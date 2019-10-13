package domain;

public class Model {

	private String modelName;
	private String storageSize;
	private String color;
	
	public Model(String modelName,String storageSize,String color) {
		this.modelName = modelName;
		this.storageSize = storageSize;
		this.color = color;
	}
	
	public Model() {}
	
	public String getModelName() {
		
		return modelName;
	}
	
	public void setModelName(String modelName) {
		
		this.modelName = modelName;	
	}
	
	public String getStorageSize() {
		
		return storageSize;
	}
	
	public void setStorageSize(String storageSize) {
		
		this.storageSize = storageSize;
	}
	
	public String getColor() {
		
		return color;
	}
	
	public void setColor(String color) {
		
		this.color = color;
	}
}