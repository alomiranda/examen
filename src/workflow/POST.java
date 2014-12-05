package workflow;

import domain.*;


public class POST {
	private ProductCatalog productCatalog;
	public Sale sale;

	public POST( ProductCatalog catalog )
	{
		productCatalog = catalog;
	}

	public void endSale()
	{
		sale.becomeComplete();
	}

	public void EnterItem( int upc, int quantity )
	{
		if( sale.isNewSale() )
		{
			sale = new Sale();
		}
		ProductSpecification spec = productCatalog.specification( upc );
		spec.makeLineItem( sale, quantity );
	}

	public void makePayment( float cashTendered )
	{
		sale.makePayment( cashTendered );
	}

	public Sale getSale()
	{
		return sale;
	}
}
