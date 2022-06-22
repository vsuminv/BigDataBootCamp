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
import dev.bank.service.BankStatementProcessor;

public class BankStatementAnalyzerWithProcessor {
	
	// ����ݳ��� ������ back-data-simple.txt ������ ��� ����.
	private static final String RESOURCES = "src/main/resources/";

	public static void main(String[] args) throws IOException {
		// 1��° ��� �䱸����, ��� �ŷ�����(BankStatement)�� �� ����ϱ� / Phase1
		final Path path = Paths.get(RESOURCES + "bank-data-simple.txt");
		System.out.println(path);
		
		//1. ���� ��� Ȯ��, �б�
		final List<String> lines = Files.readAllLines(path);
		System.out.println(lines);
		
		//2. �о���� ���� �Ľ�(parsing)
		final BankStatementTSVParser tsvParser = new BankStatementTSVParser();
		List<BankTransaction> bankTransactions =  tsvParser.parseLinesFrom(lines);
		
		
		//3. ��ɺ�(�� ����� ���� or �� �� ����� ���� or ī�װ����� ��) ����ó��(Processing)�� ��ü ����
		BankStatementProcessor processor = new BankStatementProcessor(bankTransactions);
		
		//����� ���� �м� ��� ���
	
		
		
//		System.out.println("1���� �� ��� �ݾ���"+ findTransactionsInJanuary()+"�Դϴ�.");
		collectSummery(processor);
	}
	
	//�м� ��� suemmery
	private static void collectSummery(BankStatementProcessor bankStatementProcessor) {
		
		System.out.println("�� ��� �ݾ���"+bankStatementProcessor.calculateTotalAmount() +"�Դϴ�.");
		
		System.out.println("2���� ����� ������"+bankStatementProcessor.calculateListMonth(Month.FEBRUARY)+"�Դϴ�.");
		
		System.out.println("Salary(�޿�) ī�װ����� �� ����� ������" +bankStatementProcessor.calculateTotalForCategory("Salary")+"�Դϴ�.");
		//��ҹ���, Ư�� ��� ���� -> case sensitive
	}



}