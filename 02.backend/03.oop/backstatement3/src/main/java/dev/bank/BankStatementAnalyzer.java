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
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";
	
	//����� ���� �м� ���� ��� �޼���
 	public void analyze(String fileName, BankStatementPaser parser) throws IOException {
		final Path path = Paths.get(RESOURCES + "bank-data-simple.csv");
		final List<String> lines = Files.readAllLines(path);
		
		List<BankTransaction> bankTransactions =  parser.parseLinesFrom(lines);
		
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);

		collectSummery(processor);
 	}
 	
 	//����� ���� �м� ��� ��� �޼���
	private static void collectSummery(BankStatementProcessor bankStatementProcessor) {
		
		System.out.println("�� ��� �ݾ���"+bankStatementProcessor.calculateTotalAmount() +"�Դϴ�.");
		
		System.out.println("2���� ����� ������"+bankStatementProcessor.calculateListMonth(Month.FEBRUARY)+"�Դϴ�.");
		
		System.out.println("Salary(�޿�) ī�װ����� �� ����� ������" +bankStatementProcessor.calculateTotalForCategory("Salary")+"�Դϴ�.");
		//��ҹ���, Ư�� ��� ���� -> case sensitive
	}



}