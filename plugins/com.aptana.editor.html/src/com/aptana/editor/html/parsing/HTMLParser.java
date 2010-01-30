package com.aptana.editor.html.parsing;

import beaver.*;

import com.aptana.editor.html.parsing.ast.*;

import java.util.ArrayList;

import com.aptana.parsing.IParser;
import com.aptana.parsing.ast.IParseNode;
import com.aptana.parsing.ast.ParseRootNode;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "HTML.grammar".
 */
public class HTMLParser extends Parser implements IParser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9nzZziEmZ0CGzqoEZOgWH1l#zbzDPTnCKwJyRX8nuwSI4q1J7oZGuy32euOa7aZ8t4Tmss" +
		"wnqvg00bPNQUijFcQhBcxJqqDeCveTHP3zDLatY3g4lr9N3Tsgnk$JLzyyi4x5txiJLsQT5" +
		"4MIJVbzYVtzAVy0Bin7QC=");

	private final Action[] actions;

	private HTMLParserScanner fScanner;

	public HTMLParser() {
		super(PARSING_TABLES);
		fScanner = new HTMLParserScanner();

		actions = new Action[] {
				new Action() {	// [0] Program = Statements.p
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_p = _symbols[offset + 1];
						final ArrayList _list_p = (ArrayList) _symbol_p.value;
						final HTMLElementNode[] p = _list_p == null ? new HTMLElementNode[0] : (HTMLElementNode[]) _list_p.toArray(new HTMLElementNode[_list_p.size()]);
						return new ParseRootNode(p, _symbol_p.getStart(), _symbol_p.getEnd());
					}
				},
				new Action() {	// [1] Statements = Statements Statement
					public Symbol reduce(Symbol[] _symbols, int offset) {
						((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 2].value); return _symbols[offset + 1];
					}
				},
				new Action() {	// [2] Statements = Statement
					public Symbol reduce(Symbol[] _symbols, int offset) {
						ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
					}
				},
				new Action() {	// [3] Statement = START_TAG.t Statements.s
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_t = _symbols[offset + 1];
						final String t = (String) _symbol_t.value;
						final Symbol _symbol_s = _symbols[offset + 2];
						final ArrayList _list_s = (ArrayList) _symbol_s.value;
						final HTMLElementNode[] s = _list_s == null ? new HTMLElementNode[0] : (HTMLElementNode[]) _list_s.toArray(new HTMLElementNode[_list_s.size()]);
						return new HTMLElementNode(t, s, _symbol_t.getStart(), s[s.length - 1].getEnd());
					}
				},
				new Action() {	// [4] Statement = START_TAG.t Statements.s END_TAG.e
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_t = _symbols[offset + 1];
						final String t = (String) _symbol_t.value;
						final Symbol _symbol_s = _symbols[offset + 2];
						final ArrayList _list_s = (ArrayList) _symbol_s.value;
						final HTMLElementNode[] s = _list_s == null ? new HTMLElementNode[0] : (HTMLElementNode[]) _list_s.toArray(new HTMLElementNode[_list_s.size()]);
						final Symbol _symbol_e = _symbols[offset + 3];
						final String e = (String) _symbol_e.value;
						return new HTMLElementNode(t, s, _symbol_t.getStart(), _symbol_e.getEnd());
					}
				},
				new Action() {	// [5] Statement = START_TAG.t END_TAG.e
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_t = _symbols[offset + 1];
						final String t = (String) _symbol_t.value;
						final Symbol _symbol_e = _symbols[offset + 2];
						final String e = (String) _symbol_e.value;
						return new HTMLElementNode(t, _symbol_t.getStart(), _symbol_e.getEnd());
					}
				},
				new Action() {	// [6] Statement = SELF_CLOSING.s
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_s = _symbols[offset + 1];
						final String s = (String) _symbol_s.value;
						return new HTMLElementNode(s, _symbol_s.getStart(), _symbol_s.getEnd());
					}
				},
				new Action() {	// [7] Statement = TEXT.t
					public Symbol reduce(Symbol[] _symbols, int offset) {
						final Symbol _symbol_t = _symbols[offset + 1];
						final String t = (String) _symbol_t.value;
						return new HTMLElementNode("", _symbol_t.getStart(), _symbol_t.getEnd());
					}
				},
				Action.RETURN	// [8] Statement = error
			};
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		return actions[rule_num].reduce(_symbols, offset);
	}

	@Override
	public IParseNode parse(String source) throws java.lang.Exception
	{
		fScanner.setSource(source);
		return (IParseNode) super.parse(fScanner);
	}
}
