package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dev.bank.data.BankStatementTSVParser;
import dev.bank.domain.BankTransaction;

public class BankStatementAnalyzer {
	
	// 입출금내역 파일인 back-data-simple.txt 파일의 경로 지정.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1번째 기능 요구사항, 모든 거래내역(BankStatement)의 합 계산하기 / Phase1
		
		// 1. 파일 경로 확인, 읽기
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		final List<String> lines = Files.readAllLines(path);
//		System.out.println(path);
//		System.out.println(lines);
		
		
		//2. 읽어들인 파일 파싱(parsing)
		final BankStatementTSVParser tsvParser = new BankStatementTSVParser();
		List<BankTransaction> bankTransactions =  tsvParser.parseLinesFromTSV(lines);
		
		//총 사용 금액 출력
	
		System.out.println("총 사용 금액은"+calculaterTotalAmount(bankTransactions)+"입니다.");
		
		System.out.println("2월의 입출금 내역은"+selectInMonth(bankTransactions, Month.FEBRUARY)+"입니다.");
		
		
		

	}
	//총 입출금 내역 확인, 메서드명을 통해 해당 메서드사 수행하는 일을 바로 이해할 수 있도록, 자체적인 문화를 제공하는 메서드명 작성
	public static double calculaterTotalAmount(List<BankTransaction> bankTransactions) {

		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		
		return total;
	}
	
	//특정 월에 대한 입츨금 내역 리스트 확인
	public static List<BankTransaction> selectInMonth(List<BankTransaction> bankTransactions, Month month){
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
		
		for (BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}
				
		}
		return bankTransactionsInMonth;
		
	}

		
	
	
	//특정 달에는 몇 건의 입출금 내역이 발생하였는지
	public static double findTransactionsInJanuary() throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		final List<String> lines = Files.readAllLines(path);
		double total = 0d;

		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
		for (String line : lines) {
			final String[] columns = line.split("\t");
			final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
			
			if (date.getMonth() == Month.JANUARY) {
				final double amount = Double.parseDouble(columns[1]);
				total += amount;
				
			}
		}
		return total;
		
	}
}