package domain;

import java.util.*;

import workflow.POST;

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

	public void makePayment( float cashTendered )
	{
		payment = new Payment( cashTendered );
	}

	public float total(Payment payment)
	{
		float total = 0;
		Enumeration	e = lineItems.elements();
	
		total = contadorTotal(total, e);
		return total;
	}

	private float contadorTotal(float total, Enumeration e) {
		while( e.hasMoreElements() )
			{
			total += ( (SaleLineItem) e.nextElement() ).subtotal();
			}
		return total;
	}

	public float getTotal(POST post)
	{
	  return total(payment);
	}

	public boolean isNewSale()
	{
		return ( this == null ) || ( isComplete() );
	}
}
