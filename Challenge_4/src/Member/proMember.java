package Member;

public class proMember extends basicMember{
	
	private int alarmSayisi = 1;
	
	@Override
	public void tekrarOynat() {
		System.out.println("Haftalık çubuklar oynatılıyor.");
	}
	
	public int getGrafikSayisi() {
		super.setGrafikSayisi(2);
		return super.getGrafikSayisi();
	}
	
	public int getAlarmSayisi() {
		return alarmSayisi;
	}

	protected void setAlarmSayisi(int alarmSayisi) {
		this.alarmSayisi = alarmSayisi;
	}
	
}
