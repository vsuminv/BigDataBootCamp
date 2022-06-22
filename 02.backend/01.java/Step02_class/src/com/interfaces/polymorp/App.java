package com.interfaces.polymorp;

public class App {

	public static void main(String[] args) {
		Bitable shark = TeethShop.getTeeth("채식"); //클래스 이름으로 바로 접근하려면 TeethShop 클래스에서 static 키워드를 쓰면 됨
		shark.bite("토마토");
		
		shark = TeethShop.getTeeth("육식");
		shark.bite(" 안심스테이크 ");

	}

}
