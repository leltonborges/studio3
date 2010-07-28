package com.aptana.ide.core.io;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS
{

	private static final String BUNDLE_NAME = "com.aptana.ide.core.io.messages"; //$NON-NLS-1$

	public static String ConnectionPointManager_CategoryUnknown;
	public static String ConnectionPointManager_FailedStoreConnectionProperties;

	public static String LockUtils_failedToLock;

	public static String LockUtils_failedToWrite;

	public static String LockUtils_seeErrorLog;

	static
	{
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages()
	{
	}
}
