package com.interfaces.advanced;

public class Audio {
	
////	Joy 앨범 실행
//	void musicPlay(Joy joyAlbum) {
//		joyAlbum.play();
//	}
//	
////	
//	void musicPlay(Park parkAlbum) {
//		parkAlbum.play();
//	}
	
	void musicPlay(Playable lp) {
//		매개변수에서의 다형성 + 인터페이스(Playable)와 다형성
		lp.play();
	}
	
}
