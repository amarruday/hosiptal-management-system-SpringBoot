package com.has.utility;

import java.util.Random;
import java.util.StringTokenizer;

public class StringUtility
{
  
  public static String getFileSeparator ()
  {
    String fileSeparator = System.getProperty("file.separator");
    return fileSeparator;
  }

  public static String generateKey (int length)
  {
    String sKey = "";
    Random random = new Random(System.currentTimeMillis());
    long r1 = random.nextLong();
    long r2 = random.nextLong();
    String hash1 = Long.toHexString(r1);
    String hash2 = Long.toHexString(r2);
    sKey = hash1 + hash2;
    if (sKey.length() > length)
    {
      sKey = sKey.substring(0, length);
    }
    return sKey.toUpperCase();
  }

	/*
	 * public static String generatePasswordSalt () { return
	 * RandomStringUtils.randomAlphanumeric(20); }
	 */
  public static String[] tokenizeCommaSeparatedStr(String st)
  {
    StringTokenizer strToken = new StringTokenizer(st, ",");
    int tokenCount = strToken.countTokens();
    int count = 0;
    String[] result = new String[tokenCount];
    while (strToken.hasMoreTokens())
    {
      result[count] = (strToken.nextToken());
      count++;
    }
    return result;
  }
}
