// $ANTLR 2.7.1: "action.g" -> "ActionLexer.java"$

	package antlr.actions.cpp;

import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.util.Hashtable;

import antlr.ActionTransInfo;
import antlr.ByteBuffer;
import antlr.CharBuffer;
import antlr.CharStreamException;
import antlr.CharStreamIOException;
import antlr.CodeGenerator;
import antlr.InputBuffer;
import antlr.LexerSharedInputState;
import antlr.NoViableAltForCharException;
import antlr.RecognitionException;
import antlr.RuleBlock;
import antlr.Token;
import antlr.TokenStream;
import antlr.TokenStreamException;
import antlr.TokenStreamIOException;
import antlr.TokenStreamRecognitionException;
import antlr.Tool;
import antlr.collections.impl.BitSet;
import antlr.collections.impl.Vector;

/** Perform the following translations:

    AST related translations

	##				-> currentRule_AST
	#(x,y,z)		-> codeGenerator.getASTCreateString(vector-of(x,y,z))
	#[x]			-> codeGenerator.getASTCreateString(x)
	#x				-> codeGenerator.mapTreeId(x)

	Inside context of #(...), you can ref (x,y,z), [x], and x as shortcuts.

    Text related translations

	$append(x)	 -> text.append(x)
	$setText(x)	 -> text.setLength(_begin); text.append(x)
	$getText		 -> new String(text.getBuffer(),_begin,text.length()-_begin)
	$setToken(x) -> _token = x
	$setType(x)	 -> _ttype = x
 */
