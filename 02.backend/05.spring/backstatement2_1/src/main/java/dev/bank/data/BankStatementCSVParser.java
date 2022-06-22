package dev.bank.data;

import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.domain.BankTransaction;

@Component("parser") // 컴포넌트 스캔 대상에 해당되도록함
public class BankStatementCSVParser implements BankStatementPaser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// 한 줄만 파싱, 이 클래스 내에서만 사용할 예정
	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split(",");
		
		final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
		final double amount= Double.parseDouble(columns[1]);
		final String description = columns[2];
		
//		BankTransaction bankTransaction = new BankTransaction(date, amouse, description);
		
		return new BankTransaction(date, amount, description);

	}
	
	// 한 줄씩 파싱 후, 리스트에 추가
	// BankTransaction -> model 클래스
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for (String line : lines) {
			 BankTransaction bankTransaction = parseFrom(line);
			 bankTransactions.add(bankTransaction);
		}
		
		return bankTransactions;
	}


	
}
