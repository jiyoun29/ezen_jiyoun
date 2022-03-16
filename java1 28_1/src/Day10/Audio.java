package Day10;
//day10_2
public class Audio implements RemoteControl, Searchable {
	
	//구현은 A로 뜬다.

	private int Volume;
	
	@Override
	public void trunOn() {
		System.out.println("오디오를 켭니다.");
	}
	
	@Override
	public void trunOff() {
		System.out.println("오디오를 끕니다.");
	}
	
	@Override
	public void setVolume(int Volume) {
		if(Volume > RemoteControl.MAX_VOLUE) {
			this.Volume = RemoteControl.MAX_VOLUE;
			//최대 10이 올라가지 않게 막음
		} else if (Volume < RemoteControl.MIN_VOLUE) {
			this.Volume = RemoteControl.MIN_VOLUE;
		} else { this.Volume = Volume; }
		System.out.println("현재 오디오 볼륨 : "+ this.Volume);
	}

}
