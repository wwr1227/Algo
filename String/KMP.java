
public class KMP
{
	public static int indexOf(String a, String b)
	{
		if (b == null && b.length() == 0) 
			return 0;
		if (a == null && a.length() == 0)
			return -1;

		char[] aa = a.toCharArray();
		char[] bb = b.toCharArray();

		int m = 0;
		int i = 0; 
		int[] t = createTable(bb);

		while (m + i < aa.length)
		{
			if (bb[i] == aa[m + i])
			{
				if (i == bb.length - 1) //the last char match
					return m;
				i += 1;
			}
			else
			{
				m = (m + i - t[i]);
				if (t[i] > -1)
					i = t[i];
				else
					i = 0;
			}
		}

		return -1;
	}

	private static int[] createTable(char[] bb)
	{
		int[] table = new int[bb.length];
		int pos = 2;
		int cnd = 0;

		table[0] = -1;
		table[1] = 0;
		while (pos < bb.length)
		{
			if (bb[pos - 1] == bb[cnd])
			{
				cnd += 1;
				table[pos] = cnd;
				pos += 1;
			}
			else if (cnd > 0)
				cnd = table[cnd];
			else
			{
				table[pos] = 0;
				pos += 1;
			}
		}
		return table;
	}
}
