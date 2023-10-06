import java.util.List;
import java.util.ArrayList;

/**
 * The Question class is the parent class to implement Question objects.
 * This class contains one abstract method addChoice(), which utlizies a similar functionality of interfaces, 
 * except with method overriding.
 */
public abstract class Question
{
	private String questionString;
	protected List<Answer> answerChoices;
	protected int correctAnswerCount;
	protected boolean isMultipleChoice;

	/** A Question constructor that takes the questionString, and initializes the fields */
	public Question(String questionString)
	{
		this.questionString = questionString;
		answerChoices = new ArrayList<>();
		correctAnswerCount = 0;
		isMultipleChoice = false;
	}

	/** questionString setter method */
	public void setQuestionString(String questionString)
	{
		this.questionString = questionString;
	}

	/** questionString getter method */
	public String getQuestionString()
	{
		return questionString;
	}

	/** rRturns a List of the potenial answer choices for the Question */
	public List<Answer> getAnswerChoices()
	{
		return answerChoices;
	}

	/** Returns a boolean whether the Question is multiple-choice or not */
	public boolean isMultipleChoice()
	{
		return this.isMultipleChoice;
	}

	/** Abstract method to add choices to the Answer List, is overriden by the child classes */
	public abstract void addChoice(Answer choice);
}
