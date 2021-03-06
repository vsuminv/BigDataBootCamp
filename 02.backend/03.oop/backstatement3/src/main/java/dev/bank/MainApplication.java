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

// 클라이언트가 보는 메인 화면
public class MainApplication {
	
	public static void main(String[] args) throws IOException {
		//Analyzer 생성
		final BankStatementAnalyzer analyzer = new BankStatementAnalyzer();
		
		//Parser 지정
		final BankStatementPaser parser = new BankStatementCSVParser();
		
		// 분석 수행
		analyzer.analyze("bank-data-simple.csv", parser);
		
	}
	

}