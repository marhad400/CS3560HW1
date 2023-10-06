public class Answer 
{
	private String answerString;
	private boolean isCorrect;

	/** Answer constructor, sets the Answer String and isCorrect boolean */
	public Answer(String answerString, boolean isCorrect)
	{
		setAnswerString(answerString);
		setIsCorrect(isCorrect);
	}

	/** AnswerString getter method */
	public String getAnswerString()
	{
		return answerString;
	}

	/** AnswerString setter method */
	public void setAnswerString(String answerString)
	{
		this.answerString = answerString;
	}

	/** Returns true if Answer is correct, false otherwise*/
	public boolean isCorrect()
	{
		return isCorrect;
	}

	/** Sets the isCorrect boolean */
	public void setIsCorrect(boolean isCorrect)
	{
		this.isCorrect = isCorrect;
	}

	/** toString format to print answer String */
	@Override
	public String toString()
	{
		return String.format("%s", answerString);
	}
}
