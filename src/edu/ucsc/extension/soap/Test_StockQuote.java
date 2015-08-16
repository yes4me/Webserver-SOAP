/* ===========================================================================
Created:	2015/08/05
Author:		Thomas Nguyen - thomas_ejob@hotmail.com
Purpose:	To practice SOAP & WSDL

TempConvert
	DOC:	http://www.service-repository.com/service/overview/-1789095104
	WSDL:	http://www.w3schools.com/webservices/tempconvert.asmx?WSDL
Currency Converter:
	DOC:	http://www.webservicex.net/ws/WSDetails.aspx?WSID=10
	WSDL:	http://www.webservicex.net/CurrencyConvertor.asmx?WSDL
Geo:
	DOC:	http://www.webservicex.net/ws/WSDetails.aspx?CATID=12&WSID=64
	WSDL: 	http://www.webservicex.net/geoipservice.asmx?WSDL
	Way to get IP address:
		cmd > ping google.com > copy IP address (74.125.224.5)
		Run > Run Configurations > Arguments > Program arguments: paste IP address > Run
=========================================================================== */

package edu.ucsc.extension.soap;

import java.rmi.RemoteException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import NET.webserviceX.www.StockQuoteSoap;
import NET.webserviceX.www.StockQuoteSoapProxy;
import lib.MyXML;

public class Test_StockQuote {
	@Before
	public void setUp() throws Exception {
	}
	@After
	public void tearDown() throws Exception {
		System.out.println("DONE");
	}

	@Test
	public void getExistTicker() throws RemoteException {
		System.out.println("RUNNING TEST: getExistTicker");

		StockQuoteSoap stockQuoteSoap = new StockQuoteSoapProxy();
		String contentType = stockQuoteSoap.getQuote("NFLX");
		/* RESULT:
		<StockQuotes>
			<Stock>
				<Symbol>GOOG</Symbol>
				<Last>635.30</Last>
				<Date>8/7/2015</Date>
				<Time>4:00pm</Time>
				<Change>-7.38</Change>
				<Open>640.23</Open>
				<High>642.68</High>
				<Low>629.71</Low>
				<Volume>1403865</Volume>
				<MktCap>435.52B</MktCap>
				<PreviousClose>642.68</PreviousClose>
				<PercentageChange>-1.15%</PercentageChange>
				<AnnRange>486.23 - 678.64</AnnRange>
				<Earns>21.22</Earns>
				<P-E>29.93</P-E>
				<Name>Google Inc.</Name>
			</Stock>
		</StockQuotes>
		*/
		//System.out.println("content type: " + contentType);

		MyXML myXML		= new MyXML(contentType);
		String symbol	= myXML.getTextContent("Symbol");
		String name		= myXML.getTextContent("Name");

		Assert.assertEquals(symbol, "NFLX");
		Assert.assertTrue( myXML.checkType("High", Double.class) );
		Assert.assertTrue( myXML.checkType("Low", Double.class) );
		Assert.assertEquals(name, "Netflix");
	}
	@Test
	public void getFakeTicker() throws RemoteException {
		System.out.println("RUNNING TEST: getFakeTicker");

		StockQuoteSoap stockQuoteSoap = new StockQuoteSoapProxy();
		String contentType = stockQuoteSoap.getQuote("UCSCEXTN");
		/* RESULT:
		<StockQuotes>
			<Stock>
				<Symbol>UCSCEXTN</Symbol>
				<Last>N/A</Last>
				<Date>N/A</Date>
				<Time>N/A</Time>
				<Change>N/A</Change>
				<Open>N/A</Open>
				<High>N/A</High>
				<Low>N/A</Low>
				<Volume>N/A</Volume>
				<MktCap>N/A</MktCap>
				<PreviousClose>N/A</PreviousClose>
				<PercentageChange>N/A</PercentageChange>
				<AnnRange>N/A</AnnRange>
				<Earns>N/A</Earns>
				<P-E>N/A</P-E>
				<Name>N/A</Name>
			</Stock>
		</StockQuotes>
		*/
		//System.out.println("content type: " + contentType);

		MyXML myXML = new MyXML(contentType);
		String symbol	= myXML.getTextContent("Symbol");
		String name		= myXML.getTextContent("Name");

		Assert.assertEquals(symbol, "UCSCEXTN");
		Assert.assertEquals(myXML.getTextContent("High"), "N/A" );
		Assert.assertEquals(myXML.getTextContent("Low"), "N/A" );
		Assert.assertEquals(name, "Netflix");
	}
} 