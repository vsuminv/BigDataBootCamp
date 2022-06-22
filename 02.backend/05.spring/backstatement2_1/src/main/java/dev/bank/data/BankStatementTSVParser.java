package dev.bank.data;

import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.bank.domain.BankTransaction;

@Component
public class BankStatementTSVParser implements BankStatementPaser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	// �� �ٸ� �Ľ�, �� Ŭ���� �������� ����� ����
	public BankTransaction parseFrom(final String line) {
		final String[] columns = line.split("\t");
		
		final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
		final double amount= Double.parseDouble(columns[1]);
		final String description = columns[2];
		
//		BankTransaction bankTransaction = new BankTransaction(date, amouse, description);
		
		return new BankTransaction(date, amount, description);

	}
	
	// �� �پ� �Ľ� ��, ����Ʈ�� �߰�
	// BankTransaction -> model Ŭ����
	public List<BankTransaction> parseLinesFrom(List<String> lines) {
		List<BankTransaction> bankTransactions = new ArrayList<>();
		
		for (String line : lines) {
			 BankTransaction bankTransaction = parseFrom(line);
			 bankTransactions.add(bankTransaction);
		}
		
		return bankTransactions;
	}

	
}