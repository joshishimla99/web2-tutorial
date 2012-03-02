package execution;

import java.io.ByteArrayInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import model.Bookstore;
import model.Companies;
import model.Company;


public class CompanyXMLMain {
	public static void main(String[] args) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(Companies.class);
			String text = "<companies> <company> <city>REDMOND</city> <country>United States</country> <companyType>Public</companyType> <employees>90000</employees> <id>726263</id> <name>Microsoft Corporation</name> <revenue>72052.0</revenue> <state>WA</state> <ticker>MSFT</ticker> <tickerExchange>NASD</tickerExchange> <website>www.microsoft.com</website> </company> </companies>";
			InputStream is = new ByteArrayInputStream(text.getBytes("UTF-8"));
			Unmarshaller um = context.createUnmarshaller();
			Companies companies = (Companies) um.unmarshal(is);
			for (Company company : companies.getCompany()) {
			}
			System.out.println(companies.getCompany().get(0).getTicker());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
