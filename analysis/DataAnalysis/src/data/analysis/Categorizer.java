package data.analysis;

import java.io.IOException;
import java.util.Map;

import com.aliasi.classify.Classification;
import com.aliasi.classify.Classified;
import com.aliasi.classify.DynamicLMClassifier;
import com.aliasi.classify.JointClassification;
import com.aliasi.classify.JointClassifier;
import com.aliasi.classify.JointClassifierEvaluator;
import com.aliasi.lm.NGramProcessLM;
import com.aliasi.util.AbstractExternalizable;

public class Categorizer implements ICategorizer {

	private DynamicLMClassifier<NGramProcessLM> classifier;
	private Map<Integer, String> categories;

	private static int NGRAM_SIZE = 6;

	@Override
	public void train(Map<Integer, String> categories, SocialMessage[] socialMessages) {
		this.categories = categories;
		classifier = DynamicLMClassifier.createNGramProcess(
				categories.values().toArray(new String[categories.values().size()]), NGRAM_SIZE);
		for (int i = 0; i < socialMessages.length; ++i) {
			if (socialMessages[i] != null) {
				System.out.print("\n[" + i + "] Training on " + categories.get(socialMessages[i].getCategory()));
				Classification classification = new Classification(categories.get(socialMessages[i].getCategory()));
				Classified<CharSequence> classified = new Classified<CharSequence>(socialMessages[i].getText(),
						classification);
				classifier.handle(classified);
			}
		}
		System.out.println();
	}

	@SuppressWarnings("unchecked")
	@Override
	public void handle(SocialMessage socialMessage) {
		JointClassifier<CharSequence> compiledClassifier;
		JointClassifierEvaluator<CharSequence> evaluator;
		Classification classification;
		Classified<CharSequence> classified;
		JointClassification jc;
		String[] tmp_categories = categories.values().toArray(new String[categories.values().size()]);
		boolean storeCategories = true;

		try {
			compiledClassifier = (JointClassifier<CharSequence>) AbstractExternalizable.compile(classifier);
			evaluator = new JointClassifierEvaluator<CharSequence>(compiledClassifier, tmp_categories, storeCategories);

			classification = new Classification(categories.get(socialMessage.getCategory()));
			classified = new Classified<CharSequence>(socialMessage.getText(), classification);
			evaluator.handle(classified);
			jc = compiledClassifier.classify(socialMessage.getText());
			for (Map.Entry<Integer, String> entry : categories.entrySet()) {
				if (entry.getValue().equalsIgnoreCase(jc.bestCategory())) {
					socialMessage.setCategory(entry.getKey());
				}
			}

			// ConfusionMatrix confMatrix = evaluator.confusionMatrix();
			// System.out.println("Total Accuracy: " +
			// confMatrix.totalAccuracy());
			//
			// System.out.println("\nFULL EVAL");
			// System.out.println(evaluator);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
