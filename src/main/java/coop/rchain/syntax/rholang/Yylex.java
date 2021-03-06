// This JLex file was machine-generated by the BNF converter
package coop.rchain.syntax.rholang;
import java_cup.runtime.*;


public class Yylex implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;

  String pstring = new String();
  public int line_num() { return (yyline+1); }
  public String buff() {return new String(yy_buffer,yy_buffer_index,10).trim();}
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Yylex (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Yylex (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Yylex () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
	}

	private boolean yy_eof_done = false;
	private final int STRING = 5;
	private final int ESCAPED = 6;
	private final int YYINITIAL = 0;
	private final int COMMENT = 1;
	private final int CHAREND = 4;
	private final int CHARESC = 3;
	private final int CHAR = 2;
	private final int yy_state_dtrans[] = {
		0,
		89,
		91,
		93,
		95,
		97,
		99
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NO_ANCHOR,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NO_ANCHOR,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NO_ANCHOR,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NO_ANCHOR,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NOT_ACCEPT,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NOT_ACCEPT,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NOT_ACCEPT,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NOT_ACCEPT,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NOT_ACCEPT,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NOT_ACCEPT,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NOT_ACCEPT,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NOT_ACCEPT,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NOT_ACCEPT,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NOT_ACCEPT,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NOT_ACCEPT,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NOT_ACCEPT,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"44:9,50,43,44,50,42,44:18,50,3,49,2,44:3,48,4,5,1,23,13,16,22,6,47:10,7,17," +
"15,11,18,44,14,45:12,19,27,45:12,24,10,25,44,26,44,20,46,30,46,32,37,46,39," +
"28,46:2,29,38,34,33,21,46,36,31,35,41,46,40,46:3,8,12,9,44:66,45:23,44,45:7" +
",46:24,44,46:8,44:65280,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,133,
"0,1:3,2,1:2,3,1:2,4,1:3,5,1:2,6,7,8,1:6,9,1:11,8:2,1,10,8:3,11,8:3,1,8:6,12" +
",1:16,13,14,15,16,1,17,18,19,20,21,22,23,24,25,16,26,27,28,29,30,31,32,33,3" +
"4,35,36,37,38,39,40,41,42,43,10,44,45,46,47,48,49,50,51,52,53,10,54,55,56,5" +
"7,58,59,60,61,62,63,64,65,66,67,68")[0];

	private int yy_nxt[][] = unpackFromString(69,51,
"1,2,3,4,5,6,7,73,8,9,-1,10,11,12,13,14,15,16,17,18,19,127,20,21,22,23,24,10" +
"2,75,19,118,103,19:2,105,119,19,107,128,19,120,19,25:2,-1,117,19,26,27,28,2" +
"5,-1:62,29,-1:40,30,-1:4,78,31,-1:54,33,-1:6,34,-1:43,35,-1:4,36,-1:45,37,-" +
"1:55,117,-1:2,117,104,106,-1:4,117:2,106:14,-1:3,117,106,117:2,-1:18,19,-1:" +
"2,19:3,-1:4,19:16,-1:3,19:4,-1:24,81,-1:24,26,-1:19,117,-1:2,117,106:2,-1:4" +
",117:2,106:14,-1:3,117,106,117:2,-1:34,85,-1:14,45,-1:9,58,-1:54,32,-1:56,1" +
"17,-1:2,117,106:2,-1:4,117:2,106,41,106:12,-1:3,117,106,117:2,-1:18,19,-1:2" +
",19:3,-1:4,19:8,38,19:2,39,19:4,-1:3,19:4,-1:49,76,-1:4,78:42,40,78:7,-1:4," +
"83,-1:11,117,-1:2,117,106:2,-1:4,117:2,106:14,-1:3,117,106,117:2,-1:18,19,-" +
"1:2,19:3,-1:4,19:12,42,19:3,-1:3,19:4,-1:49,45,-1:19,19,-1:2,19:3,-1:4,19:1" +
"4,43,19,-1:3,19:4,-1:7,49,-1:61,19,-1:2,19:3,-1:4,19:10,44,19:5,-1:3,19:4,-" +
"1:18,87,-1:30,76,-1:19,19,-1:2,19:3,-1:4,19:6,46,19:9,-1:3,19:4,-1:18,19,-1" +
":2,19:3,-1:4,19:6,47,19:9,-1:3,19:4,-1:2,1,56,77:40,-1,57,77:7,-1:16,19,-1:" +
"2,19:3,-1:4,19:13,48,19:2,-1:3,19:4,-1:2,1,59:9,60,59:37,-1,59:2,-1:16,19,-" +
"1:2,19:3,-1:4,19:9,50,19:6,-1:3,19:4,-1:2,1,61:33,62,63,61:6,-1:2,61:7,-1:1" +
"6,19,-1:2,19:3,-1:4,19:3,51,19:12,-1:3,19:4,-1:2,1,-1:47,64,-1:18,19,-1:2,1" +
"9:3,-1:4,19:6,52,19:9,-1:3,19:4,-1:2,1,65:9,66,65:31,-1:2,65:5,67,65,-1:16," +
"19,-1:2,19:3,-1:4,19:13,53,19:2,-1:3,19:4,-1:2,1,68:9,69,68:23,70,71,68:6,-" +
"1:2,68:5,72,68,-1:16,19,-1:2,19:3,-1:4,19:9,54,19:6,-1:3,19:4,-1:18,19,-1:2" +
",19:3,-1:4,19:9,55,19:6,-1:3,19:4,-1:18,117,-1:2,117,106:2,-1:4,117:2,74,10" +
"6:13,-1:3,117,106,117:2,-1:18,19,-1:2,19:3,-1:4,19:6,129,19:8,80,-1:3,19:4," +
"-1:18,117,-1:2,117,106,79,-1:4,117:2,106:14,-1:3,117,106,117:2,-1:18,19,-1:" +
"2,19:3,-1:4,19:6,82,19:9,-1:3,19:4,-1:18,19,-1:2,19,123,19,-1:4,19:7,84,19:" +
"8,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:5,86,19:10,-1:3,19:4,-1:18,19,-1:2,1" +
"9:3,-1:4,19:15,88,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:9,90,19:6,-1:3,19:4," +
"-1:18,19,-1:2,19:3,-1:4,19:8,92,19:7,-1:3,19:4,-1:18,19,-1:2,19,94,19,-1:4," +
"19:16,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:5,96,19:10,-1:3,19:4,-1:18,19,-1" +
":2,19:3,-1:4,19:4,98,19:11,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:4,100,19:11" +
",-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:4,101,19:11,-1:3,19:4,-1:18,19,-1:2,1" +
"9,108,19,-1:4,19:7,132,19:8,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:7,122,19:2" +
",109,19:5,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:2,110,19:13,-1:3,19:4,-1:18," +
"19,-1:2,19:3,-1:4,19:2,111,19:13,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:9,112" +
",19:6,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:3,113,19:12,-1:3,19:4,-1:18,19,-" +
"1:2,19:3,-1:4,19:9,114,19:6,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:6,115,19:9" +
",-1:3,19:4,-1:18,19,-1:2,19,116,19,-1:4,19:16,-1:3,19:4,-1:18,19,-1:2,19:3," +
"-1:4,19:10,121,19:5,-1:3,19:4,-1:18,19,-1:2,19,124,19,-1:4,19:16,-1:3,19:4," +
"-1:18,19,-1:2,19:3,-1:4,19:3,125,19:12,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19" +
":10,126,19:5,-1:3,19:4,-1:18,19,-1:2,19:3,-1:4,19:9,130,19:6,-1:3,19:4,-1:1" +
"8,19,-1:2,19:3,-1:4,19:8,131,19:7,-1:3,19:4,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{ return new Symbol(sym._SYMB_0); }
					case -3:
						break;
					case 3:
						{ return new Symbol(sym._SYMB_1); }
					case -4:
						break;
					case 4:
						{ return new Symbol(sym._SYMB_2); }
					case -5:
						break;
					case 5:
						{ return new Symbol(sym._SYMB_3); }
					case -6:
						break;
					case 6:
						{ return new Symbol(sym._SYMB_4); }
					case -7:
						break;
					case 7:
						{ return new Symbol(sym._SYMB_19); }
					case -8:
						break;
					case 8:
						{ return new Symbol(sym._SYMB_6); }
					case -9:
						break;
					case 9:
						{ return new Symbol(sym._SYMB_7); }
					case -10:
						break;
					case 10:
						{ return new Symbol(sym._SYMB_9); }
					case -11:
						break;
					case 11:
						{ return new Symbol(sym._SYMB_10); }
					case -12:
						break;
					case 12:
						{ return new Symbol(sym._SYMB_11); }
					case -13:
						break;
					case 13:
						{ return new Symbol(sym._SYMB_12); }
					case -14:
						break;
					case 14:
						{ return new Symbol(sym._SYMB_21); }
					case -15:
						break;
					case 15:
						{ return new Symbol(sym._SYMB_18); }
					case -16:
						break;
					case 16:
						{ return new Symbol(sym._SYMB_14); }
					case -17:
						break;
					case 17:
						{ return new Symbol(sym._SYMB_23); }
					case -18:
						break;
					case 18:
						{ return new Symbol(sym.Name, yytext().intern()); }
					case -19:
						break;
					case 19:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -20:
						break;
					case 20:
						{ return new Symbol(sym._SYMB_17); }
					case -21:
						break;
					case 21:
						{ return new Symbol(sym._SYMB_20); }
					case -22:
						break;
					case 22:
						{ return new Symbol(sym._SYMB_27); }
					case -23:
						break;
					case 23:
						{ return new Symbol(sym._SYMB_28); }
					case -24:
						break;
					case 24:
						{ return new Symbol(sym._SYMB_29); }
					case -25:
						break;
					case 25:
						{ /* ignore white space. */ }
					case -26:
						break;
					case 26:
						{ return new Symbol(sym._INTEGER_, new Integer(yytext())); }
					case -27:
						break;
					case 27:
						{ yybegin(CHAR); }
					case -28:
						break;
					case 28:
						{ yybegin(STRING); }
					case -29:
						break;
					case 29:
						{ return new Symbol(sym._SYMB_26); }
					case -30:
						break;
					case 30:
						{ yybegin(COMMENT); }
					case -31:
						break;
					case 31:
						{ return new Symbol(sym._SYMB_5); }
					case -32:
						break;
					case 32:
						{ return new Symbol(sym._SYMB_8); }
					case -33:
						break;
					case 33:
						{ return new Symbol(sym._SYMB_25); }
					case -34:
						break;
					case 34:
						{ return new Symbol(sym._SYMB_15); }
					case -35:
						break;
					case 35:
						{ return new Symbol(sym._SYMB_22); }
					case -36:
						break;
					case 36:
						{ return new Symbol(sym._SYMB_13); }
					case -37:
						break;
					case 37:
						{ return new Symbol(sym._SYMB_24); }
					case -38:
						break;
					case 38:
						{ return new Symbol(sym._SYMB_36); }
					case -39:
						break;
					case 39:
						{ return new Symbol(sym._SYMB_35); }
					case -40:
						break;
					case 40:
						{ /* BNFC single-line comment */ }
					case -41:
						break;
					case 41:
						{ return new Symbol(sym._SYMB_30); }
					case -42:
						break;
					case 42:
						{ return new Symbol(sym._SYMB_41); }
					case -43:
						break;
					case 43:
						{ return new Symbol(sym._SYMB_38); }
					case -44:
						break;
					case 44:
						{ return new Symbol(sym._SYMB_34); }
					case -45:
						break;
					case 45:
						{ return new Symbol(sym._DOUBLE_, new Double(yytext())); }
					case -46:
						break;
					case 46:
						{ return new Symbol(sym._SYMB_31); }
					case -47:
						break;
					case 47:
						{ return new Symbol(sym._SYMB_43); }
					case -48:
						break;
					case 48:
						{ return new Symbol(sym._SYMB_44); }
					case -49:
						break;
					case 49:
						{ return new Symbol(sym._SYMB_16); }
					case -50:
						break;
					case 50:
						{ return new Symbol(sym._SYMB_39); }
					case -51:
						break;
					case 51:
						{ return new Symbol(sym._SYMB_42); }
					case -52:
						break;
					case 52:
						{ return new Symbol(sym._SYMB_33); }
					case -53:
						break;
					case 53:
						{ return new Symbol(sym._SYMB_37); }
					case -54:
						break;
					case 54:
						{ return new Symbol(sym._SYMB_40); }
					case -55:
						break;
					case 55:
						{ return new Symbol(sym._SYMB_32); }
					case -56:
						break;
					case 56:
						{ }
					case -57:
						break;
					case 57:
						{ }
					case -58:
						break;
					case 58:
						{ yybegin(YYINITIAL); }
					case -59:
						break;
					case 59:
						{ yybegin(CHAREND); return new Symbol(sym._CHAR_, new Character(yytext().charAt(0))); }
					case -60:
						break;
					case 60:
						{ yybegin(CHARESC); }
					case -61:
						break;
					case 61:
						{ yybegin(CHAREND); return new Symbol(sym._CHAR_, new Character(yytext().charAt(0))); }
					case -62:
						break;
					case 62:
						{ yybegin(CHAREND); return new Symbol(sym._CHAR_, new Character('\n')); }
					case -63:
						break;
					case 63:
						{ yybegin(CHAREND); return new Symbol(sym._CHAR_, new Character('\t')); }
					case -64:
						break;
					case 64:
						{yybegin(YYINITIAL);}
					case -65:
						break;
					case 65:
						{ pstring += yytext(); }
					case -66:
						break;
					case 66:
						{ yybegin(ESCAPED); }
					case -67:
						break;
					case 67:
						{ String foo = pstring; pstring = new String(); yybegin(YYINITIAL); return new Symbol(sym._STRING_, foo.intern()); }
					case -68:
						break;
					case 68:
						{ pstring += yytext(); yybegin(STRING); }
					case -69:
						break;
					case 69:
						{ pstring += "\\"; yybegin(STRING); }
					case -70:
						break;
					case 70:
						{ pstring +=  "\n"; yybegin(STRING); }
					case -71:
						break;
					case 71:
						{ pstring += "\t"; yybegin(STRING); }
					case -72:
						break;
					case 72:
						{ pstring += "\""; yybegin(STRING); }
					case -73:
						break;
					case 74:
						{ return new Symbol(sym.Name, yytext().intern()); }
					case -74:
						break;
					case 75:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -75:
						break;
					case 76:
						{ return new Symbol(sym._DOUBLE_, new Double(yytext())); }
					case -76:
						break;
					case 77:
						{ }
					case -77:
						break;
					case 79:
						{ return new Symbol(sym.Name, yytext().intern()); }
					case -78:
						break;
					case 80:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -79:
						break;
					case 82:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -80:
						break;
					case 84:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -81:
						break;
					case 86:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -82:
						break;
					case 88:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -83:
						break;
					case 90:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -84:
						break;
					case 92:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -85:
						break;
					case 94:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -86:
						break;
					case 96:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -87:
						break;
					case 98:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -88:
						break;
					case 100:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -89:
						break;
					case 101:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -90:
						break;
					case 102:
						{ return new Symbol(sym.Name, yytext().intern()); }
					case -91:
						break;
					case 103:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -92:
						break;
					case 104:
						{ return new Symbol(sym.Name, yytext().intern()); }
					case -93:
						break;
					case 105:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -94:
						break;
					case 106:
						{ return new Symbol(sym.Name, yytext().intern()); }
					case -95:
						break;
					case 107:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -96:
						break;
					case 108:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -97:
						break;
					case 109:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -98:
						break;
					case 110:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -99:
						break;
					case 111:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -100:
						break;
					case 112:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -101:
						break;
					case 113:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -102:
						break;
					case 114:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -103:
						break;
					case 115:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -104:
						break;
					case 116:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -105:
						break;
					case 117:
						{ return new Symbol(sym.Name, yytext().intern()); }
					case -106:
						break;
					case 118:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -107:
						break;
					case 119:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -108:
						break;
					case 120:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -109:
						break;
					case 121:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -110:
						break;
					case 122:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -111:
						break;
					case 123:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -112:
						break;
					case 124:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -113:
						break;
					case 125:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -114:
						break;
					case 126:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -115:
						break;
					case 127:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -116:
						break;
					case 128:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -117:
						break;
					case 129:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -118:
						break;
					case 130:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -119:
						break;
					case 131:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -120:
						break;
					case 132:
						{ return new Symbol(sym.Var, yytext().intern()); }
					case -121:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
