package Day10;

import java.net.MulticastSocket;
// day10_2 
public class Television implements RemoteControl, Searchable {
		//클래스명     implements     인터페이스 명
				// 구현하다
	//이것만 적으면 구현하라고 빨간줄 뜸....
	//인터페이스는 클래스 하나를 위해 사용x
	
	//ctrl space = a라거 뜨는게 추상
	
	
	private int volume;
	
	@Override
	public void trunOn() {
		System.out.println("TV를 켭니다.");
	}
	
	@Override
	public void trunOff() {
		System.out.println("TV를 끕니다.");
	}
	
	@Override
	public void setVolume(int Volume) {
		//만약에 볼륨이 최대 소음보다 커지면
		if(volume > RemoteControl.MAX_VOLUE) {
			//소음에 10을 대입(그 이상으로 올라가지 못하게)
			this.volume = RemoteControl.MAX_VOLUE;
		} else if (volume < RemoteControl.MIN_VOLUE) {
			//리모콘 최소소음보다 작으면 0으로 대입(제한)
			this.volume = RemoteControl.MIN_VOLUE;
		} else {
			this.volume = volume;
		}
		System.out.println("현재 tv 볼륨 : " + this.volume);
	
	}@Override
	public void search(String url) {
		System.out.println( url +"을 검색합니다. ");
	}
	
	@Override // 디폴트 메소드도 재정의 가능 
	public void setMute(boolean mute) {
		RemoteControl.super.setMute(mute);
	}
		
	

}
