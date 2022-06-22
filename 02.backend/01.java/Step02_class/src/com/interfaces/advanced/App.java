package com.interfaces.advanced;

public class App {

	public static void main(String[] args) {
		// 음악을 재생해야되기 떄문에 , Audio 인스턴스 lpRecode  생성
		Audio lpRecode = new Audio();
		
//		Joy 앨범 구매
		Joy joyAlbum = new Joy();
		
		Park parkAlbum = new Park();
		
//		lpRecode가 musicPlay(재생할 앨범)를 호출하면 넣은 앨범의 음악이 재생됨.
		lpRecode.musicPlay(joyAlbum);
		System.out.println("다른 음악 재생");
		lpRecode.musicPlay(parkAlbum);
	}

}
