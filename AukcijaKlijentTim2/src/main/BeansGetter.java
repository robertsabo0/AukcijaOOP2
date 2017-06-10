package main;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.SesionStavkaI;
import beans.StavkeGetters;

public class BeansGetter {
	
	private static StavkeGetters stavkeGetters;
	private static SesionStavkaI s;
	
	public static StavkeGetters stavkeGetters()
	{
		try{
			if (stavkeGetters == null)
			{
				InitialContext ctx = new InitialContext();
				String name = "ejb:/AukcijaServerTim2//StavkeGettersImpl!" + StavkeGetters.class.getName();
				stavkeGetters = (StavkeGetters) ctx.lookup(name);
			}
			return stavkeGetters;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static SesionStavkaI sessionStavka()
	{
		try{
			if (s == null)
			{
				InitialContext ctx = new InitialContext();
				String name = "ejb:/AukcijaServerTim2//SesionStavkaImpl!" + SesionStavkaI.class.getName()+"?stateful";
				s = (SesionStavkaI) ctx.lookup(name);
			}
			return s;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static void logOut() {
		s.logOut();
		s = null;
	}
	
}
