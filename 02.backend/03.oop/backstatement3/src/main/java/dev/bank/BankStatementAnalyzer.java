package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;
import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzer {
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";
	
	//입출금 내역 분석 수행 출력 메서드
 	public void analyze(String fileName, BankStatementPaser parser) throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		final List<String> lines = Files.readAllLines(path);
		
		List<BankTransaction> bankTransactions =  parser.parseLinesFrom(lines);
		
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

		collectSummery(processor);
 	}
 	
 	//입출금 내역 분석 결과 출력 메서드
	private static void collectSummery(BankStatementProcessor bankStatementProcessor) {
		
		System.out.println("총 사용 금액은"+bankStatementProcessor.calculateTotalAmount() +"입니다.");
		
		System.out.println("2월의 입출금 내역은"+bankStatementProcessor.calculateListMonth(Month.FEBRUARY)+"입니다.");
		
		System.out.println("Salary(급여) 카테고리의 총 입출금 내역은" +bankStatementProcessor.calculateTotalForCategory("Salary")+"입니다.");
		//대소문자, 특성 사례 구분 -> case sensitive
	}



}