package main;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.SesionStavka;
import beans.SesionStavkaI;
import beans.StavkeGetters;

public class BeansGetter {
	
	private static StavkeGetters stavkeGetters;
	private static SesionStavkaI s;
	
	public static StavkeGetters stavkeGetters() throws NamingException
	{
		if (stavkeGetters == null)
		{
			InitialContext ctx = new InitialContext();
			String name = "ejb:/AukcijaServerTim2//StavkeGettersImpl!" + StavkeGetters.class.getName();
			stavkeGetters = (StavkeGetters) ctx.lookup(name);
		}
		return stavkeGetters;
	}
	public static SesionStavkaI sessionStavka() throws NamingException
	{
		if (s == null)
		{
			InitialContext ctx = new InitialContext();
			String name = "ejb:/AukcijaServerTim2//SesionStavka!" + SesionStavkaI.class.getName()+"?stateful";
			s = (SesionStavkaI) ctx.lookup(name);
		}
		return s;
	}
}
