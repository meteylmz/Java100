package Member;

public class basicMember {
	
	private String hesapAdi;
	private String sifre;
	private int grafikSayisi = 1;
	
	public void tekrarOynat() {
		System.out.println("Günlük çubuklar tekrar oynatılacak.");
	}
	
	public void sembolKıyaslama() {
		System.out.println("Sembol kıyaslama yapılabilir.");
	}
	
	public int getGrafikSayisi() {
		return grafikSayisi;
	}

	protected void setGrafikSayisi(int grafikSayisi) {
		this.grafikSayisi = grafikSayisi;
	}
	
	public String getHesapAdi() {
		return hesapAdi;
	}
	
	public void setHesapAdi(String hesapAdi) {
		this.hesapAdi = hesapAdi;
	}
	
	public String getSifre() {
		return sifre;
	}
	
	public void setSifre(String sifre) {
		this.sifre = sifre;
	}
	
}
