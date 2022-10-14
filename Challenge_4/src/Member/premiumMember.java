package Member;

public class premiumMember extends basicMember{
	
	private int indikatorSayisi = 5;
	
	public void tekrarOynat() {
		System.out.println("Aylık çubuklar oynatılıyor");
	}

	public int getIndikatorSayisi() {
		return indikatorSayisi;
	}

	public void setIndikatorSayisi(int indikatorSayisi) {
		this.indikatorSayisi = indikatorSayisi;
	}
	
}
