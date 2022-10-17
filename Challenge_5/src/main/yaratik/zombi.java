package main.yaratik;

public class zombi extends yaratik implements yaratikFonksiyon{
	
	private int yurumeHizi = 50;
	
	public zombi(String yaratikAdi, int nadirlik, int guc) {
		super.setNadirlik(nadirlik);
		super.setGuc(guc);
		super.setYaratikAdi(yaratikAdi);
	}
	
	public void saldir() {
		System.out.println("Zombi ısırıyor!");
	}
	
	public void hareket() {
		System.out.println("Zombi " + yurumeHizi + " yürüme hızı ile yürüyor.");
	}
}
