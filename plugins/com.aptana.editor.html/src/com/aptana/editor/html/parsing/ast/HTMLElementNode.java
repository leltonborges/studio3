package com.aptana.editor.html.parsing.ast;

import com.aptana.parsing.ast.IParseNode;

public class HTMLElementNode extends HTMLNode
{
	private String fName;

	public HTMLElementNode(String tag, int start, int end)
	{
		this(tag, new HTMLNode[0], start, end);
	}

	public HTMLElementNode(String tag, HTMLNode[] children, int start, int end)
	{
		super(HTMLNodeTypes.ELEMENT, children, start, end);
		fName = tag;
		if (tag.length() > 0)
		{
			try
			{
				if (tag.endsWith("/>")) //$NON-NLS-1$
				{
					// self-closing
					fName = tag.substring(1, tag.length() - 2);
				}
				else
				{
					fName = tag.substring(1, tag.length() - 1);
				}
			}
			catch (IndexOutOfBoundsException e)
			{
			}
		}
	}

	public String getName()
	{
		return fName;
	}

	@Override
	public String toString()
	{
		StringBuilder text = new StringBuilder();
		if (fName.length() > 0)
		{
			text.append("<").append(fName); //$NON-NLS-1$
			text.append(">"); //$NON-NLS-1$
			IParseNode[] children = getChildren();
			for (IParseNode child : children)
			{
				text.append(child);
			}
			text.append("</").append(fName).append(">"); //$NON-NLS-1$//$NON-NLS-2$
		}
		return text.toString();
	}
}
