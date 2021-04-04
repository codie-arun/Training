package database;

import java.util.Set;

public interface TransactionDAO {

		public int insertTransaction(TransactionDTO transactionDTO);
		public int updateTransaction(TransactionDTO transactionDTO);
		public int deleteTransaction(int invoice_no);
		public TransactionDTO getTransaction(int invoice_no);
		public Set<TransactionDTO> getAllTransaction();
		public Set<TransactionDTO> getMyTransaction(int invoice_no);
		
}
