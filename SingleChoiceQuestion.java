import java.util.ArrayList;

public class SingleChoiceQuestion extends Question
{
	/** Single choice Question Constructor, isMultipleChoice is set to False */
	public SingleChoiceQuestion(String questionString)
	{
		super(questionString);
		answerChoices = new ArrayList<>();
		this.isMultipleChoice = false;
	}

	/** Overriden method of addChoice, allows only one answer to be correct. */
	@Override
	public void addChoice(Answer choice)
	{
		answerChoices.add(choice);
		if (choice.isCorrect()) {
			correctAnswerCount++;
		}
		if (correctAnswerCount != 1) {
			System.out.println("This question can only have one answer");
			System.exit(0);
		}
	}
}