public class ActionLexer extends antlr.CharScanner implements ActionLexerTokenTypes, TokenStream
 {

	protected RuleBlock currentRule;
	protected CodeGenerator generator;
	protected int lineOffset = 0;
	private Tool tool;	// The ANTLR tool
	ActionTransInfo transInfo;

 	public ActionLexer( String s,
						RuleBlock currentRule,
						CodeGenerator generator,
						ActionTransInfo transInfo) {
		this(new StringReader(s));
		this.currentRule = currentRule;
		this.generator = generator;
		this.transInfo = transInfo;
	}

	public void setLineOffset(int lineOffset) {
		// this.lineOffset = lineOffset;
		setLine(lineOffset);
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	// Override of error-reporting for syntax
	public void reportError(RecognitionException e) {
		System.err.print("Syntax error in action: ");
		super.reportError(e);
	}

public ActionLexer(InputStream in) {
	this(new ByteBuffer(in));
}
public ActionLexer(Reader in) {
	this(new CharBuffer(in));
}
public ActionLexer(InputBuffer ib) {
	this(new LexerSharedInputState(ib));
}
public ActionLexer(LexerSharedInputState state) {
	super(state);
	literals = new Hashtable();
caseSensitiveLiterals = true;
setCaseSensitive(true);
}

public Token nextToken() throws TokenStreamException {
	Token theRetToken=null;
tryAgain:
	for (;;) {
		Token _token = null;
		int _ttype = Token.INVALID_TYPE;
		resetText();
		try {   // for char stream error handling
			try {   // for lexical error handling
				if (((LA(1) >= '\u0003' && LA(1) <= '~'))) {
					mACTION(true);
					theRetToken=_returnToken;
				}
				else {
					if (LA(1)==EOF_CHAR) {uponEOF(); _returnToken = makeToken(Token.EOF_TYPE);}
				else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
				}
				
				if ( _returnToken==null ) continue tryAgain; // found SKIP token
				_ttype = _returnToken.getType();
				_returnToken.setType(_ttype);
				return _returnToken;
			}
			catch (RecognitionException e) {
				throw new TokenStreamRecognitionException(e);
			}
		}
		catch (CharStreamException cse) {
			if ( cse instanceof CharStreamIOException ) {
				throw new TokenStreamIOException(((CharStreamIOException)cse).io);
			}
			else {
				throw new TokenStreamException(cse.getMessage());
			}
		}
	}
}

	public final void mACTION(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ACTION;
		int _saveIndex;
		
		{
		int _cnt3=0;
		_loop3:
		do {
			switch ( LA(1)) {
			case '\u0003':  case '\u0004':  case '\u0005':  case '\u0006':
			case '\u0007':  case '\u0008':  case '\t':  case '\n':
			case '\u000b':  case '\u000c':  case '\r':  case '\u000e':
			case '\u000f':  case '\u0010':  case '\u0011':  case '\u0012':
			case '\u0013':  case '\u0014':  case '\u0015':  case '\u0016':
			case '\u0017':  case '\u0018':  case '\u0019':  case '\u001a':
			case '\u001b':  case '\u001c':  case '\u001d':  case '\u001e':
			case '\u001f':  case ' ':  case '!':  case '"':
			case '%':  case '&':  case '\'':  case '(':
			case ')':  case '*':  case '+':  case ',':
			case '-':  case '.':  case '/':  case '0':
			case '1':  case '2':  case '3':  case '4':
			case '5':  case '6':  case '7':  case '8':
			case '9':  case ':':  case ';':  case '<':
			case '=':  case '>':  case '?':  case '@':
			case 'A':  case 'B':  case 'C':  case 'D':
			case 'E':  case 'F':  case 'G':  case 'H':
			case 'I':  case 'J':  case 'K':  case 'L':
			case 'M':  case 'N':  case 'O':  case 'P':
			case 'Q':  case 'R':  case 'S':  case 'T':
			case 'U':  case 'V':  case 'W':  case 'X':
			case 'Y':  case 'Z':  case '[':  case '\\':
			case ']':  case '^':  case '_':  case '`':
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':  case '{':  case '|':
			case '}':  case '~':
			{
				mSTUFF(false);
				break;
			}
			case '#':
			{
				mAST_ITEM(false);
				break;
			}
			case '$':
			{
				mTEXT_ITEM(false);
				break;
			}
			default:
			{
				if ( _cnt3>=1 ) { break _loop3; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
			}
			}
			_cnt3++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSTUFF(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STUFF;
		int _saveIndex;
		
		switch ( LA(1)) {
		case '"':
		{
			mSTRING(false);
			break;
		}
		case '\'':
		{
			mCHAR(false);
			break;
		}
		case '\n':
		{
			match('\n');
			newline();
			break;
		}
		case '\u0003':  case '\u0004':  case '\u0005':  case '\u0006':
		case '\u0007':  case '\u0008':  case '\t':  case '\u000b':
		case '\u000c':  case '\u000e':  case '\u000f':  case '\u0010':
		case '\u0011':  case '\u0012':  case '\u0013':  case '\u0014':
		case '\u0015':  case '\u0016':  case '\u0017':  case '\u0018':
		case '\u0019':  case '\u001a':  case '\u001b':  case '\u001c':
		case '\u001d':  case '\u001e':  case '\u001f':  case ' ':
		case '!':  case '%':  case '&':  case '(':
		case ')':  case '*':  case '+':  case ',':
		case '-':  case '.':  case '0':  case '1':
		case '2':  case '3':  case '4':  case '5':
		case '6':  case '7':  case '8':  case '9':
		case ':':  case ';':  case '<':  case '=':
		case '>':  case '?':  case '@':  case 'A':
		case 'B':  case 'C':  case 'D':  case 'E':
		case 'F':  case 'G':  case 'H':  case 'I':
		case 'J':  case 'K':  case 'L':  case 'M':
		case 'N':  case 'O':  case 'P':  case 'Q':
		case 'R':  case 'S':  case 'T':  case 'U':
		case 'V':  case 'W':  case 'X':  case 'Y':
		case 'Z':  case '[':  case '\\':  case ']':
		case '^':  case '_':  case '`':  case 'a':
		case 'b':  case 'c':  case 'd':  case 'e':
		case 'f':  case 'g':  case 'h':  case 'i':
		case 'j':  case 'k':  case 'l':  case 'm':
		case 'n':  case 'o':  case 'p':  case 'q':
		case 'r':  case 's':  case 't':  case 'u':
		case 'v':  case 'w':  case 'x':  case 'y':
		case 'z':  case '{':  case '|':  case '}':
		case '~':
		{
			{
			match(_tokenSet_0);
			}
			break;
		}
		default:
			if ((LA(1)=='/') && (LA(2)=='*'||LA(2)=='/')) {
				mCOMMENT(false);
			}
			else if ((LA(1)=='\r') && (LA(2)=='\n')) {
				match("\r\n");
				newline();
			}
			else if ((LA(1)=='/') && (_tokenSet_1.member(LA(2)))) {
				match('/');
				{
				match(_tokenSet_1);
				}
			}
			else if ((LA(1)=='\r') && (true)) {
				match('\r');
				newline();
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mAST_ITEM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AST_ITEM;
		int _saveIndex;
		Token t=null;
		Token id=null;
		Token ctor=null;
		
		if ((LA(1)=='#') && (LA(2)=='(')) {
			_saveIndex=text.length();
			match('#');
			text.setLength(_saveIndex);
			mTREE(true);
			t=_returnToken;
		}
		else if ((LA(1)=='#') && (_tokenSet_2.member(LA(2)))) {
			_saveIndex=text.length();
			match('#');
			text.setLength(_saveIndex);
			mID(true);
			id=_returnToken;
			
						String idt = id.getText();
						text.setLength(_begin); text.append(generator.mapTreeId(idt,transInfo));
					
			{
			if ((_tokenSet_3.member(LA(1))) && (true)) {
				mWS(false);
			}
			else {
			}
			
			}
			{
			if ((LA(1)=='=') && (true)) {
				mVAR_ASSIGN(false);
			}
			else {
			}
			
			}
		}
		else if ((LA(1)=='#') && (LA(2)=='[')) {
			_saveIndex=text.length();
			match('#');
			text.setLength(_saveIndex);
			mAST_CONSTRUCTOR(true);
			ctor=_returnToken;
		}
		else if ((LA(1)=='#') && (LA(2)=='#')) {
			match("##");
			
						String r=currentRule.getRuleName()+"_AST"; text.setLength(_begin); text.append(r);
						if ( transInfo!=null ) {
							transInfo.refRuleRoot=r;	// we ref root of tree
						}
					
			{
			if ((_tokenSet_3.member(LA(1))) && (true)) {
				mWS(false);
			}
			else {
			}
			
			}
			{
			if ((LA(1)=='=') && (true)) {
				mVAR_ASSIGN(false);
			}
			else {
			}
			
			}
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTEXT_ITEM(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TEXT_ITEM;
		int _saveIndex;
		Token a1=null;
		Token a2=null;
		Token a3=null;
		Token a4=null;
		
		if ((LA(1)=='$') && (LA(2)=='a')) {
			match("$append(");
			mTEXT_ARG(true);
			a1=_returnToken;
			match(')');
			
						String t = "text += "+a1.getText();
						text.setLength(_begin); text.append(t);
					
		}
		else if ((LA(1)=='$') && (LA(2)=='s')) {
			match("$set");
			{
			if ((LA(1)=='T') && (LA(2)=='e')) {
				match("Text(");
				mTEXT_ARG(true);
				a2=_returnToken;
				match(')');
				
								String t;
								t = "text.erase(_begin); text += "+a2.getText();
								text.setLength(_begin); text.append(t);
							
			}
			else if ((LA(1)=='T') && (LA(2)=='o')) {
				match("Token(");
				mTEXT_ARG(true);
				a3=_returnToken;
				match(')');
				
								String t="_token = "+a3.getText();
								text.setLength(_begin); text.append(t);
							
			}
			else if ((LA(1)=='T') && (LA(2)=='y')) {
				match("Type(");
				mTEXT_ARG(true);
				a4=_returnToken;
				match(')');
				
								String t="_ttype = "+a4.getText();
								text.setLength(_begin); text.append(t);
							
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			
			}
		}
		else if ((LA(1)=='$') && (LA(2)=='g')) {
			match("$getText");
			
						text.setLength(_begin); text.append("text.substr(_begin,text.length()-_begin)");
					
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mCOMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = COMMENT;
		int _saveIndex;
		
		if ((LA(1)=='/') && (LA(2)=='/')) {
			mSL_COMMENT(false);
		}
		else if ((LA(1)=='/') && (LA(2)=='*')) {
			mML_COMMENT(false);
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSTRING(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = STRING;
		int _saveIndex;
		
		match('"');
		{
		_loop91:
		do {
			switch ( LA(1)) {
			case '\\':
			{
				mESC(false);
				break;
			}
			case '\u0003':  case '\u0004':  case '\u0005':  case '\u0006':
			case '\u0007':  case '\u0008':  case '\t':  case '\n':
			case '\u000b':  case '\u000c':  case '\r':  case '\u000e':
			case '\u000f':  case '\u0010':  case '\u0011':  case '\u0012':
			case '\u0013':  case '\u0014':  case '\u0015':  case '\u0016':
			case '\u0017':  case '\u0018':  case '\u0019':  case '\u001a':
			case '\u001b':  case '\u001c':  case '\u001d':  case '\u001e':
			case '\u001f':  case ' ':  case '!':  case '#':
			case '$':  case '%':  case '&':  case '\'':
			case '(':  case ')':  case '*':  case '+':
			case ',':  case '-':  case '.':  case '/':
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':  case ':':  case ';':
			case '<':  case '=':  case '>':  case '?':
			case '@':  case 'A':  case 'B':  case 'C':
			case 'D':  case 'E':  case 'F':  case 'G':
			case 'H':  case 'I':  case 'J':  case 'K':
			case 'L':  case 'M':  case 'N':  case 'O':
			case 'P':  case 'Q':  case 'R':  case 'S':
			case 'T':  case 'U':  case 'V':  case 'W':
			case 'X':  case 'Y':  case 'Z':  case '[':
			case ']':  case '^':  case '_':  case '`':
			case 'a':  case 'b':  case 'c':  case 'd':
			case 'e':  case 'f':  case 'g':  case 'h':
			case 'i':  case 'j':  case 'k':  case 'l':
			case 'm':  case 'n':  case 'o':  case 'p':
			case 'q':  case 'r':  case 's':  case 't':
			case 'u':  case 'v':  case 'w':  case 'x':
			case 'y':  case 'z':  case '{':  case '|':
			case '}':  case '~':
			{
				matchNot('"');
				break;
			}
			default:
			{
				break _loop91;
			}
			}
		} while (true);
		}
		match('"');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mCHAR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = CHAR;
		int _saveIndex;
		
		match('\'');
		{
		switch ( LA(1)) {
		case '\\':
		{
			mESC(false);
			break;
		}
		case '\u0003':  case '\u0004':  case '\u0005':  case '\u0006':
		case '\u0007':  case '\u0008':  case '\t':  case '\n':
		case '\u000b':  case '\u000c':  case '\r':  case '\u000e':
		case '\u000f':  case '\u0010':  case '\u0011':  case '\u0012':
		case '\u0013':  case '\u0014':  case '\u0015':  case '\u0016':
		case '\u0017':  case '\u0018':  case '\u0019':  case '\u001a':
		case '\u001b':  case '\u001c':  case '\u001d':  case '\u001e':
		case '\u001f':  case ' ':  case '!':  case '"':
		case '#':  case '$':  case '%':  case '&':
		case '(':  case ')':  case '*':  case '+':
		case ',':  case '-':  case '.':  case '/':
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':  case ':':  case ';':
		case '<':  case '=':  case '>':  case '?':
		case '@':  case 'A':  case 'B':  case 'C':
		case 'D':  case 'E':  case 'F':  case 'G':
		case 'H':  case 'I':  case 'J':  case 'K':
		case 'L':  case 'M':  case 'N':  case 'O':
		case 'P':  case 'Q':  case 'R':  case 'S':
		case 'T':  case 'U':  case 'V':  case 'W':
		case 'X':  case 'Y':  case 'Z':  case '[':
		case ']':  case '^':  case '_':  case '`':
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':  case '{':  case '|':
		case '}':  case '~':
		{
			matchNot('\'');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		match('\'');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTREE(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TREE;
		int _saveIndex;
		Token t=null;
		Token t2=null;
		
			StringBuffer buf = new StringBuffer();
			int n=0;
			Vector terms = new Vector(10);
		
		
		_saveIndex=text.length();
		match('(');
		text.setLength(_saveIndex);
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			_saveIndex=text.length();
			mWS(false);
			text.setLength(_saveIndex);
			break;
		}
		case '"':  case '#':  case '(':  case ':':
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':  case '[':  case '_':
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		_saveIndex=text.length();
		mTREE_ELEMENT(true);
		text.setLength(_saveIndex);
		t=_returnToken;
		
					terms.appendElement(
						generator.processStringForASTConstructor(t.getText())
											 );
				
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			_saveIndex=text.length();
			mWS(false);
			text.setLength(_saveIndex);
			break;
		}
		case ')':  case ',':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		{
		_loop20:
		do {
			if ((LA(1)==',')) {
				_saveIndex=text.length();
				match(',');
				text.setLength(_saveIndex);
				{
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					_saveIndex=text.length();
					mWS(false);
					text.setLength(_saveIndex);
					break;
				}
				case '"':  case '#':  case '(':  case ':':
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':  case '[':  case '_':
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				}
				}
				_saveIndex=text.length();
				mTREE_ELEMENT(true);
				text.setLength(_saveIndex);
				t2=_returnToken;
				
								terms.appendElement(
									generator.processStringForASTConstructor(t2.getText())
														  );
							
				{
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					_saveIndex=text.length();
					mWS(false);
					text.setLength(_saveIndex);
					break;
				}
				case ')':  case ',':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				}
				}
			}
			else {
				break _loop20;
			}
			
		} while (true);
		}
		text.setLength(_begin); text.append(generator.getASTCreateString(terms));
		_saveIndex=text.length();
		match(')');
		text.setLength(_saveIndex);
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mID(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			matchRange('a','z');
			break;
		}
		case 'A':  case 'B':  case 'C':  case 'D':
		case 'E':  case 'F':  case 'G':  case 'H':
		case 'I':  case 'J':  case 'K':  case 'L':
		case 'M':  case 'N':  case 'O':  case 'P':
		case 'Q':  case 'R':  case 'S':  case 'T':
		case 'U':  case 'V':  case 'W':  case 'X':
		case 'Y':  case 'Z':
		{
			matchRange('A','Z');
			break;
		}
		case '_':
		{
			match('_');
			break;
		}
		case ':':
		{
			match("::");
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		{
		_loop77:
		do {
			if ((_tokenSet_4.member(LA(1))) && (true)) {
				{
				switch ( LA(1)) {
				case 'a':  case 'b':  case 'c':  case 'd':
				case 'e':  case 'f':  case 'g':  case 'h':
				case 'i':  case 'j':  case 'k':  case 'l':
				case 'm':  case 'n':  case 'o':  case 'p':
				case 'q':  case 'r':  case 's':  case 't':
				case 'u':  case 'v':  case 'w':  case 'x':
				case 'y':  case 'z':
				{
					matchRange('a','z');
					break;
				}
				case 'A':  case 'B':  case 'C':  case 'D':
				case 'E':  case 'F':  case 'G':  case 'H':
				case 'I':  case 'J':  case 'K':  case 'L':
				case 'M':  case 'N':  case 'O':  case 'P':
				case 'Q':  case 'R':  case 'S':  case 'T':
				case 'U':  case 'V':  case 'W':  case 'X':
				case 'Y':  case 'Z':
				{
					matchRange('A','Z');
					break;
				}
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':
				{
					matchRange('0','9');
					break;
				}
				case '_':
				{
					match('_');
					break;
				}
				case ':':
				{
					match("::");
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				}
				}
			}
			else {
				break _loop77;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mWS(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = WS;
		int _saveIndex;
		
		{
		int _cnt111=0;
		_loop111:
		do {
			if ((LA(1)=='\r') && (LA(2)=='\n')) {
				match('\r');
				match('\n');
				newline();
			}
			else if ((LA(1)==' ') && (true)) {
				match(' ');
			}
			else if ((LA(1)=='\t') && (true)) {
				match('\t');
			}
			else if ((LA(1)=='\r') && (true)) {
				match('\r');
				newline();
			}
			else if ((LA(1)=='\n') && (true)) {
				match('\n');
				newline();
			}
			else {
				if ( _cnt111>=1 ) { break _loop111; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
			}
			
			_cnt111++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mVAR_ASSIGN(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = VAR_ASSIGN;
		int _saveIndex;
		
		match('=');
		
					// inform the code generator that an assignment was done to
					// AST root for the rule if invoker set refRuleRoot.
					if ( LA(1)!='=' && transInfo!=null && transInfo.refRuleRoot!=null ) {
						transInfo.assignToRoot=true;
					}
				
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mAST_CONSTRUCTOR(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AST_CONSTRUCTOR;
		int _saveIndex;
		Token x=null;
		Token y=null;
		
		_saveIndex=text.length();
		match('[');
		text.setLength(_saveIndex);
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			_saveIndex=text.length();
			mWS(false);
			text.setLength(_saveIndex);
			break;
		}
		case '"':  case '#':  case '(':  case '0':
		case '1':  case '2':  case '3':  case '4':
		case '5':  case '6':  case '7':  case '8':
		case '9':  case ':':  case 'A':  case 'B':
		case 'C':  case 'D':  case 'E':  case 'F':
		case 'G':  case 'H':  case 'I':  case 'J':
		case 'K':  case 'L':  case 'M':  case 'N':
		case 'O':  case 'P':  case 'Q':  case 'R':
		case 'S':  case 'T':  case 'U':  case 'V':
		case 'W':  case 'X':  case 'Y':  case 'Z':
		case '[':  case '_':  case 'a':  case 'b':
		case 'c':  case 'd':  case 'e':  case 'f':
		case 'g':  case 'h':  case 'i':  case 'j':
		case 'k':  case 'l':  case 'm':  case 'n':
		case 'o':  case 'p':  case 'q':  case 'r':
		case 's':  case 't':  case 'u':  case 'v':
		case 'w':  case 'x':  case 'y':  case 'z':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		_saveIndex=text.length();
		mAST_CTOR_ELEMENT(true);
		text.setLength(_saveIndex);
		x=_returnToken;
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			_saveIndex=text.length();
			mWS(false);
			text.setLength(_saveIndex);
			break;
		}
		case ',':  case ']':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		{
		switch ( LA(1)) {
		case ',':
		{
			_saveIndex=text.length();
			match(',');
			text.setLength(_saveIndex);
			{
			switch ( LA(1)) {
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				_saveIndex=text.length();
				mWS(false);
				text.setLength(_saveIndex);
				break;
			}
			case '"':  case '#':  case '(':  case '0':
			case '1':  case '2':  case '3':  case '4':
			case '5':  case '6':  case '7':  case '8':
			case '9':  case ':':  case 'A':  case 'B':
			case 'C':  case 'D':  case 'E':  case 'F':
			case 'G':  case 'H':  case 'I':  case 'J':
			case 'K':  case 'L':  case 'M':  case 'N':
			case 'O':  case 'P':  case 'Q':  case 'R':
			case 'S':  case 'T':  case 'U':  case 'V':
			case 'W':  case 'X':  case 'Y':  case 'Z':
			case '[':  case '_':  case 'a':  case 'b':
			case 'c':  case 'd':  case 'e':  case 'f':
			case 'g':  case 'h':  case 'i':  case 'j':
			case 'k':  case 'l':  case 'm':  case 'n':
			case 'o':  case 'p':  case 'q':  case 'r':
			case 's':  case 't':  case 'u':  case 'v':
			case 'w':  case 'x':  case 'y':  case 'z':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			}
			}
			_saveIndex=text.length();
			mAST_CTOR_ELEMENT(true);
			text.setLength(_saveIndex);
			y=_returnToken;
			{
			switch ( LA(1)) {
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				_saveIndex=text.length();
				mWS(false);
				text.setLength(_saveIndex);
				break;
			}
			case ']':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			}
			}
			break;
		}
		case ']':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		_saveIndex=text.length();
		match(']');
		text.setLength(_saveIndex);
		
		//			System.out.println("AST_CONSTRUCTOR: "+((x==null)?"null":x.getText())+
		//									 ", "+((y==null)?"null":y.getText()));
					String ys = generator.processStringForASTConstructor(x.getText());
		
					// the second does not need processing coz it's a string
					// (eg second param of astFactory.create(x,y)
					if ( y!=null )
						ys += ","+y.getText();
		
					text.setLength(_begin); text.append( generator.getASTCreateString(null,ys) );
				
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTEXT_ARG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TEXT_ARG;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '\t':  case '\n':  case '\r':  case ' ':
		{
			mWS(false);
			break;
		}
		case '"':  case '$':  case '\'':  case '+':
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':  case ':':  case 'A':
		case 'B':  case 'C':  case 'D':  case 'E':
		case 'F':  case 'G':  case 'H':  case 'I':
		case 'J':  case 'K':  case 'L':  case 'M':
		case 'N':  case 'O':  case 'P':  case 'Q':
		case 'R':  case 'S':  case 'T':  case 'U':
		case 'V':  case 'W':  case 'X':  case 'Y':
		case 'Z':  case '_':  case 'a':  case 'b':
		case 'c':  case 'd':  case 'e':  case 'f':
		case 'g':  case 'h':  case 'i':  case 'j':
		case 'k':  case 'l':  case 'm':  case 'n':
		case 'o':  case 'p':  case 'q':  case 'r':
		case 's':  case 't':  case 'u':  case 'v':
		case 'w':  case 'x':  case 'y':  case 'z':
		{
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		{
		int _cnt51=0;
		_loop51:
		do {
			if ((_tokenSet_5.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				mTEXT_ARG_ELEMENT(false);
				{
				if ((_tokenSet_3.member(LA(1))) && (_tokenSet_6.member(LA(2)))) {
					mWS(false);
				}
				else if ((_tokenSet_6.member(LA(1))) && (true)) {
				}
				else {
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				
				}
			}
			else {
				if ( _cnt51>=1 ) { break _loop51; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
			}
			
			_cnt51++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTREE_ELEMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TREE_ELEMENT;
		int _saveIndex;
		Token id=null;
		boolean was_mapped;
		
		switch ( LA(1)) {
		case '(':
		{
			mTREE(false);
			break;
		}
		case '[':
		{
			mAST_CONSTRUCTOR(false);
			break;
		}
		case ':':  case 'A':  case 'B':  case 'C':
		case 'D':  case 'E':  case 'F':  case 'G':
		case 'H':  case 'I':  case 'J':  case 'K':
		case 'L':  case 'M':  case 'N':  case 'O':
		case 'P':  case 'Q':  case 'R':  case 'S':
		case 'T':  case 'U':  case 'V':  case 'W':
		case 'X':  case 'Y':  case 'Z':  case '_':
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			mID_ELEMENT(false);
			break;
		}
		case '"':
		{
			mSTRING(false);
			break;
		}
		default:
			if ((LA(1)=='#') && (LA(2)=='(')) {
				_saveIndex=text.length();
				match('#');
				text.setLength(_saveIndex);
				mTREE(false);
			}
			else if ((LA(1)=='#') && (LA(2)=='[')) {
				_saveIndex=text.length();
				match('#');
				text.setLength(_saveIndex);
				mAST_CONSTRUCTOR(false);
			}
			else if ((LA(1)=='#') && (_tokenSet_2.member(LA(2)))) {
				_saveIndex=text.length();
				match('#');
				text.setLength(_saveIndex);
				was_mapped=mID_ELEMENT(true);
				id=_returnToken;
					// RK: I have a queer feeling that this maptreeid is redundant..
							if ( ! was_mapped )
							{
								String t = generator.mapTreeId(id.getText(), null);
								text.setLength(_begin); text.append(t);
							}
						
			}
			else if ((LA(1)=='#') && (LA(2)=='#')) {
				match("##");
				String t = currentRule.getRuleName()+"_AST"; text.setLength(_begin); text.append(t);
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
/** An ID_ELEMENT can be a func call, array ref, simple var,
 *  or AST label ref.
 */
	protected final boolean  mID_ELEMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		boolean mapped=false;
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ID_ELEMENT;
		int _saveIndex;
		Token id=null;
		
		mID(true);
		id=_returnToken;
		{
		if ((_tokenSet_3.member(LA(1))) && (_tokenSet_7.member(LA(2)))) {
			_saveIndex=text.length();
			mWS(false);
			text.setLength(_saveIndex);
		}
		else if ((_tokenSet_7.member(LA(1))) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		}
		{
		switch ( LA(1)) {
		case '(':  case '<':
		{
			{
			switch ( LA(1)) {
			case '<':
			{
				match('<');
				{
				_loop34:
				do {
					if ((_tokenSet_8.member(LA(1)))) {
						matchNot('>');
					}
					else {
						break _loop34;
					}
					
				} while (true);
				}
				match('>');
				break;
			}
			case '(':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			}
			}
			match('(');
			{
			if ((_tokenSet_3.member(LA(1))) && (_tokenSet_9.member(LA(2)))) {
				_saveIndex=text.length();
				mWS(false);
				text.setLength(_saveIndex);
			}
			else if ((_tokenSet_9.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			
			}
			{
			switch ( LA(1)) {
			case '"':  case '#':  case '\'':  case '(':
			case '0':  case '1':  case '2':  case '3':
			case '4':  case '5':  case '6':  case '7':
			case '8':  case '9':  case ':':  case 'A':
			case 'B':  case 'C':  case 'D':  case 'E':
			case 'F':  case 'G':  case 'H':  case 'I':
			case 'J':  case 'K':  case 'L':  case 'M':
			case 'N':  case 'O':  case 'P':  case 'Q':
			case 'R':  case 'S':  case 'T':  case 'U':
			case 'V':  case 'W':  case 'X':  case 'Y':
			case 'Z':  case '[':  case '_':  case 'a':
			case 'b':  case 'c':  case 'd':  case 'e':
			case 'f':  case 'g':  case 'h':  case 'i':
			case 'j':  case 'k':  case 'l':  case 'm':
			case 'n':  case 'o':  case 'p':  case 'q':
			case 'r':  case 's':  case 't':  case 'u':
			case 'v':  case 'w':  case 'x':  case 'y':
			case 'z':
			{
				mARG(false);
				{
				_loop39:
				do {
					if ((LA(1)==',')) {
						match(',');
						{
						switch ( LA(1)) {
						case '\t':  case '\n':  case '\r':  case ' ':
						{
							_saveIndex=text.length();
							mWS(false);
							text.setLength(_saveIndex);
							break;
						}
						case '"':  case '#':  case '\'':  case '(':
						case '0':  case '1':  case '2':  case '3':
						case '4':  case '5':  case '6':  case '7':
						case '8':  case '9':  case ':':  case 'A':
						case 'B':  case 'C':  case 'D':  case 'E':
						case 'F':  case 'G':  case 'H':  case 'I':
						case 'J':  case 'K':  case 'L':  case 'M':
						case 'N':  case 'O':  case 'P':  case 'Q':
						case 'R':  case 'S':  case 'T':  case 'U':
						case 'V':  case 'W':  case 'X':  case 'Y':
						case 'Z':  case '[':  case '_':  case 'a':
						case 'b':  case 'c':  case 'd':  case 'e':
						case 'f':  case 'g':  case 'h':  case 'i':
						case 'j':  case 'k':  case 'l':  case 'm':
						case 'n':  case 'o':  case 'p':  case 'q':
						case 'r':  case 's':  case 't':  case 'u':
						case 'v':  case 'w':  case 'x':  case 'y':
						case 'z':
						{
							break;
						}
						default:
						{
							throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
						}
						}
						}
						mARG(false);
					}
					else {
						break _loop39;
					}
					
				} while (true);
				}
				break;
			}
			case '\t':  case '\n':  case '\r':  case ' ':
			case ')':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			}
			}
			{
			switch ( LA(1)) {
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				_saveIndex=text.length();
				mWS(false);
				text.setLength(_saveIndex);
				break;
			}
			case ')':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			}
			}
			match(')');
			break;
		}
		case '[':
		{
			{
			int _cnt44=0;
			_loop44:
			do {
				if ((LA(1)=='[')) {
					match('[');
					{
					switch ( LA(1)) {
					case '\t':  case '\n':  case '\r':  case ' ':
					{
						_saveIndex=text.length();
						mWS(false);
						text.setLength(_saveIndex);
						break;
					}
					case '"':  case '#':  case '\'':  case '(':
					case '0':  case '1':  case '2':  case '3':
					case '4':  case '5':  case '6':  case '7':
					case '8':  case '9':  case ':':  case 'A':
					case 'B':  case 'C':  case 'D':  case 'E':
					case 'F':  case 'G':  case 'H':  case 'I':
					case 'J':  case 'K':  case 'L':  case 'M':
					case 'N':  case 'O':  case 'P':  case 'Q':
					case 'R':  case 'S':  case 'T':  case 'U':
					case 'V':  case 'W':  case 'X':  case 'Y':
					case 'Z':  case '[':  case '_':  case 'a':
					case 'b':  case 'c':  case 'd':  case 'e':
					case 'f':  case 'g':  case 'h':  case 'i':
					case 'j':  case 'k':  case 'l':  case 'm':
					case 'n':  case 'o':  case 'p':  case 'q':
					case 'r':  case 's':  case 't':  case 'u':
					case 'v':  case 'w':  case 'x':  case 'y':
					case 'z':
					{
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
					}
					}
					}
					mARG(false);
					{
					switch ( LA(1)) {
					case '\t':  case '\n':  case '\r':  case ' ':
					{
						_saveIndex=text.length();
						mWS(false);
						text.setLength(_saveIndex);
						break;
					}
					case ']':
					{
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
					}
					}
					}
					match(']');
				}
				else {
					if ( _cnt44>=1 ) { break _loop44; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
				}
				
				_cnt44++;
			} while (true);
			}
			break;
		}
		case '.':
		{
			match('.');
			mID_ELEMENT(false);
			break;
		}
		case ':':
		{
			match("::");
			mID_ELEMENT(false);
			break;
		}
		default:
			if ((LA(1)=='-') && (LA(2)=='>')) {
				match("->");
				mID_ELEMENT(false);
			}
			else if ((_tokenSet_10.member(LA(1))) && (true)) {
				
								mapped = true;
								String t = generator.mapTreeId(id.getText(), transInfo);
								text.setLength(_begin); text.append(t);
							
				{
				if (((_tokenSet_11.member(LA(1))) && (_tokenSet_10.member(LA(2))))&&(transInfo!=null && transInfo.refRuleRoot!=null)) {
					{
					switch ( LA(1)) {
					case '\t':  case '\n':  case '\r':  case ' ':
					{
						mWS(false);
						break;
					}
					case '=':
					{
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
					}
					}
					}
					mVAR_ASSIGN(false);
				}
				else if ((_tokenSet_12.member(LA(1))) && (true)) {
				}
				else {
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				
				}
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
		return mapped;
	}
	
/** The arguments of a #[...] constructor are text, token type,
 *  or a tree.
 */
	protected final void mAST_CTOR_ELEMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = AST_CTOR_ELEMENT;
		int _saveIndex;
		
		if ((LA(1)=='"') && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
			mSTRING(false);
		}
		else if ((_tokenSet_13.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
			mTREE_ELEMENT(false);
		}
		else if (((LA(1) >= '0' && LA(1) <= '9'))) {
			mINT(false);
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mINT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT;
		int _saveIndex;
		
		{
		int _cnt102=0;
		_loop102:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9'))) {
				mDIGIT(false);
			}
			else {
				if ( _cnt102>=1 ) { break _loop102; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
			}
			
			_cnt102++;
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mARG(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ARG;
		int _saveIndex;
		
		{
		switch ( LA(1)) {
		case '\'':
		{
			mCHAR(false);
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			mINT_OR_FLOAT(false);
			break;
		}
		default:
			if ((_tokenSet_13.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				mTREE_ELEMENT(false);
			}
			else if ((LA(1)=='"') && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				mSTRING(false);
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		{
		_loop72:
		do {
			if ((_tokenSet_14.member(LA(1))) && (_tokenSet_15.member(LA(2)))) {
				{
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWS(false);
					break;
				}
				case '*':  case '+':  case '-':  case '/':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				}
				}
				{
				switch ( LA(1)) {
				case '+':
				{
					match('+');
					break;
				}
				case '-':
				{
					match('-');
					break;
				}
				case '*':
				{
					match('*');
					break;
				}
				case '/':
				{
					match('/');
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				}
				}
				{
				switch ( LA(1)) {
				case '\t':  case '\n':  case '\r':  case ' ':
				{
					mWS(false);
					break;
				}
				case '"':  case '#':  case '\'':  case '(':
				case '0':  case '1':  case '2':  case '3':
				case '4':  case '5':  case '6':  case '7':
				case '8':  case '9':  case ':':  case 'A':
				case 'B':  case 'C':  case 'D':  case 'E':
				case 'F':  case 'G':  case 'H':  case 'I':
				case 'J':  case 'K':  case 'L':  case 'M':
				case 'N':  case 'O':  case 'P':  case 'Q':
				case 'R':  case 'S':  case 'T':  case 'U':
				case 'V':  case 'W':  case 'X':  case 'Y':
				case 'Z':  case '[':  case '_':  case 'a':
				case 'b':  case 'c':  case 'd':  case 'e':
				case 'f':  case 'g':  case 'h':  case 'i':
				case 'j':  case 'k':  case 'l':  case 'm':
				case 'n':  case 'o':  case 'p':  case 'q':
				case 'r':  case 's':  case 't':  case 'u':
				case 'v':  case 'w':  case 'x':  case 'y':
				case 'z':
				{
					break;
				}
				default:
				{
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				}
				}
				mARG(false);
			}
			else {
				break _loop72;
			}
			
		} while (true);
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTEXT_ARG_ELEMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TEXT_ARG_ELEMENT;
		int _saveIndex;
		
		switch ( LA(1)) {
		case ':':  case 'A':  case 'B':  case 'C':
		case 'D':  case 'E':  case 'F':  case 'G':
		case 'H':  case 'I':  case 'J':  case 'K':
		case 'L':  case 'M':  case 'N':  case 'O':
		case 'P':  case 'Q':  case 'R':  case 'S':
		case 'T':  case 'U':  case 'V':  case 'W':
		case 'X':  case 'Y':  case 'Z':  case '_':
		case 'a':  case 'b':  case 'c':  case 'd':
		case 'e':  case 'f':  case 'g':  case 'h':
		case 'i':  case 'j':  case 'k':  case 'l':
		case 'm':  case 'n':  case 'o':  case 'p':
		case 'q':  case 'r':  case 's':  case 't':
		case 'u':  case 'v':  case 'w':  case 'x':
		case 'y':  case 'z':
		{
			mTEXT_ARG_ID_ELEMENT(false);
			break;
		}
		case '"':
		{
			mSTRING(false);
			break;
		}
		case '\'':
		{
			mCHAR(false);
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		case '4':  case '5':  case '6':  case '7':
		case '8':  case '9':
		{
			mINT_OR_FLOAT(false);
			break;
		}
		case '$':
		{
			mTEXT_ITEM(false);
			break;
		}
		case '+':
		{
			match('+');
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mTEXT_ARG_ID_ELEMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = TEXT_ARG_ID_ELEMENT;
		int _saveIndex;
		Token id=null;
		
		mID(true);
		id=_returnToken;
		{
		if ((_tokenSet_3.member(LA(1))) && (_tokenSet_16.member(LA(2)))) {
			_saveIndex=text.length();
			mWS(false);
			text.setLength(_saveIndex);
		}
		else if ((_tokenSet_16.member(LA(1))) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		}
		{
		switch ( LA(1)) {
		case '(':
		{
			match('(');
			{
			if ((_tokenSet_3.member(LA(1))) && (_tokenSet_17.member(LA(2)))) {
				_saveIndex=text.length();
				mWS(false);
				text.setLength(_saveIndex);
			}
			else if ((_tokenSet_17.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			
			}
			{
			_loop60:
			do {
				if ((_tokenSet_18.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
					mTEXT_ARG(false);
					{
					_loop59:
					do {
						if ((LA(1)==',')) {
							match(',');
							mTEXT_ARG(false);
						}
						else {
							break _loop59;
						}
						
					} while (true);
					}
				}
				else {
					break _loop60;
				}
				
			} while (true);
			}
			{
			switch ( LA(1)) {
			case '\t':  case '\n':  case '\r':  case ' ':
			{
				_saveIndex=text.length();
				mWS(false);
				text.setLength(_saveIndex);
				break;
			}
			case ')':
			{
				break;
			}
			default:
			{
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			}
			}
			match(')');
			break;
		}
		case '[':
		{
			{
			int _cnt65=0;
			_loop65:
			do {
				if ((LA(1)=='[')) {
					match('[');
					{
					if ((_tokenSet_3.member(LA(1))) && (_tokenSet_18.member(LA(2)))) {
						_saveIndex=text.length();
						mWS(false);
						text.setLength(_saveIndex);
					}
					else if ((_tokenSet_18.member(LA(1))) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
					}
					else {
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
					}
					
					}
					mTEXT_ARG(false);
					{
					switch ( LA(1)) {
					case '\t':  case '\n':  case '\r':  case ' ':
					{
						_saveIndex=text.length();
						mWS(false);
						text.setLength(_saveIndex);
						break;
					}
					case ']':
					{
						break;
					}
					default:
					{
						throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
					}
					}
					}
					match(']');
				}
				else {
					if ( _cnt65>=1 ) { break _loop65; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
				}
				
				_cnt65++;
			} while (true);
			}
			break;
		}
		case '.':
		{
			match('.');
			mTEXT_ARG_ID_ELEMENT(false);
			break;
		}
		case '-':
		{
			match("->");
			mTEXT_ARG_ID_ELEMENT(false);
			break;
		}
		default:
			if ((LA(1)==':') && (LA(2)==':')) {
				match("::");
				mTEXT_ARG_ID_ELEMENT(false);
			}
			else if ((_tokenSet_6.member(LA(1))) && (true)) {
			}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mINT_OR_FLOAT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = INT_OR_FLOAT;
		int _saveIndex;
		
		{
		int _cnt105=0;
		_loop105:
		do {
			if (((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_19.member(LA(2)))) {
				mDIGIT(false);
			}
			else {
				if ( _cnt105>=1 ) { break _loop105; } else {throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());}
			}
			
			_cnt105++;
		} while (true);
		}
		{
		if ((LA(1)=='L') && (_tokenSet_20.member(LA(2)))) {
			match('L');
		}
		else if ((LA(1)=='l') && (_tokenSet_20.member(LA(2)))) {
			match('l');
		}
		else if ((LA(1)=='.')) {
			match('.');
			{
			_loop108:
			do {
				if (((LA(1) >= '0' && LA(1) <= '9')) && (_tokenSet_20.member(LA(2)))) {
					mDIGIT(false);
				}
				else {
					break _loop108;
				}
				
			} while (true);
			}
		}
		else if ((_tokenSet_20.member(LA(1))) && (true)) {
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mSL_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = SL_COMMENT;
		int _saveIndex;
		
		match("//");
		{
		_loop82:
		do {
			// nongreedy exit test
			if ((LA(1)=='\n'||LA(1)=='\r') && (true)) break _loop82;
			if (((LA(1) >= '\u0003' && LA(1) <= '~')) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				matchNot(EOF_CHAR);
			}
			else {
				break _loop82;
			}
			
		} while (true);
		}
		{
		if ((LA(1)=='\r') && (LA(2)=='\n')) {
			match("\r\n");
		}
		else if ((LA(1)=='\n')) {
			match('\n');
		}
		else if ((LA(1)=='\r') && (true)) {
			match('\r');
		}
		else {
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		
		}
		newline();
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mML_COMMENT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ML_COMMENT;
		int _saveIndex;
		
		match("/*");
		{
		_loop86:
		do {
			// nongreedy exit test
			if ((LA(1)=='*') && (LA(2)=='/')) break _loop86;
			if ((LA(1)=='\r') && (LA(2)=='\n')) {
				match('\r');
				match('\n');
				newline();
			}
			else if ((LA(1)=='\r') && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				match('\r');
				newline();
			}
			else if ((LA(1)=='\n') && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				match('\n');
				newline();
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '~')) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				matchNot(EOF_CHAR);
			}
			else {
				break _loop86;
			}
			
		} while (true);
		}
		match("*/");
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mESC(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = ESC;
		int _saveIndex;
		
		match('\\');
		{
		switch ( LA(1)) {
		case 'n':
		{
			match('n');
			break;
		}
		case 'r':
		{
			match('r');
			break;
		}
		case 't':
		{
			match('t');
			break;
		}
		case 'b':
		{
			match('b');
			break;
		}
		case 'f':
		{
			match('f');
			break;
		}
		case '"':
		{
			match('"');
			break;
		}
		case '\'':
		{
			match('\'');
			break;
		}
		case '\\':
		{
			match('\\');
			break;
		}
		case '0':  case '1':  case '2':  case '3':
		{
			{
			matchRange('0','3');
			}
			{
			if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				mDIGIT(false);
				{
				if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
					mDIGIT(false);
				}
				else if (((LA(1) >= '\u0003' && LA(1) <= '~')) && (true)) {
				}
				else {
					throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
				}
				
				}
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '~')) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			
			}
			break;
		}
		case '4':  case '5':  case '6':  case '7':
		{
			{
			matchRange('4','7');
			}
			{
			if (((LA(1) >= '0' && LA(1) <= '9')) && ((LA(2) >= '\u0003' && LA(2) <= '~'))) {
				mDIGIT(false);
			}
			else if (((LA(1) >= '\u0003' && LA(1) <= '~')) && (true)) {
			}
			else {
				throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
			}
			
			}
			break;
		}
		default:
		{
			throw new NoViableAltForCharException((char)LA(1), getFilename(), getLine());
		}
		}
		}
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	protected final void mDIGIT(boolean _createToken) throws RecognitionException, CharStreamException, TokenStreamException {
		int _ttype; Token _token=null; int _begin=text.length();
		_ttype = DIGIT;
		int _saveIndex;
		
		matchRange('0','9');
		if ( _createToken && _token==null && _ttype!=Token.SKIP ) {
			_token = makeToken(_ttype);
			_token.setText(new String(text.getBuffer(), _begin, text.length()-_begin));
		}
		_returnToken = _token;
	}
	
	
	 private static final long[] _tokenSet_0_data_ = {-141407503262728L, 9223372036854775807L, 0L, 0L};
	public static final BitSet _tokenSet_0 = new BitSet(_tokenSet_0_data_);
	 private static final long[] _tokenSet_1_data_ = {-145135534866440L, 9223372036854775807L, 0L, 0L};
	public static final BitSet _tokenSet_1 = new BitSet(_tokenSet_1_data_);
	 private static final long[] _tokenSet_2_data_ = {288230376151711744L, 576460745995190270L, 0L, 0L};
	public static final BitSet _tokenSet_2 = new BitSet(_tokenSet_2_data_);
	 private static final long[] _tokenSet_3_data_ = {4294977024L, 0L, 0L};
	public static final BitSet _tokenSet_3 = new BitSet(_tokenSet_3_data_);
	 private static final long[] _tokenSet_4_data_ = {576179277326712832L, 576460745995190270L, 0L, 0L};
	public static final BitSet _tokenSet_4 = new BitSet(_tokenSet_4_data_);
	 private static final long[] _tokenSet_5_data_ = {576188709074894848L, 576460745995190270L, 0L, 0L};
	public static final BitSet _tokenSet_5 = new BitSet(_tokenSet_5_data_);
	 private static final long[] _tokenSet_6_data_ = {576208504579171840L, 576460746532061182L, 0L, 0L};
	public static final BitSet _tokenSet_6 = new BitSet(_tokenSet_6_data_);
	 private static final long[] _tokenSet_7_data_ = {3747275269732312576L, 671088640L, 0L, 0L};
	public static final BitSet _tokenSet_7 = new BitSet(_tokenSet_7_data_);
	 private static final long[] _tokenSet_8_data_ = {-4611686018427387912L, 9223372036854775807L, 0L, 0L};
	public static final BitSet _tokenSet_8 = new BitSet(_tokenSet_8_data_);
	 private static final long[] _tokenSet_9_data_ = {576183181451994624L, 576460746129407998L, 0L, 0L};
	public static final BitSet _tokenSet_9 = new BitSet(_tokenSet_9_data_);
	 private static final long[] _tokenSet_10_data_ = {2306051920717948416L, 536870912L, 0L, 0L};
	public static final BitSet _tokenSet_10 = new BitSet(_tokenSet_10_data_);
	 private static final long[] _tokenSet_11_data_ = {2305843013508670976L, 0L, 0L};
	public static final BitSet _tokenSet_11 = new BitSet(_tokenSet_11_data_);
	 private static final long[] _tokenSet_12_data_ = {208911504254464L, 536870912L, 0L, 0L};
	public static final BitSet _tokenSet_12 = new BitSet(_tokenSet_12_data_);
	 private static final long[] _tokenSet_13_data_ = {288231527202947072L, 576460746129407998L, 0L, 0L};
	public static final BitSet _tokenSet_13 = new BitSet(_tokenSet_13_data_);
	 private static final long[] _tokenSet_14_data_ = {189120294954496L, 0L, 0L};
	public static final BitSet _tokenSet_14 = new BitSet(_tokenSet_14_data_);
	 private static final long[] _tokenSet_15_data_ = {576370098428716544L, 576460746129407998L, 0L, 0L};
	public static final BitSet _tokenSet_15 = new BitSet(_tokenSet_15_data_);
	 private static final long[] _tokenSet_16_data_ = {576315157207066112L, 576460746666278910L, 0L, 0L};
	public static final BitSet _tokenSet_16 = new BitSet(_tokenSet_16_data_);
	 private static final long[] _tokenSet_17_data_ = {576190912393127424L, 576460745995190270L, 0L, 0L};
	public static final BitSet _tokenSet_17 = new BitSet(_tokenSet_17_data_);
	 private static final long[] _tokenSet_18_data_ = {576188713369871872L, 576460745995190270L, 0L, 0L};
	public static final BitSet _tokenSet_18 = new BitSet(_tokenSet_18_data_);
	 private static final long[] _tokenSet_19_data_ = {576459193230304768L, 576460746532061182L, 0L, 0L};
	public static final BitSet _tokenSet_19 = new BitSet(_tokenSet_19_data_);
	 private static final long[] _tokenSet_20_data_ = {576388824486127104L, 576460746532061182L, 0L, 0L};
	public static final BitSet _tokenSet_20 = new BitSet(_tokenSet_20_data_);
	
	}
