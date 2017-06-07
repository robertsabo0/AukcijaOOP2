package main;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import beans.StavkeGetters;

public class BeansGetter {
	
	private static StavkeGetters stavkeGetters;
	
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
}
