package main.yaratik;

public class yaratik implements yaratikFonksiyon{
	
	private String yaratikAdi;
	private int nadirlik;
	private int guc;
	
	@Override
	public void saldir() {
		System.out.println("Saldırı yapılıyor");
	}
	
	@Override
	public int yaratikUret(yaratik yaratik1, yaratik yaratik2) {
		int yeniNadirlik = (yaratik1.getNadirlik() + yaratik2.getNadirlik()) / 2;
		return yeniNadirlik;
	}
	
	@Override
	public yaratik savas(yaratik yaratik1, yaratik yaratik2) {
		if(yaratik1.getGuc() < yaratik2.getGuc()) 
			return yaratik2;
		else
			return yaratik1;
	}
	
	@Override
	public void hareket() {
		System.out.println("Yaratik hareket ediyor.");
	}
	
	public int getNadirlik() {
		return nadirlik;
	}
	
	public void setNadirlik(int nadirlik) {
		this.nadirlik = nadirlik;
	}
	
	public int getGuc() {
		return guc;
	}
	
	public void setGuc(int guc) {
		this.guc = guc;
	}
	
	public String getYaratikAdi() {
		return yaratikAdi;
	}
	
	public void setYaratikAdi(String yaratikAdi) {
		this.yaratikAdi = yaratikAdi;
	}
	
}
