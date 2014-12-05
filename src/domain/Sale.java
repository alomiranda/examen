package domain;

import java.util.*;

public class Sale {
	Vector lineItems = new Vector();
	private Date date = new Date();
	private boolean isComplete = false;
	public Payment payment;

	public float getBalance()
	{
		return payment.getAmount() - total(payment);
	}

	public void becomeComplete()
	{
		isComplete = true;
	}

	public boolean isComplete() { return isComplete; }

	public void makeLineItem( ProductSpecification spec, int quantity )
	{
		lineItems.addElement( new SaleLineItem( spec, quantity ) );
	}

	public void makePayment( float cashTendered )
	{
		payment = new Payment( cashTendered );
	}

	public float total(Payment payment)
	{
		float total = 0;
		Enumeration	e = lineItems.elements();
	
		while( e.hasMoreElements() )
			{
			total += ( (SaleLineItem) e.nextElement() ).subtotal();
			}
		return total;
	}
}
