import java.util.ArrayList;

public class MultipleChoiceQuestion extends Question
{
	/** Multiple choice Question Constructor, isMultipleChoice is set to True */
	public MultipleChoiceQuestion(String questionString)
	{
		super(questionString);
		answerChoices = new ArrayList<>();
		isMultipleChoice = true;
	}

	/** Overriden method of addChoice, allows for multiple answers to be correct. */
	@Override
	public void addChoice(Answer choice)
	{
		answerChoices.add(choice);
		if (choice.isCorrect()) {
			correctAnswerCount++;
		}
	}

}
