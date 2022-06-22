package dev.bank.service;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import dev.bank.domain.BankTransaction;

//����� ���� ������(�����Ͻ�)������ ó���ϴ� Ŭ����
public class BankStatementProcessor {

	// ���� ��� ���꿡�� ����� ���� ���(List<BankTransation)�� ����� ���̱� ������ Processor Ŭ������ �ʵ�� ����
	private final List<BankTransaction> bankTransactions;

	// 1. �� ����� ���� ��� ����
	public BankStatementProcessor(List<BankTransaction> bankTransactions) {
		this.bankTransactions = bankTransactions;
	}

	public double calculateTotalAmount() {
		double total = 0d;
		for (BankTransaction bankTransaction : bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}

	// 2. �� �� ����� ���� ��� ����
	public List<BankTransaction> calculateListMonth(Month month) {
		final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();

		for (BankTransaction bankTransaction : bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				bankTransactionsInMonth.add(bankTransaction);
			}

		}
		return bankTransactionsInMonth;
	}

	// 3. ī�װ��� ���� ����� ���� ��ȸ ��� ����
	public double calculateTotalForCategory(String category) {
		double total = 0d;
		
		for (BankTransaction bankTransaction : bankTransactions) {
			if(bankTransaction.getDescription().equals(category)) 
				total += bankTransaction.getAmount();
			
		}
		return total;
	}



}