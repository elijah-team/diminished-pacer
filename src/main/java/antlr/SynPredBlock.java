package antlr;

/* ANTLR Translator Generator
 * Project led by Terence Parr at http://www.jGuru.com
 * Software rights: http://www.antlr.org/RIGHTS.html
 *
 * $Id: //depot/code/org.antlr/release/antlr-2.7.1/antlr/SynPredBlock.java#1 $
 */

class SynPredBlock extends AlternativeBlock {


	public SynPredBlock(Grammar g) {
		super(g);
	}
	public SynPredBlock(Grammar g, int line) {
		super(g, line, false);
	}
	public void generate() {
		grammar.generator.gen(this);
	}
	public Lookahead look(int k) {
		return grammar.theLLkAnalyzer.look(k, this);
	}
	public String toString() {
		return super.toString() + "=>";
	}
}
