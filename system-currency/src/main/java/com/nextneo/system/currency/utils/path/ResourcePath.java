package com.nextneo.system.currency.utils.path;

public class ResourcePath {
	
	public final static String SERVICE_API_GATEWAY = "nextneo-system-zuul-api-gateway-server";
	public final static String SERVICE_SEND_EMAIL = "nextneo-system-send-email";
	public final static String API_EXCHANGE_RATES = "https://api.exchangeratesapi.io/";

	
	public class ApiExchangeRates {

		public final static String CURRENCY_EXCHANGE = "latest?base={from}&symbols={to}";

	}
	
	public class Currency {

		public final static String TEST = "/test";
		public final static String CURRENCY_EXCHANGE = "/currency-exchange/from/{from}/to/{to}";

	}
	
	public class SendEmail {

		public final static String TEST = "/test";
		public final static String SEND_EMAIL = "/send-email";

	}

}
