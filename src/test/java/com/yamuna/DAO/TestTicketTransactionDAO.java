package com.yamuna.DAO;

import java.util.Iterator;
import java.util.List;

import com.yamuna.model.TicketTransaction;

public class TestTicketTransactionDAO {

	public static void main(String[] args) {
	TicketTransactionDAO tickettransactionDAO=new TicketTransactionDAO();
	
		List<TicketTransaction> list =tickettransactionDAO.list();
		Iterator<TicketTransaction> i = list.iterator();
		while (i.hasNext()) {
		TicketTransaction tickettransaction=(TicketTransaction) i.next();
		System.out.println(tickettransaction.getId() + "\t" +tickettransaction.getUserid()+ "\t" +tickettransaction.getSubject()+ "\t" +tickettransaction.getDescription()+ "\t" +
		tickettransaction.getCreatedDate()+ "\t" +tickettransaction.getResolvedDate()+ "\t" +tickettransaction.getDepartmentId()+ "\t" +tickettransaction.getEmployeeId()+ "\t" +tickettransaction.getStatus());

	}
	}
}
