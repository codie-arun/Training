package week5day2;

import java.util.Set;

public interface InvoiceDAO {

	public int insertInvoice(InvoiceDTO invoiceDTO);
	public int updateInvoice(InvoiceDTO invoiceDTO);
	public int deleteInvoice(int invno);
	public InvoiceDTO getInvoice(int invno);
	public Set<InvoiceDTO> getAllInvoice();

}
