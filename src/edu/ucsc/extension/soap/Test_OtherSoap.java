/* ===========================================================================
Created:	2015/08/05
Author:		Thomas Nguyen - thomas_ejob@hotmail.com
Purpose:	To practice SOAP & WSDL
Setup:		right click project name > new > Other > Web Services > Web Client Service > next
			enter http of SOAP, select install client(in the drawing) > finish

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
Stocks:
	DOC:	http://service-repository.com/service/overview/386524652
	WSDL:	http://www.webservicex.com/stockquote.asmx?WSDL
=========================================================================== */

package edu.ucsc.extension.soap;

import java.rmi.RemoteException;

//import org.junit.Test;

import com.w3schools.www.webservices.TempConvertSoap;
import com.w3schools.www.webservices.TempConvertSoapProxy;

import NET.webserviceX.www.StockQuoteSoap;
import NET.webserviceX.www.StockQuoteSoapProxy;

/*
import NET.webserviceX.www.Currency;
import NET.webserviceX.www.CurrencyConvertor;
import NET.webserviceX.www.CurrencyConvertorSoap;
import NET.webserviceX.www.CurrencyConvertorSoapProxy;
 */

/*
import net.webservicex.www.GeoIP;
import net.webservicex.www.GeoIPServiceSoap;
import net.webservicex.www.GeoIPServiceSoapProxy;
 */

public class Test_OtherSoap {
	public static void main(String[] args) throws RemoteException {
		TempConvertSoap clientTemp = new TempConvertSoapProxy();
		String conversionTemp = clientTemp.celsiusToFahrenheit("100");
		System.out.println("100C = "+ conversionTemp +"F");
		conversionTemp = clientTemp.fahrenheitToCelsius("212");
		System.out.println("212F = "+ conversionTemp +"C");

		/*
		CurrencyConvertorSoap clientCurrency = new CurrencyConvertorSoapProxy();
		double conversionRate = clientCurrency.conversionRate(Currency.USD, Currency.EUR); 
		System.out.println(conversionRate);
		*/

		/*
		if (args.length != 1) {
			System.out.println("You need to pass in one IP address");
		}
		else
		{
			String ipAddress = args[0];
			GeoIPServiceSoap client_geo = new GeoIPServiceSoapProxy();
			GeoIP geoIP = client_geo.getGeoIP(ipAddress);
			String countryName = geoIP.getCountryName();
			System.out.println("IP address:"+ ipAddress +", country:"+ countryName);
		}
		*/

		StockQuoteSoap stockQuoteSoap = new StockQuoteSoapProxy();
		String quote = stockQuoteSoap.getQuote("GOOG");
		//<StockQuotes><Stock><Symbol>GOOG</Symbol><Last>635.30</Last><Date>8/7/2015</Date><Time>4:00pm</Time><Change>-7.38</Change><Open>640.23</Open><High>642.68</High><Low>629.71</Low><Volume>1403865</Volume><MktCap>435.52B</MktCap><PreviousClose>642.68</PreviousClose><PercentageChange>-1.15%</PercentageChange><AnnRange>486.23 - 678.64</AnnRange><Earns>21.22</Earns><P-E>29.93</P-E><Name>Google Inc.</Name></Stock></StockQuotes>
		System.out.println(quote);

		System.out.println("DONE");
	}
}