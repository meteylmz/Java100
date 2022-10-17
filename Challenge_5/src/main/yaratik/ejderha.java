package main.yaratik;

public class ejderha extends yaratik{
	
	private int ucmaHizi = 100;
	
	public ejderha(String yaratikAdi, int nadirlik, int guc) {
		super.setNadirlik(nadirlik);
		super.setGuc(guc);
		super.setYaratikAdi(yaratikAdi);
	}
	
	public void saldir() {
		System.out.println("Ejderha alev püskürtüyor!");
	}
	
	public void hareket() {
		System.out.println("Ejderha " + ucmaHizi + " uçma hızı ile uçuyor.");
	}
}
