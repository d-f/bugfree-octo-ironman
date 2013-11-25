package data.analysis;

import java.util.HashSet;
import java.util.Set;

import com.aliasi.tokenizer.StopTokenizerFactory;
import com.aliasi.tokenizer.TokenizerFactory;

public class GermanStopWordsTokenizerFactory extends StopTokenizerFactory{

	static final Set<String> STOP_SET = new HashSet<String>();
		
	public GermanStopWordsTokenizerFactory(TokenizerFactory factory,
			Set<String> stopSet) {
		super(factory, stopSet);
		// TODO Auto-generated constructor stub
	}

	public GermanStopWordsTokenizerFactory(TokenizerFactory factory){
		super(factory,STOP_SET);
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2195062869982764963L;

	static{
		STOP_SET.add("aber");
		STOP_SET.add("als");
		STOP_SET.add("am");
		STOP_SET.add("an");
		STOP_SET.add("auch");
		STOP_SET.add("auf");
		STOP_SET.add("aus");
		STOP_SET.add("bei");
		STOP_SET.add("bin");
		STOP_SET.add("bis");
		STOP_SET.add("bist");
		STOP_SET.add("da");
	    STOP_SET.add("dadurch");
	    STOP_SET.add("daher");
	    STOP_SET.add("darum");
	    STOP_SET.add("das");
	    STOP_SET.add("daß");
	    STOP_SET.add("dass");
	    STOP_SET.add("dein");
	    STOP_SET.add("deine");
	    STOP_SET.add("dem");
	    STOP_SET.add("den");
	    STOP_SET.add("der");
	    STOP_SET.add("des");
	    STOP_SET.add("dessen");
	    STOP_SET.add("deshalb");
	    STOP_SET.add("die");
	    STOP_SET.add("dies");
	    STOP_SET.add("dieser");
	    STOP_SET.add("dieses");
	    STOP_SET.add("doch");
	    STOP_SET.add("dort");
	    STOP_SET.add("du");
	    STOP_SET.add("durch");
	    STOP_SET.add("ein");
	    STOP_SET.add("eine");
	    STOP_SET.add("einem");
	    STOP_SET.add("einen");
	    STOP_SET.add("einer");
	    STOP_SET.add("eines");
	    STOP_SET.add("eins");
	    STOP_SET.add("er");
	    STOP_SET.add("es");
	    STOP_SET.add("euer");
	    STOP_SET.add("eure");
	    STOP_SET.add("für");
	    STOP_SET.add("hatte");
	    STOP_SET.add("hatten");
	    STOP_SET.add("hattest");
	    STOP_SET.add("hattet");
	    STOP_SET.add("hier");
	    STOP_SET.add("hinter");
	    STOP_SET.add("ich");
	    STOP_SET.add("ihr");
	    STOP_SET.add("ihre");
	    STOP_SET.add("im");
	    STOP_SET.add("in");
	    STOP_SET.add("ist");
	    STOP_SET.add("ja");
	    STOP_SET.add("jede");
	    STOP_SET.add("jedem");
	    STOP_SET.add("jeden");
	    STOP_SET.add("jeder");
	    STOP_SET.add("jedes");
	    STOP_SET.add("jener");
	    STOP_SET.add("jenes");
	    STOP_SET.add("jetzt");
	    STOP_SET.add("kann");
	    STOP_SET.add("kannst");
	    STOP_SET.add("können");
	    STOP_SET.add("könnt");
	    STOP_SET.add("machen");
	    STOP_SET.add("mein");
	    STOP_SET.add("meine");
	    STOP_SET.add("mich");
	    STOP_SET.add("mit");
	    STOP_SET.add("mir");
	    STOP_SET.add("muß");
	    STOP_SET.add("mußt");
	    STOP_SET.add("musst");
	    STOP_SET.add("müssen");
	    STOP_SET.add("müßt");
	    STOP_SET.add("nach");
	    STOP_SET.add("nachdem");
	    STOP_SET.add("nein");
	    STOP_SET.add("nicht");
	    STOP_SET.add("nun");
	    STOP_SET.add("oder");
	    STOP_SET.add("seid");
	    STOP_SET.add("sein");
	    STOP_SET.add("seine");
	    STOP_SET.add("sich");
	    STOP_SET.add("sie");
	    STOP_SET.add("sind");
	    STOP_SET.add("soll");
	    STOP_SET.add("sollen");
	    STOP_SET.add("sollst");
	    STOP_SET.add("sollt");
	    STOP_SET.add("sonst");
	    STOP_SET.add("soweit");
	    STOP_SET.add("sowie");
	    STOP_SET.add("und");
	    STOP_SET.add("unser");
	    STOP_SET.add("unsere");
	    STOP_SET.add("unter");
	    STOP_SET.add("vom");
	    STOP_SET.add("von");
	    STOP_SET.add("vor");
	    STOP_SET.add("wann");
	    STOP_SET.add("warum");
	    STOP_SET.add("was");
	    STOP_SET.add("wegen");
	    STOP_SET.add("weiter");
	    STOP_SET.add("weitere");
	    STOP_SET.add("wenn");
	    STOP_SET.add("wer");
	    STOP_SET.add("werde");
	    STOP_SET.add("werden");
	    STOP_SET.add("werdet");
	    STOP_SET.add("weshalb");
	    STOP_SET.add("wessen");
	    STOP_SET.add("wie");
	    STOP_SET.add("wieder");
	    STOP_SET.add("wieso");
	    STOP_SET.add("wir");
	    STOP_SET.add("wird");
	    STOP_SET.add("wirst");
	    STOP_SET.add("wo");
	    STOP_SET.add("woher");
	    STOP_SET.add("wohin");
	    STOP_SET.add("zu");
	    STOP_SET.add("zum");
	    STOP_SET.add("zur");
	    STOP_SET.add("über");
	}
	
	
}
