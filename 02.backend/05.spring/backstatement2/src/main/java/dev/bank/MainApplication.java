package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

// 클라이언트가 보는 메인 화면
public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		
		//before spring
//		BankStatementFactory factory = new BankStatementFactory();
//		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		//after spring
		//spring IoC 컨테이너인 applicationContext 객체 생성,
		//Bean 구성 정보의 역할을 담당하고 있는 BankStatementFactory를 등록
		//여기서 new는 예외 spring 시작의 진입점 
		
		// IoC 컨테이너 구성
		final ApplicationContext applicationContext
		= new AnnotationConfigApplicationContext(BankStatementFactory.class); //아직 얻은 건 아님

		
		//IoC 컨터에너에서 Analyzer 인스턴스(Bean) 꺼내오기
		final BankStatementAnalyzer analyzer =applicationContext.getBean(BankStatementAnalyzer.class);
		BankStatementCSVParser bean = applicationContext.getBean(BankStatementCSVParser.class);
		
		// 분석 수행
		analyzer.analyze("bank-data-simple.csv");
		
	}
	

}