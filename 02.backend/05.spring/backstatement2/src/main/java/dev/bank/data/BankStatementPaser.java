package dev.bank.data;

import java.util.List;

import dev.bank.domain.BankTransaction;

//parse ���赵
public interface BankStatementPaser {
	BankTransaction parseFrom(String line);
	List<BankTransaction> parseLinesFrom(List<String> lines);

}
