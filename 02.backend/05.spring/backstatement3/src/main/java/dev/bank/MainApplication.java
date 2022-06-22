package dev.bank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

import dev.bank.data.BankStatementCSVParser;
import dev.bank.data.BankStatementPaser;
import dev.bank.domain.BankTransaction;
import dev.bank.service.BankStatementProcessor;

// Ŭ���̾�Ʈ�� ���� ���� ȭ��
public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		
		BankStatementFactory factory = new BankStatementFactory();
		
//		final BankStatementPaser parser = new BankStatementCSVParser();
//
//		//Analyzer ����
//		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer(parser);
		
		//Parser ����
		
		BankStatementAnalyzer analyzer = factory.bankStatementAnalyzer();
		
		// �м� ����
		analyzer.analyze("bank-data-simple.txt");
		
	}
	

}